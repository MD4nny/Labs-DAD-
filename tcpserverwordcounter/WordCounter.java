package tcpserverwordcounter;

//Class to count the number of words in a sentence

public class WordCounter {
	
	public static int countWordAmount(String sentence){
		
		if (sentence == null || sentence.isEmpty()) {
			
			//if the sentence have no words
			return 0;
		}

		String[] words = sentence.split("\\s+");
		
		return words.length;
	}

}
