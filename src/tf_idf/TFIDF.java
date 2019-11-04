package tf_idf;

import java.util.Set;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TFIDF {
	
	private TFTerm tfTerm;
	private IDFTerm idfTerm;
	private double tfidfTerm;
	
	public TFIDF(Token token, Document document, Set<Document> documentSet) {
		this.tfTerm = new NormalizedTFTerm(token, document);
		this.idfTerm = new IDFTerm(token, documentSet);
		this.tfidfTerm = this.calcTFIDFTerm(this.tfTerm, this.idfTerm);
	}
	
	private double calcTFIDFTerm(TFTerm tfTerm, IDFTerm idfTerm) {
		return tfTerm.getTermFrequency() * idfTerm.getInverseDocumentFrequency();
	}

	public double getTFIDF() {
		return tfidfTerm;
	}
}
