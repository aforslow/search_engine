package tf_idf;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AugmentedTFTerm extends TFTerm {
	
	private Token token;
	private Document document;
	private double tfTerm;
	
	public AugmentedTFTerm(Token token, Document document) {
		this.token = token;
		this.document = document;
		this.tfTerm = this.calcTermFrequency();
	}
	
	public double getTermFrequency() {
//		this.tfTerm = this.calcTermFrequency();
		return this.tfTerm;
//		return this.calcTermFrequency(this.token, this.document);
	}
	
	private double calcTermFrequency() {
		double rawCount = this.calcRawCount();
		double maxFrequency = this.calcMaxFrequency();
		return 0.5 + 0.5 * (rawCount / maxFrequency);
	}
	
	private double calcRawCount() {
		return this.document.getTokenRawFrequency(this.token);
	}
	
	private double calcMaxFrequency() {
		return this.document.getMaxRawFrequency();
	}
}
