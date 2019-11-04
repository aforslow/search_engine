package tf_idf;

import java.util.LinkedList;

public class DocumentSet {
	
	private LinkedList<Document> documents;
	
	public DocumentSet() {
		this.documents = new LinkedList<Document>();
	}
	
	public void add(Document d) {
		this.documents.add(d);
	}
	
	public int size() {
		return documents.size();
	}
	
	
}
