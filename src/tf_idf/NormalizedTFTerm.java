package tf_idf;

public class NormalizedTFTerm extends TFTerm {

	private Token token;
	private Document document;
	private double tfTerm;
	
	public NormalizedTFTerm(Token token, Document document) {
		this.token = token;
		this.document = document;
		this.tfTerm = calcTermFrequency();
	}
	
	public double getTermFrequency() {
		return this.tfTerm;
	}
	
	private double calcTermFrequency() {
		double rawCount = calcRawCount();
		double nWords = calcNWords();
		return rawCount / nWords;
	}
	
	private double calcRawCount() {
		return this.document.getTokenRawFrequency(this.token);
	}
	
	private double calcNWords() {
		return (double) this.document.getNWords();
	}
}
