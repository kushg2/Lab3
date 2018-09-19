import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordcount(final String url) {

        String text = urlToString(url);
        int count = text.split(" ").length;
        return count;

    }

    public static int uniquewordcount(final String url) {

        Set newset = new HashSet<String>();
        String[] text = urlToString(url).split(" ");
        for (int i = 0; i < text.length; i++) {
            newset.add(text[i]);
        }

        return newset.size();
    }

    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordcount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(uniquewordcount("http://erdani.com/tdpl/hamlet.txt"));
    }

}
