package WordOccurences; 

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
	
	
	public class WordOccurences{
		
		/*
		* We started by creating a word map because i made a seperate file from the original online poem and added it into our code
		* You this implemented in lines 26-31, i also focus on making it in decreasing order so i can focus on what words show up the most for easier testing.
		*/


		public static Map<String,Integer> createWordMap () {
			String fileName = "/Users/kiaunamalesh/eclipse-workspace/TextAnalyzer/src/Text Analyzer";
			Map<String, Integer> wordMap = buildWordMap(fileName);
			List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
			
			// Prints wordMap to console
			System.out.println("Words repeated within poem: ");
			for (Map.Entry<String, Integer> entry : list) {
			if (entry.getValue() > 1) 
				System.out.println(entry.getKey() + " --- " + entry.getValue());
			
			}

			return wordMap;
		}

		/*
		* Here is where we start to actually form our word map and tell the system to start each word at 0 and to count each word in the text provided, then to return that number to the system
		*
		*/
		
		public static int numberWords (Map<String,Integer> wordMap, String word) {
			int count = 0;
			for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
				if (entry.getKey().equals(word)) {
					count = entry.getValue();
				}
			}
			return count;
		}
		
		/* In this part of our code we focus on our file names along with building our strings and even starting the keep count of how many words repeat in our code
		* We also start to see our pattern to compile and follow the rules of using a descending order style
		* Essentially meaning everytime we see a word repeat we add 1 to the current number
		* Another big point me notice here is that now our code is essentially tracking each of the words and keeping a consitent count of how many of each word exsit in our current text file
		*/

		public static Map<String, Integer> buildWordMap(String fileName) {
			Map<String, Integer> wordMap = new HashMap<>();
			try (FileInputStream fis = new FileInputStream(fileName);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {
				Pattern pattern = Pattern.compile("\\s+");
				String line = null;
				while ((line = br.readLine()) != null) {
					line = line.toLowerCase();
					String[] words = pattern.split(line);
					for (String word : words) {
						if (wordMap.containsKey(word)) {
						wordMap.put(word, (wordMap.get(word) + 1));
						} else {
						wordMap.put(word, 1);
						}
					}
				}
			} catch (IOException ioex) {
			ioex.printStackTrace();
			}
			return wordMap;
		}
		

		/* Here we focus on again implementing our descending our with our new recorded data
		* We also mention that we would like to sort and put these words in order based on how many times they occur in the text file and spit it out onto our console
		* Another big point to notice as well is we are assigning integers based on how our map is being developed and what entries we are looking for specifcally
		*/

		public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
			Set<Entry<String, Integer>> entries = wordMap.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<>(entries);
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			return (o2.getValue()).compareTo(o1.getValue());
			}
			});
			return list;
			}
		}
	
	/* 
	* Word map along with the counts have been completed and taken note of
	* If needed to this program can work on its own and give us a whole database of results with word occurences in a descending order.
	* This is not the pretty version but it does bring back promising test results with correct answers
	*/
