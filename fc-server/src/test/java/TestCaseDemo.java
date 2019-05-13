import junit.framework.TestCase;
import org.epcglobalinc.tdt.LevelTypeList;
import org.fosstrak.ale.server.readers.test.TestAdaptor;
import org.fosstrak.tdt.TDTEngine;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestCaseDemo {

    private static TDTEngine engine = null;

    private static Map<String,String> params;

    public static void main(String[] args) {
        setUp();
//        testPage13Staged();
    }

    protected static void setUp() {
        params = new HashMap<String,String>();
        if (engine == null) {
            try {
//                engine = new TDTEngine("C:/Users/kangbingjie/.m2/repository/org/fosstrak/tdt/tdt/1.0.0/tdt-1.0.0");

//                engine = new TDTEngine("C:\\Users\\kangbingjie\\.m2\\repository\\org\\fosstrak\\tdt\\tdt\\1.0.0\\tdt-1.0.0");
//                engine = new TDTEngine(new URL(TDTEngine.class.getResource("") , "../../../schemes/"),
//                        new URL(TDTEngine.class.getResource("") , "../../../auxiliary/ManagerTranslation.xml"));
                URL path = TDTEngine.class.getClassLoader().getResource("tdtschemes/");
//                URL path = new URL("file", "", "C:/Users/kangbingjie/.m2/repository/org/fosstrak/tdt/tdt/1.0.0/tdt-1.0.0/");
//                URL path = new URL(TDTEngine.class.getResource("") , "../../../");
                URL scheme = new URL(path, "schemes/");
                URL auxGEPC64table = new URL(path, "auxiliary/ManagerTranslation.xml");
                engine = new TDTEngine(auxGEPC64table,scheme);
//                System.out.println(new URL(TDTEngine.class.getResource("") , "../../../schemes/"));
//                System.out.println(TDTEngine.class.getClassLoader().getResource(""));
            }
            catch (Exception e) {
                e.printStackTrace(System.err);
                //System.exit(1);
            }
        }


    }

    public static void testPage13Staged() {
        // this test follows fig 4 on page 13 of TDT Spec
        // jpb trying this version using a staged approach, only going one level at a time.

        params.put("taglength", "96");
        params.put("filter", "3");
        params.put("gs1companyprefixlength", "7");
        String orig = "gtin=00037000302414;serial=1041970";
        String s = engine.convert(orig,
                params,
                LevelTypeList.BINARY);
        //               ................................................................................................
        String expect = "001100000111010000000010010000100010000000011101100010000100000000000000000011111110011000110010";
//        Assert.assertEquals(expect, s);
        System.out.println(s.equals(expect));


    }
    public void testPage13() {
        // this test follows fig 4 on page 13 of TDT Spec

        params.put("taglength", "96");
        params.put("filter", "3");
        params.put("companyprefixlength", "7");
        String orig = "gtin=00037000302414;serial=1041970";
        String s = engine.convert(orig,
                params,
                LevelTypeList.BINARY);
        //               ................................................................................................
        String expect = "001100000111010000000010010000100010000000011101100010000100000000000000000011111110011000110010";
//        Assert.assertEquals(expect, s);

        String s2 = engine.convert(s,
                params,
                LevelTypeList.LEGACY);
//        Assert.assertEquals(orig, s2);


    }

    public void testPage26() {
        // table 3 on page 26 has some legacy codes. Check that they
        // convert back and forth to binary.

        params.put("taglength", "96");
        params.put("filter", "3");
        params.put("companyprefixlength", "7");
        String legacy [] =
                {"gtin=00037000302414;serial=10419703",
                        "sscc=000370003024147856",
                        "gln=0003700030247;serial=1041970",
                        "grai=00037000302414274877906943",
                        "giai=00370003024149267890123",
                        "generalmanager=5;objectclass=17;serial=23",
                        "cageordodaac=AB123;serial=3789156"
                };

        for (String s : legacy) {
            String s2 = engine.convert(s,
                    params,
                    LevelTypeList.BINARY);
            System.out.println("  " + s + " -> " + s2);
            String s3 = engine.convert(s2,
                    params,
                    LevelTypeList.LEGACY);
            System.out.println("    -> " + s3);
//            Assert.assertEquals(s, s3);
        }

    }

    public void testSgtin64() {
        params.put("taglength", "64");
        params.put("filter", "3");
        params.put("companyprefixlength", "7");
        String orig = "gtin=20073796510026;serial=1";
        String s = engine.convert(orig,
                params,
                LevelTypeList.BINARY);
        //               ................................................................................................
        String expect = "1001100000010011110001111010100011110100000000000000000000000001";
        //                  9   8   1   3   c   7   a   8   f   4   0   0   0   0   0   1
//        Assert.assertEquals(expect, s);
    }


    public void testUsDod96() {
        params.put("taglength", "96");
        params.put("filter", "0");
        String orig = "cageordodaac=2S194;serial=12345678901";
        String s = engine.convert(orig,
                params,
                LevelTypeList.BINARY);
        //               ................................................................................................
        String expect = "001011110000001000000011001001010011001100010011100100110100001011011111110111000001110000110101";
        //                  2   f   0   2   0   3   2   5   3   3   1   3   9   3   4   2   d   f   d   c   1   c   3   5
//        Assert.assertEquals(expect, s);
    }

    public void testUsDod64() {
        params.put("taglength", "64");
        params.put("filter", "1");
        String orig = "cageordodaac=1D381;serial=16522293";
        String s = engine.convert(orig,
                params,
                LevelTypeList.BINARY);
        //               ................................................................................................
        String expect = "1100111001110001000100110011111000110001111111000001110000110101";
        //                  c   e   7   1   1   3   3   e   3   1   f   c   1   c   3   5
//        Assert.assertEquals(expect, s);
    }
}