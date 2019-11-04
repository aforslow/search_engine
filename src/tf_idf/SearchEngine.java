package tf_idf;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.*;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SearchEngine implements ISearchEngine {
	
	private LinkedList<Document> documents;
	private InvertedIndexTable invertedIndexTable;
	
	public SearchEngine() {
		this.init();
	}

	public SearchEngine(LinkedList<String> rawJsonDocuments) {
		this.init();
		this.addDocuments(rawJsonDocuments);
	}
	
	private void init() {
		this.documents = new LinkedList<Document>();
		this.invertedIndexTable = new InvertedIndexTable(documents);
	}
	
	/**
	 * Adds multiple documents to inverted table and
	 * updates the document ranking according to tf-idf
	 * @param rawJsonDocuments: The list of documents represented
	 * as json strings
	 */
	public void addDocuments(LinkedList<String> rawJsonDocuments) {
		for (String rawJsonDocument : rawJsonDocuments) {
			Document newDoc = new Document(rawJsonDocument);
			this.documents.add(newDoc);
			this.invertedIndexTable.addDocument(newDoc);
		}
		this.invertedIndexTable.performTFIDFSort();
	}

	/**
	 * Adds single document to inverted table and
	 * updates the document ranking according to tf-idf.
	 * Do not use this method for multiple uploads;
	 * use addDocuments instead
	 * @param rawJsonDocument: The document represented as a json string
	 */
	@Override
	public void addDocument(String rawJsonDocument) {
		Document newDoc = new Document(rawJsonDocument);
		this.documents.add(newDoc);
		this.invertedIndexTable.addDocument(newDoc);
		this.invertedIndexTable.performTFIDFSort();
	}
	
	/**
	 * Returns a list of documents matching term. Each document is ranked by tf-idf
	 * @param term: The search term. Has to be a single word.
	 * @return queryAnswer: The stringified list of documents matching term.
	 */
	@Override
	public String searchSingleTermWithRank(String term) {
		Token t = new Token(term);
		LinkedList<DocumentRankTuple> docRankTuples = this.invertedIndexTable.getDocumentsFromToken(t);
		String queryAnswer = docRankTuples.stream()
				.map(DocumentRankTuple::prettifyComplete).collect(Collectors.joining(", "));
		
		return queryAnswer;
	}
	
	public LinkedList<Document> getDocuments() {
		LinkedList<Document> docCopies = new LinkedList<Document>();
		for (Document doc : documents) {
			docCopies.add(doc);
		}
		return docCopies;
	}

	@Override
	public String searchSingleTermNoRank(String term) {
		Token t = new Token(term);
		LinkedList<DocumentRankTuple> docRankTuples = this.invertedIndexTable.getDocumentsFromToken(t);
		String queryAnswer = "[" + docRankTuples.stream()
				.map(DocumentRankTuple::prettifyDocument)
				.collect(Collectors.joining(", ")) + "]";
		
		return queryAnswer;
	}
}
