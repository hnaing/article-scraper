import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.List;

import com.fiskkit.Fetcher;
import com.opencsv.CSVWriter;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
//import opennlp.tools.util.InvalidFormatException;

/** The articleScraper project
 * @author Hnin Naing
 * */

public class articleScraper
{
	/**Extract sentences from live articles.
	 */	
    public static void main(String[] args) throws IOException
    {
    	//train data using opennlp api
    	InputStream modelIn = new FileInputStream("en-sent.bin");
    	SentenceModel model = null;
    	try {
    	  model = new SentenceModel(modelIn);
    	}
    	catch (IOException e) {
    	  e.printStackTrace();
    	}
    	finally {
    	  if (modelIn != null) {
    	    try {
    	      modelIn.close();
    	    }
    	    catch (IOException e) {
    	    }
    	  }
    	}
    	SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);

    	//Get article address and output file name as input
    	System.out.print("Article address: ");
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	String web = input.readLine();
    	System.out.print("Output file name: ");
    	input = new BufferedReader(new InputStreamReader(System.in));
    	String filename = input.readLine();

    	
    	
    	CSVWriter file = new CSVWriter(new FileWriter(filename),'\n');
    	
    	//extract the paragraphs
    	List<String> paragraphs = Fetcher.pullAndExtract(web);
    	
//    	file.writeNext(nextLine);(paragraphs); 
    	for (int i = 0; i < paragraphs.size(); i += 1)
    	{
    		String[] sentences = sentenceDetector.sentDetect(paragraphs.get(i));
    		
    		file.writeNext(sentences);
    		
    	}
    	file.close();

    	System.out.println("Done");
    }
    
}
