import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;


class trainingModel {

	private static SentenceModel model;
	private static InputStream modelIn;
	private static SentenceDetectorME _sentenceDetector;

	trainingModel() {
//    	modelIn = null;
//    	model = null;
    	try {
			modelIn = new FileInputStream("en-sent.bin");
			model = new SentenceModel(modelIn);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
//			System.err.println("FileNotFoundException");
			e1.printStackTrace();
		}
    	catch (IOException e) {
//    		System.err.println("IOException");
    	    e.printStackTrace();
    	}
    	finally {
    	  if (modelIn != null) {
    	    try {
    	        modelIn.close();
    	    }
    	    catch (IOException e) {
//    	    	System.err.println("IOException");
    	    	e.printStackTrace();
    	    }
    	  }
    	}
//    	SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
		_sentenceDetector = new SentenceDetectorME(model);
	}
	
	SentenceDetectorME getsentDetector() {
		if (modelIn == null) {
			
			System.out.println("modelIn null");
		}
		return _sentenceDetector;
	}
}
