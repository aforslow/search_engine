package tf_idf;

public interface ISearchEngine {
	
	public void addDocument(String documentString);
	
	public String searchSingleTermWithRank(String term);
	public String searchSingleTermNoRank(String term);
}
