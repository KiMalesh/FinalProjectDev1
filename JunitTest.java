package WordOccurences;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class JunitTest {


	@Test
	public void test() {
		UserFrame testWord = new UserFrame(); 
		Map<String, Integer> wordMap = null;
		int output_f= UserFrame.numberWords(wordMap,"Why");
		
		//Test the output
		
		assertEquals(0,output_f);
		
    }
}