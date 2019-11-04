package tf_idf;

public class DocumentRankTuple implements Comparable<DocumentRankTuple>{
	public Document document;
	public Double tfidf;
	
	public DocumentRankTuple(Document document, Double tfidf) {
		this.document = document;
		this.tfidf = tfidf;
	}
	
	public DocumentRankTuple(DocumentRankTuple drt) {
		this.document = new Document(drt.document);
		this.tfidf = drt.tfidf;
	}
	
	/**
	 * Returns the document's title in the (Document, TFIDF-rank) tuple
	 * @return document title
	 */
	public String prettifyDocument() {
		return this.document.getTitle();
	}
	
	/**
	 * Returns the document's title along with the TFIDF-rank
	 * @return a string with the document's title along with the TFIDF-rank
	 */
	public String prettifyComplete() {
		return String.format("[%s; %s]", this.document.getTitle(), this.tfidf);
	}
	
	@Override
	public int compareTo(DocumentRankTuple o1) {
		double rank1 = o1.tfidf;
		double rank2 = this.tfidf;
		if (rank1 < rank2) return -1;
		if (rank1 == rank2) return 0;
		return 1;
	}
}
