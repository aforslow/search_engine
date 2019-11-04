package tf_idf;

public class TFTermDocumentNormalized extends TFTerm {

	public double calculate(Token token, Document document) {
		double rawCount = calcRawCount(token, document);
		double nWords = calcNWords(document);
		return rawCount / nWords;
	}
	
	private double calcRawCount(Token token, Document document) {
		return document.getTokenRawFrequency(token);
	}
	
	private double calcNWords(Document document) {
		return (double) document.getNWords();
	}
}
