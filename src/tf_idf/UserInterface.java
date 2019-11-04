package tf_idf;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jdk.nashorn.internal.parser.JSONParser;

public class UserInterface {
	
	private SearchEngine searchEngine;
	private boolean shouldQuit;
	
	public UserInterface() {
		this.searchEngine = new SearchEngine();
		populateSearchEngine();
	}
	
	private void populateSearchEngine() {
		String filepath = "bin/tf_idf/documents.json";
		try {
			LinkedList<String> documents = JsonDocumentFileParser.parseFile(filepath);
			this.searchEngine.addDocuments(documents);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processNextIter() {
		printIterIntro();
	    String query = getUserInput();	    
	    processUserInput(query);
	}
	
	private void printIterIntro() {
		System.out.println("Enter query (if you enter 'quit()', you will exit):");
	}
	
	private String getUserInput() {
		Scanner myObj = new Scanner(System.in);
	    String query = myObj.nextLine();  // Read user input
	    return query;
	}
	
	private void processUserInput(String userInput) {
		if (userInput.contentEquals("quit()")) {
			quit();
			return;
		}
		
		String res = this.searchEngine.searchSingleTermWithRank(userInput);
	    System.out.println("Result: " + res);  // Output user input
	    System.out.println();
	}
	
	private void quit() {
		this.shouldQuit = true;
	}
	
	public boolean shouldQuit() {
		return this.shouldQuit;
	}
}
