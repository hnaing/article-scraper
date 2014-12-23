import java.util.List;

import com.fiskkit.Fetcher;

public class Test
{
    public static void main(String[] args)
    {
    	List<String> test = Fetcher.pullAndExtract("http://www.weeklystandard.com/blogs/intel-chief-blasts-obama_802242.html");
        System.out.println(test.get(0).charAt(1));
    }
}

