package tf_idf;

import java.util.LinkedList;

public abstract class Tokenizer {

	public abstract LinkedList<Token> tokenize(String document);
}
