package nlp_control;

import nlp_data_structure.FileIO;
import nlp_data_structure.WordStack;
import nlp_ui.ConsoleInteraction;

public class WordProcessor {
	private WordStack ws = new WordStack();
	private FileIO io = new FileIO();
	private ConsoleInteraction ci = new ConsoleInteraction();
	
	public void run(){
		ci.output("Hello");
	}
}
