package tf_idf;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class InvertedIndexTable {

	private HashMap<Token, LinkedList<DocumentRankTuple>> invertedIndexTable;
	private LinkedList<Document> documentSet;
	
	public InvertedIndexTable(LinkedList<Document> documentSet) {
		this.invertedIndexTable = new HashMap<Token, LinkedList<DocumentRankTuple>>();
		this.documentSet = documentSet;
	}
	
	public void addDocument(Document doc) {
		for (Token t : doc.getTokens()) {
			LinkedList<DocumentRankTuple> emptyDocList = new LinkedList<DocumentRankTuple>();
			LinkedList<DocumentRankTuple> tokenDocList = invertedIndexTable.getOrDefault(t, emptyDocList);
			DocumentRankTuple drt = new DocumentRankTuple(doc, null);
			tokenDocList.add(drt);
			invertedIndexTable.put(t, tokenDocList);
		}
	}
	
	public void performTFIDFSort() {
		for (Token t : this.invertedIndexTable.keySet()) {
			LinkedList<DocumentRankTuple> tokenDocList = this.invertedIndexTable.get(t);
			populateScore(t, tokenDocList);
			Collections.sort(tokenDocList);
		}
	}
	
	private void populateScore(Token token, LinkedList<DocumentRankTuple> tokenDocList) {
		TFIDFCalculator calc = new TFIDFCalculator();
		for (DocumentRankTuple drt : tokenDocList) {
			drt.tfidf = calc.calculateTFIDF(token, drt.document, this.documentSet);
		}
	}
	
	public LinkedList<DocumentRankTuple> getDocumentsFromToken(Token t) {
		LinkedList<DocumentRankTuple> tokenDocRankMapCopy = new LinkedList<DocumentRankTuple>();
		LinkedList<DocumentRankTuple> emptyList = new LinkedList<DocumentRankTuple>();
		for (DocumentRankTuple d : this.invertedIndexTable.getOrDefault(t, emptyList)) {
			tokenDocRankMapCopy.add(new DocumentRankTuple(d));
		}
		return tokenDocRankMapCopy;
	}
	
	
}