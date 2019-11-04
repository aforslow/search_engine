package tf_idf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonDocumentFileParser {
	
	
	public static LinkedList<String> parseFile(String filepath) throws IOException {
		JsonArray docs = getJsonArray(filepath);
	    return getDocumentList(docs);
	}
	
	private static JsonArray getJsonArray(String filepath) throws IOException {
		String data = "";
	    data = new String(Files.readAllBytes(Paths.get(filepath)));
	    JsonParser parser = new JsonParser();
	    JsonObject o = parser.parse(data).getAsJsonObject();
	    JsonArray docs = o.get("documents").getAsJsonArray();
	    return docs;
	}
	
	private static LinkedList<String> getDocumentList(JsonArray docs) {
		LinkedList<String> documents = new LinkedList<String>();
	    for (JsonElement doc : docs) {
	    	JsonObject docJsonObj = doc.getAsJsonObject();
	    	documents.add(docJsonObj.toString());
	    }
	    return documents;
	}
}
