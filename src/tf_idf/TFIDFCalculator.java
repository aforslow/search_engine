package tf_idf;

import java.util.Collections;
import java.util.LinkedList;

public class TFIDFCalculator {

	/**
	 * Returns the TF-IDF score according to wikipedia definition
	 * @param token: The token to calculate for
	 * @param document: The document to calculate for
	 * @param documentSet: The search engine's document set
	 * @return tfidf: the TF-IDF score
	 */
	public double calculateTFIDF(Token token, Document document, LinkedList<Document> documentSet) {
		double tf = calculateTF(token, document);
		double idf = calculateIDF(token, documentSet);
		double tfidf = tf * idf;
		return tfidf;
	}
	
	/**
	 * Calculates TF adjusted for document length according to wikipedia definition
	 * @param token: The token to calculate for
	 * @param document: The document to calculate for
	 * @return tf: The term frequency
	 */
	public double calculateTF(Token token, Document document) {
		double rawCount = document.getTokenRawFrequency(token);
		double nWords = document.getNWords();
		double tf = rawCount / nWords;
		return tf;
	}
	
	/**
	 * Calculates IDF according to wikipedia definition
	 * @param token: The token to calculate for
	 * @param documentSet: The search engine's document set
	 * @return idf: The IDF calculated according to wikipedia definition
	 */
	public double calculateIDF(Token token, LinkedList<Document> documentSet) {
		double totalNumberOfDocuments = documentSet.size();
		double nDocumentsContainingToken = getNumberOfDocumentsContainingToken(token, documentSet);
		double idf = Math.log(totalNumberOfDocuments / (0.0 + nDocumentsContainingToken) );
		return idf;
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
	
	/**
	 * Sorts a document list according to TFIDF
	 * @param token: The token to sort according to
	 * @param documentListToSort: The list to sort
	 * @param completeDocumentSet: The search engine's document set
	 * @return drts: A LinkedList containing (Document, tf-idf-rank)-tuples
	 * sorted according to tf-idf-scores in descending order.
	 */
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
