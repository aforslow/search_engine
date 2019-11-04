package tf_idf;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class SearchEngineTest {

	@Test
	public void testAddSingleDocument() {
		LinkedList<String> jsonStrings = createExampleJson(1);
		
		SearchEngine google = new SearchEngine(jsonStrings);
		LinkedList<Document> docs = google.getDocuments();
		
		Document doc1 = new Document(jsonStrings.get(0));
		HashSet<Document> targetSet = new HashSet<Document>();
		targetSet.add(doc1);
		
		assertEquals(docs.get(0).getTitle(), "Document 1");
		assertEquals(docs.get(0).getContent(), "The brown fox jumped over the brown dog.");
	}
	
	@Test
	public void testSearchBrown() {		
		LinkedList<String> jsonStrings = createExampleJson(3);
		LinkedList<Document> docset = new LinkedList<Document>();
		for (String s : jsonStrings) {
			Document d = new Document(s);
			docset.add(d);
		}
		SearchEngine google = new SearchEngine(jsonStrings);
		String term = "brown";
		String resp = google.searchSingleTermNoRank(term);
		System.out.println(term + ": " + resp);
	}
	
	@Test
	public void testSearchFox() {		
		LinkedList<String> jsonStrings = createExampleJson(3);
		LinkedList<Document> docset = new LinkedList<Document>();
		for (String s : jsonStrings) {
			Document d = new Document(s);
			docset.add(d);
		}
		SearchEngine google = new SearchEngine(jsonStrings);
		String term = "fox";
		String resp = google.searchSingleTermNoRank(term);
		System.out.println(term + ": " + resp);
	}
	
	@Test
	public void testSearchDog() {		
		LinkedList<String> jsonStrings = createExampleJson(3);
		LinkedList<Document> docset = new LinkedList<Document>();
		for (String s : jsonStrings) {
			Document d = new Document(s);
			docset.add(d);
		}
		SearchEngine google = new SearchEngine(jsonStrings);
		String term = "dog";
		String resp = google.searchSingleTermNoRank(term);
		System.out.println(term + ": " + resp);
	}
	
	@Test
	public void testSearchWrong() {		
		LinkedList<String> jsonStrings = createExampleJson(3);
		LinkedList<Document> docset = new LinkedList<Document>();
		for (String s : jsonStrings) {
			Document d = new Document(s);
			docset.add(d);
		}
		SearchEngine google = new SearchEngine(jsonStrings);
		String term = "wrong";
		String resp = google.searchSingleTermNoRank(term);
		System.out.println(term + ": " + resp);
	} 
	
	private LinkedList<String> createExampleJson(int n) {
		String jsonStr1 = "{\"title\": \"Document 1\", "
						+ "\"content\": \"The brown fox jumped over the brown dog.\"}";
		String jsonStr2 = "{\"title\": \"Document 2\", "
						+ "\"content\": \"The lazy brown dog, sat in the corner\"}";
		String jsonStr3 = "{\"title\": \"Document 3\", "
						+ "\"content\": \"The Red Fox bit the lazy dog!\"}";
		
		LinkedList<String> jsonStrings = new LinkedList<String>();
		
		if (n > 0) {
			jsonStrings.add(jsonStr1);			
		}
		if (n > 1) {
			jsonStrings.add(jsonStr2);			
		}
		if (n > 2) {
			jsonStrings.add(jsonStr3);			
		}
		
		return jsonStrings;
	}
	
}
