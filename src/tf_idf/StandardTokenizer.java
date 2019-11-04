package tf_idf;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandardTokenizer extends Tokenizer {

	/**
	 * Returns a tokenized linkedlist of a document.
	 * Splitting of tokens is based on word boundaries
	 */
	@Override
	public LinkedList<Token> tokenize(String document) {
		// TODO Auto-generated method stub
		// String to be scanned to find the pattern.
	      LinkedList<Token> tokenSequence = new LinkedList<Token>();
	      String pattern = "([a-zA-Z0-9']+)";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(document);
	      while (m.find( )) {
	    	  String match = m.group(1);
	    	  Token token = new Token(match.toLowerCase());
	    	  tokenSequence.add(token);
	      }
	      
	      return tokenSequence;
	}
}
