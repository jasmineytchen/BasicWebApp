package com.develogical;

import java.util.HashMap;

public class LiteralAnswerKeeper {

	public LiteralAnswerKeeper() {}

	public HashMap<String, String> getQueryAndAnswer(){ return queryAndAnswer;}

	private final static HashMap<String, String> queryAndAnswer = new HashMap<String, String>() {{
		put("name", "mexico-bandido");
		put("eiffel", "Paris");
		put("banana", "yellow");
		put("bond", "Sean Connery");
		put("may", "2016");
		put("shakespeare", "playwright");
	}};

}
