package markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 * Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
 * when an unknown printer took a galley of type and scrambled it to make a
 * type specimen book. It has survived not only five centuries, but also the leap
 * into electronic typesetting, remaining essentially unchanged. It was
 * popularised in the 1960s with the release of Letraset sheets containing Lorem
 * Ipsum passages, and more recently with desktop publishing software like
 * Aldus PageMaker including versions of Lorem Ipsum
 */
public class MarkovData {
	private Map<String, String> markovTable = new HashMap<String,String>();
	private List<String> textwords = new ArrayList<String>();

	public void read(String text) {
		List<String> newWords = Arrays.asList(text.split(" "));
		this.textwords.addAll(newWords);
	}
	
	public boolean renforceWord(String keyString, String wordToLearn) {
		String value;
		boolean isNewKey = containsKeyWord(keyString);
		
		// if chain in list then add extra word
		if(isNewKey){
			value = getLearnedWord(keyString);
			value += " " + wordToLearn;
			learnWord(keyString, value);
		}
		return isNewKey;
	}

	String getLearnedWord(String keyString) {
		return this.markovTable.get(keyString);
	}

	boolean containsKeyWord(String keyString) {
		return this.markovTable.containsKey(keyString);
	}

	public void learnWord(String keyString, String learnWord) {
		this.markovTable.put(keyString, learnWord);
	}
	
	public String getKeyWord(int k) {
		return this.textwords.get(k);
	}

	public int keyWordSize() {
		return this.textwords.size();
	}
}