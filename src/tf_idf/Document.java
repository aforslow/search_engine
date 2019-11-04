package tf_idf;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Document {
	
	private String title;
	private String content;
	private LinkedList<Token> tokenSequence;
	private HashMap<Token, Integer> tokenFrequencyMap;
	private int maxRawFrequency;
	private int nWords;

	public Document(String jsonStr) {
		this.initFieldsFromJson(jsonStr);
		this.tokenSequence = generateTokenSequence();
		this.tokenFrequencyMap = generateTokenFrequencyMap();
		this.nWords = getNWords();
		this.maxRawFrequency = calcMaxRawFrequency();
	}
	
	public Document(Document document) {
		this.title = document.title;
		this.content = document.content;
		this.nWords = document.nWords;
		this.maxRawFrequency = document.maxRawFrequency;
		this.tokenSequence = (LinkedList<Token>) document.tokenSequence.clone();
		this.tokenFrequencyMap = (HashMap<Token, Integer>) document.tokenFrequencyMap.clone();
	}
	
	private void initFieldsFromJson(String jsonStr) {
		JsonObject jsonObj = new Gson().fromJson(jsonStr, JsonObject.class);
		this.title = jsonObj.get("title").getAsString();
		this.content = jsonObj.get("content").getAsString();
	}
	
	private LinkedList<Token> generateTokenSequence() {
		Tokenizer tokenizer = new StandardTokenizer();
		LinkedList<Token> tokenSequence = tokenizer.tokenize(this.content);
		return tokenSequence;
	}
	
	private HashMap<Token, Integer> generateTokenFrequencyMap() {
		HashMap<Token, Integer> tokenFrequencyMap_ = new HashMap<Token, Integer>();
		for (Token t : this.tokenSequence) {
			tokenFrequencyMap_.merge(t, 1, Integer::sum);
		}
		return tokenFrequencyMap_;
	}
	
	private int calcMaxRawFrequency() {
		return Collections.max(this.tokenFrequencyMap.values());
	}
	
	public int getTokenRawFrequency(Token token) {
		return tokenFrequencyMap.getOrDefault(token, 0);
	}
	
	public int getNWords() {
		return this.tokenSequence.size();
	}
	
	public int getMaxRawFrequency() {
		return maxRawFrequency;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public boolean containsToken(Token t) {
		return this.tokenFrequencyMap.containsKey(t);
	}
	
	public Set<Token> getTokens() {
		return this.tokenFrequencyMap.keySet();
	}
}
