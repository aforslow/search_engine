package tf_idf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class IDFTerm {
	
	private Set<Document> documentSet;
	private Token token;
	private double totalNumberOfDocuments;
	private double nDocumentsContainingToken;
	private double idfTerm;
	
	public IDFTerm(Token token, Set<Document> documentSet) {
		this.token = token;
		this.documentSet = documentSet;
		this.idfTerm = calcInverseDocumentFrequency();
	}
	
	public double getInverseDocumentFrequency() {
		this.calcInverseDocumentFrequency();
		return idfTerm;
	}
	
	private double calcInverseDocumentFrequency() {
		this.totalNumberOfDocuments = this.documentSet.size();
		this.nDocumentsContainingToken = this.getNumberOfDocumentsContainingToken(); 
//		nDocumentsContainingToken += 1; // + 1 in order to avoid 0 in denominator
		this.idfTerm = Math.log(totalNumberOfDocuments / nDocumentsContainingToken );
		return this.idfTerm;
	}
	
	private int getNumberOfDocumentsContainingToken() {
		int nDocsContainingToken = 0;
		for (Document d : this.documentSet) {
			if (d.containsToken(this.token)) {
				++nDocsContainingToken;
			}
		}
		return nDocsContainingToken;
	}
}
