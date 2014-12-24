import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileWriter;

import java.util.List;

import com.fiskkit.Fetcher;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
//import opennlp.tools.util.InvalidFormatException;

public class articleScraper
{
    public static void main(String[] args) throws FileNotFoundException
    {
    	//put in training data
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
    	
    	
    	//extract the paragraphs
    	List<String> paragraphs = Fetcher.pullAndExtract("http://www.weeklystandard.com/blogs/intel-chief-blasts-obama_802242.html");
    	String[] sentences = sentenceDetector.sentDetect(paragraphs.get(1));
    	
    	
//        System.out.println(test.get(0).charAt(1));
    	System.out.println(sentences[0]);
    }
}
