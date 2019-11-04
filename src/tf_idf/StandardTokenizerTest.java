package tf_idf;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;


import org.junit.Test;

public class StandardTokenizerTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		String document = "This... this is my document! You are: Findwise? "
				+ "No, this can't be - I'm the one ruling here; I am the 0th author!";
		StandardTokenizer stdt = new StandardTokenizer();
		LinkedList<Token> tokenSequence = stdt.tokenize(document);
	
		Token[] expectedList = {
				new Token("this"),
				new Token("this"),
				new Token("is"),
				new Token("my"),
				new Token("document"),
				new Token("you"),
				new Token("are"),
				new Token("findwise"),
				new Token("no"),
				new Token("this"),
				new Token("can't"),
				new Token("be"),
				new Token("i'm"),
				new Token("the"),
				new Token("one"),
				new Token("ruling"),
				new Token("here"),
				new Token("i"),
				new Token("am"),
				new Token("the"),
				new Token("0th"),
				new Token("author")
		};
		
		Assert.assertEquals(expectedList.length, tokenSequence.size());
		
		for (int i=0; i < tokenSequence.size(); i++) {
			Token expected = expectedList[i];
			Token actual = tokenSequence.get(i);
			Assert.assertEquals(expected, actual);
		}
	}
}
