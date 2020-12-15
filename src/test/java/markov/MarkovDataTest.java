package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {

	/*
	 * For all tests, we apply GIVEN_WHEN_THEN principles
	 */

	MarkovData data = new MarkovData();
	String keyString = "bonjour";
	String wordtoLearn = "monsieur";

	@Test
	public void read_emptyString_emptyList() {
		data.read("");
		int expected  = 1; // Actually it would be 0 for logical tough
		 				   // Howerver, empty string is learn as an element
		int actual = data.keyWordSize();
		assertEquals(expected, actual);
	}

	@Test
	public void read_5Words_size5() {
		data.read("There is five words here");
		int expected  = 5;
		int actual = data.keyWordSize();
		assertEquals(expected, actual);
	}

	@Test
	public void read_OneBigWordWithSpecialChars_size1() {
		data.read("Im_A_Big_Fat_Word_With'Spécial*chars'&#{[[|MarkavData.textwords_devrait_etre_une_ArrayList_a_la_definition");
		int expected  = 1;
		int actual = data.keyWordSize();
		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void read_null_NullPointerException() {
		data.read(null);
	}


	@Test
	public void renforceWord_firstWord_false(){
		boolean expected = false;
		boolean actual = data.renforceWord(keyString, wordtoLearn);
		assertEquals(expected, actual);
	}

	@Test
	public void renforceWord_notFirstWord_true(){
		boolean expected = true;
		data.learnWord("bonjour", "bonsoir");
		boolean actual = data.renforceWord(keyString, wordtoLearn);
		assertEquals(expected, actual);
	}


}
