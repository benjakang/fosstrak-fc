package org.fosstrak.ale.server.readers.smart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.epcglobalinc.tdt.LevelTypeList;
import org.fosstrak.ale.exception.ImplementationException;
import org.fosstrak.ale.server.Tag;
import org.fosstrak.ale.server.readers.BaseReader;
import org.fosstrak.ale.xsd.ale.epcglobal.LRProperty;
import org.fosstrak.ale.xsd.ale.epcglobal.LRSpec;
import org.fosstrak.hal.HardwareException;
import org.fosstrak.hal.Observation;
import org.fosstrak.tdt.TDTEngine;

/**
 * smart adaptor for the filtering and collection triggering tag in regular time intervals.
 * @author benjakang
 *
 */
public class SmartAdaptor extends BaseReader {

    /** logger. */
    private static final Logger log = Logger.getLogger(SmartAdaptor.class);

    private Thread thread = null;

    private Tag[] tagsAsArray;
    private int tagSize;
    private boolean running = false;
    private Server server;

    /**
     * loads a list of tags.
     * @throws Exception upon problems.
     */
    public void loadTags() throws Exception {
        System.out.println("loadTags()");
        List<Tag> tags = new ArrayList<Tag>();
        BufferedReader bis = new BufferedReader(new InputStreamReader(SmartAdaptor.class.getClassLoader().getResourceAsStream("/tags1.txt")));

        URL auxiliary = TDTEngine.class.getClassLoader().getResource("tdtschemes/auxiliary/ManagerTranslation.xml");
        URL schemes = TDTEngine.class.getClassLoader().getResource("tdtschemes/schemes/");
        TDTEngine tdt = new TDTEngine(auxiliary, schemes);

        Map<String, String> extraparms = new HashMap<String, String> ();
        extraparms.put("taglength", "96");
        extraparms.put("filter", "3");
        extraparms.put("gs1companyprefixlength", "7");

//		String line = bis.readLine(); // drop first line with the header line.
        String line;
        while ((line = bis.readLine()) != null) {
            String pureURI = tdt.convert(line, extraparms, LevelTypeList.TAG_ENCODING);

            Tag tag = new Tag();
            tag.setTagAsBinary(line);
            tag.setTagIDAsPureURI(pureURI);
            tags.add(tag);
        }

        tagSize = tags.size();
        tagsAsArray = new Tag[tagSize];
        int i=0;
        for (Tag t : tags) {
            tagsAsArray[i++] = t;
        }
    }

    private class SmartAdaptorRunnable implements Runnable {

        private SmartAdaptor tb = null;

        public SmartAdaptorRunnable(SmartAdaptor target) {
            tb = target;
        }

        public void run() {
//            long tps = Long.parseLong(tb.logicalReaderProperties.get("tps"));
//            long wt = Long.parseLong(tb.logicalReaderProperties.get("wt"));
//            long gain = Long.parseLong(tb.logicalReaderProperties.get("gain"));
//            SmartAdaptor.log.debug(String.format("starting tagbomb\ntps: %s\nwt: %s\ngain: %s\n", tps, wt, gain));
            String readerName = tb.getName();

            while (isRunning()) {
//                SmartAdaptor.log.debug("firing " + tps + " tags");

                // generate tags
                List<Tag> tags = new LinkedList<Tag>();
                synchronized (this) {
                    for (int j = 0; j < tagsAsArray.length; j++) {
                        //一次读取
                        Tag prototype = tagsAsArray[j];
                        Tag tag = new Tag(readerName, null, null, System.currentTimeMillis());
                        tag.setTagAsBinary(prototype.getTagAsBinary());
                        tag.setTagIDAsPureURI(prototype.getTagIDAsPureURI());

                        tags.add(tag);
                    }
                }

                tb.addTags(tags);
            }
            log.info("Stop the test adapter.");
        }

    }

    public SmartAdaptor() {
        super();
    }

    @Override
    public void initialize(String name, LRSpec spec) throws ImplementationException {
        super.initialize(name, spec);
        System.out.println("initialize()");

        try {
            loadTags();
        } catch (Exception e) {
            throw new ImplementationException(e);
        }

    }

    private boolean isRunning() {
        return running;
    }

    @Override
    public void addTag(Tag tag) {
        tag.addTrace(getName());
        System.out.println("addTag()");

        setChanged();
        notifyObservers(tag);
    }

    @Override
    public void addTags(List<Tag> tags) {
        setChanged();
        System.out.println("addTags()");
        for (Tag tag : tags) {
            tag.addTrace(getName());
        }
        notifyObservers(tags);
    }

    @Override
    public void connectReader() {
        setConnected();
        System.out.println("connectReader()");

        server = new Server(this);
        server.connect();
    }

    @Override
    public void disconnectReader() {
        stop();
        setDisconnected();
        System.out.println("disconnectReader()");

        server.disconnect();
    }

    @Override
    public void start() {
        System.out.println("start()");
        if (thread != null) {
            stop();
        }
        running = true;
        thread = new Thread(new SmartAdaptorRunnable(this), getName());
        thread.setDaemon(true);
        thread.start();
        setStarted();
    }

    @Override
    public void stop() {
        System.out.println("stop()");
        log.info("stopping reader.");
        running = false;
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
        thread = null;
        setStopped();
    }

    @Override
    public void update(LRSpec spec) {
        boolean started = isStarted();
        System.out.println("update()");

        disconnectReader();
        logicalReaderSpec = spec;
        logicalReaderProperties = new HashMap<String, String>();
        properties = new LinkedList<LRProperty>();

        if (spec.getProperties() != null) {
            for (LRProperty prop : spec.getProperties().getProperty()) {
                logicalReaderProperties.put(prop.getName(), prop.getValue());
                properties.add(prop);
            }
        }
        connectReader();
        if (started) {
            start();
        }
    }

    @Override
    public Observation[] identify(String[] readPointNames)
            throws HardwareException {
        System.out.println("identify()");
        return null;
    }

    /**
     * a handle to the tags contained in the test adapter.
     * @return the tags.
     */
    public Tag[] getTags() {
        return (Tag[]) ArrayUtils.clone(tagsAsArray);
    }
}
