article-scraper
===============

# Update

Added a Fetcher class that will retrieve paragraphs from a given article for you to process.
This should provide you with more context.

With this you should be able to process a few articles and output the results of the NLP sentence detection
into respective text files. 

http://www.thedailybeast.com/articles/2014/08/21/swat-lobby-takes-a-shot-at-congress.html

http://www.thedailybeast.com/articles/2014/08/12/russia-s-suspicious-humanitarian-aid-for-ukraine-separatists.html

We look forward to seeing your solution!


# Usage

```java
/**
* Returns an ArrayList<String> with elements that contain article paragraphs
*/
Fetcher.pullAndExtract("http://www.weeklystandard.com/blogs/intel-chief-blasts-obama_802242.html");
```
