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
        respond();
	}

    private void parseInput(String test) {
        String[] parsedInput = test.split(" ");//splits the user input by spaces
        for(int i=0; i<parsedInput.length; i++){
            if (parsedInput.length >= 1) {
				if (parsedInput[i].charAt(parsedInput[i].length() - 1) < 'A') {//finds punctuation attached to the end of words
					char punctuation = parsedInput[i].charAt(parsedInput[i].length() - 1);
					parsedInput[i] = parsedInput[i].substring(0, parsedInput[i].length() - 1);
				}
			}
        }
        for(String wordToCheck : parsedInput){
            PartOfSpeech pos = io.findInDictionary(wordToCheck);
            if(pos != null) elements.offer(pos);
            else unknowns.add(wordToCheck);
//            System.out.println(elements);
        }
    }
    
    private String respond(){
    	String response = "";
    	Random choice = new Random();
    	if(currentSent != null){
    		int selection = choice.nextInt(5);
    		String noun = currentSent.getNP();
    		String verb = currentSent.getVP();
    		switch(selection){
    		case 0:
    			if(noun.charAt(noun.length()-1) != 's') ci.output(noun + " sounds interesting. Tell me more.");
    			else ci.output(noun + " sound interesting. Tell me more.");
    			break;
    		case 1:
    			if(noun.charAt(noun.length()-1) != 's') ci.output(noun + "s are my favorite!");
    			else ci.output(noun + " are my favorite!");
    			break;
    		case 2:
    			if(noun.charAt(noun.length()-1) != 's') ci.output("I used to be a " + noun + " then I got lost in this computer.");
    			else ci.output("I used to be a " + noun.substring(0, noun.length()-1) + " then I got lost in this computer.");
    			break;
    		case 3:
    			ci.output("I have nothing to say about that.");
    			break;
    		case 4:
    			if(noun.charAt(noun.length()-1) != 's') ci.output("Your face is a" + noun + "!");
    			else ci.output("Your face is a" + noun.substring(0, noun.length()-1) + "!");
    			break;
    		case 5:
    			ci.output("You're not making any sense.");
    			break;
    		case 6:
    			ci.output("Why?");
    			break;
    		default:
    			break;
    		}
    	}
    	else ci.output("Talk to me.");
    	return response;
    }
}
