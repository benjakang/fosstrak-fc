import org.epcglobalinc.tdt.LevelTypeList;
import org.fosstrak.tdt.TDTEngine;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        try {
            TDTEngine tdt = new TDTEngine();

            Map<String,String> params = new HashMap<String, String>();
            params.put("taglength", "96");
            params.put("filter", "3");
            params.put("companyprefixlength", "7");
            String orig = "gtin=00037000302414;serial=1041970";
            String s = tdt.convert(orig,
                    params,
                    LevelTypeList.BINARY);
            //               ................................................................................................
            String expect = "001100000111010000000010010000100010000000011101100010000100000000000000000011111110011000110010";
            System.out.println(s.equals(expect));


//            Map<String, String> extraparms = new HashMap<String, String>();
//            extraparms.put("taglength", "96");
//            extraparms.put("filter", "3");
//            extraparms.put("companyprefixlength", "7");
//
//            String line = "001100000110100011100101110101100011000011001101000011110010100100011011111001011110100011011100";
//
//            String pureURI = tdt.convert(line, extraparms, LevelTypeList.TAG_ENCODING);
//            System.out.println(pureURI);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
