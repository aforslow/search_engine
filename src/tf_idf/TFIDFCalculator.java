package tf_idf;

import java.util.Collections;
import java.util.LinkedList;

public class TFIDFCalculator {

	public double calculateTFIDF(Token token, Document document, LinkedList<Document> documentSet) {
		double tf = calculateTF(token, document);
		double idf = calculateIDF(token, documentSet);
		return tf * idf;
	}
	
	public double calculateTF(Token token, Document document) {
		TFTerm tfTerm = new TFFactory().getTFCalculator("documentNormalization");
		return tfTerm.calculate(token, document);
//		double rawCount = document.getTokenRawFrequency(token);
//		double nWords = document.getNWords();
//		return rawCount / nWords;
	}
	
	public double calculateIDF(Token token, LinkedList<Document> documentSet) {
		double totalNumberOfDocuments = documentSet.size();
		double nDocumentsContainingToken = getNumberOfDocumentsContainingToken(token, documentSet);
		return Math.log(totalNumberOfDocuments / (0.0 + nDocumentsContainingToken) ); 
	}
	
	private double getNumberOfDocumentsContainingToken(Token token, LinkedList<Document> documentSet) {
		int nDocsContainingToken = 0;
		for (Document d : documentSet) {
			if (d.containsToken(token)) {
				++nDocsContainingToken;
			}
		}
		return nDocsContainingToken;
	}
	
	
	public LinkedList<DocumentRankTuple> sortDocumentsTFIDF(Token token, 
			LinkedList<Document> documentListToSort, 
			LinkedList<Document> completeDocumentSet) {
		LinkedList<DocumentRankTuple> drts = generateDocumentRankTuples(token, documentListToSort, completeDocumentSet);
		Collections.sort(drts);
		return drts;
	}
	
	private LinkedList<DocumentRankTuple> generateDocumentRankTuples(Token token, 
			LinkedList<Document> documentListToSort,
			LinkedList<Document> completeDocumentSet) {
		LinkedList<DocumentRankTuple> drts = new LinkedList<DocumentRankTuple>();
		for (Document d : documentListToSort) {
			double tfidf = calculateTFIDF(token, d, completeDocumentSet);
			DocumentRankTuple drt = new DocumentRankTuple(d, tfidf);
			drts.add(drt);
		}
		return drts;
	}
}
