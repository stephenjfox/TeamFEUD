package nlp_tester;

import nlp_control.WordWrapper;
import nlp_control.WordProcessor;
import nlp_data_structure.PartOfSpeech;
import nlp_tests.ReparserForGibberishTest;

/**
 * Created by Stephen on 3/5/14.
 */
public class TestRunner {
    public static void main(String args[]) {
        run();
    }

    static void run(){
//        fileSearcherTest();
        new ReparserForGibberishTest();
    }

    private static void fileSearcherTest() {
        // Expected Result:
        // Console Dialogue: "noun"
        WordWrapper testIO = new WordWrapper();
        System.out.println(
                testIO.findInDictionary("Dogs").getContentsByObject());
        // Actual: null print

        // Expected Result:
        // Null print
        System.out.println(
                testIO.findInDictionary("lkasdfas"));
        // Actual: null print

        // Expected Result:
        // Unknown, handling of multiple strings has yet to be tested
        System.out.println(
                testIO.findInDictionary("Dog and The Flash"));
        // Actual: null print
    }
}
