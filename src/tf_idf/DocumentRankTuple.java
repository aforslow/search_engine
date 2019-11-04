package tf_idf;

import java.util.Comparator;

public class DocumentRankTuple implements Comparable<DocumentRankTuple>{
	public Document document;
//	private TFIDF tfidf;
	public Double tfidf;
	
//	public DocumentRankTuple(Document document, TFIDF tfidf) {
//		this.document = document;
//		this.tfidf = tfidf;
//	}
	
	public DocumentRankTuple(Document document, Double tfidf) {
		this.document = document;
		this.tfidf = tfidf;
	}
	
	public DocumentRankTuple(DocumentRankTuple drt) {
		this.document = new Document(drt.document);
		this.tfidf = drt.tfidf;
	}
	
	public String prettifyDocument() {
		return this.document.getTitle();
	}
	
	public String prettifyComplete() {
		return String.format("[%s; %s]", this.document.getTitle(), this.tfidf);
	}
	
//	public double getTFIDFScore() {
//		return this.tfidf.getTFIDF();
//	}
	
//	@Override
//	public int compare(DocumentRankTuple o1, DocumentRankTuple o2) {
//		// TODO Auto-generated method stub
//		double rank1 = o1.getTFIDFScore();
//		double rank2 = o2.getTFIDFScore();
////		return rank1 < rank2 ? -1 : rank1 == rank2 ? 0 : 1;
//		return rank1 < rank2 ? -1 : 1;
//	}

//	@Override
//	public int compareTo(DocumentRankTuple o1) {
//		// TODO Auto-generated method stub
//		double rank1 = o1.getTFIDFScore();
//		double rank2 = this.getTFIDFScore();
////		return rank1 < rank2 ? -1 : rank1 == rank2 ? 0 : 1;
//		return rank1 < rank2 ? -1 : 1;
//	}
	
	@Override
	public int compareTo(DocumentRankTuple o1) {
		// TODO Auto-generated method stub
		double rank1 = o1.tfidf;
		double rank2 = this.tfidf;
		return rank1 < rank2 ? -1 : rank1 == rank2 ? 0 : 1;
//		return rank1 < rank2 ? -1 : 1;
	}
}

//public class DocumentRankTuple implements Comparator<DocumentRankTuple>{
//	public Document document;
//	private TFIDF tfidf;
//	
//	public DocumentRankTuple(Document document, TFIDF tfidf) {
//		this.document = document;
//		this.tfidf = tfidf;
//	}
//	
//	public double getTFIDFScore() {
//		return this.tfidf.getTFIDF();
//	}
//	
//	@Override
//	public int compare(DocumentRankTuple o1, DocumentRankTuple o2) {
//		// TODO Auto-generated method stub
//		double rank1 = o1.getTFIDFScore();
//		double rank2 = o2.getTFIDFScore();
////		return rank1 < rank2 ? -1 : rank1 == rank2 ? 0 : 1;
//		return rank1 < rank2 ? -1 : 1;
//	}
//}
