package tf_idf;

import java.util.Objects;

public class Token {

	private String token;
	
	public Token(String token) {
		this.token = token;
	}
	
	public String getTokenString() {
		return this.token;
	}
	
	@Override
	public boolean equals(Object otherObject){
	    if (otherObject == null) return false;
	    if (otherObject == this) return true;
	    if (!(otherObject instanceof Token))return false;
	    Token otherToken = (Token)otherObject;
	    
	    return this.token.contentEquals(otherToken.getTokenString());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.token);
	}
}
