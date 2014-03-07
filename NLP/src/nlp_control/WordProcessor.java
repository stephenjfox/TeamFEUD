package nlp_control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import nlp_data_structure.FileIO;
import nlp_data_structure.PartOfSpeech;
import nlp_data_structure.Sentence;
import nlp_data_structure.WordStack;
import nlp_ui.ConsoleInteraction;

public class WordProcessor {
	private WordStack ws = new WordStack();
	private LinkedList<PartOfSpeech> elements = new LinkedList<>();
	private ArrayList<String> unknowns = new ArrayList<>();
	private FileIO io = new FileIO();
	private ConsoleInteraction ci = new ConsoleInteraction();
	private LanguageProcessor lp = new LanguageProcessor();
	private Sentence currentSent;
	private String input;
	
	public void run(){
		ci.output("Hello");
		ci.output("(type below to respond...)");
		input = ci.getInput();
        parseInput(input);
        lp.setInput(elements);
        currentSent = lp.process();
	}

    private void parseInput(String test) {
        String[] parsedInput = test.split(" ");//splits the user input by spaces
        for(String s : parsedInput){
            if (parsedInput.length >= 1) {
				if (s.charAt(s.length() - 1) < 65) {//finds punctuation attached to the end of words
					char punctuation = s.charAt(s.length() - 1);
					s = s.substring(0, s.length() - 1) + " " + punctuation;
				}
			}
        }
        for(String wordToCheck : parsedInput){
            PartOfSpeech pos = io.findInDictionary(wordToCheck);
            if(pos != null) elements.offer(pos);
            else unknowns.add(wordToCheck);
        }
    }
    
    private String respond(){
    	String response = "";
    	Random choice = new Random();
    	if(currentSent != null){
    		int selection = choice.nextInt(5);
    		switch(selection){
    		case 0:
    			//ask noun question
    			break;
    		case 1:
    			//ask verb question
    			break;
    		case 2:
    			//make noun statement
    			break;
    		case 3:
    			//make verb statement
    			break;
    		case 4:
    			//other options...
    			break;
    		case 5:
    			break;
    		case 6:
    			break;
    		default:
    			break;
    		}
    	}
    	else ci.output("Talk to me.");
    	return response;
    }
}
