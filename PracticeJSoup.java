import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class PracticeJSoup {

	public static void main(String[] args){
				Connection conn = Jsoup.connect("http://www.google.com");
				try {
					Document htmlDocument = conn.get();
					System.out.println("Sample google.com page: "+htmlDocument.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error!!!");
					e.printStackTrace();
				} catch(Exception ex){
					System.out.println("Error unknown exception: ");
					ex.printStackTrace();
				}
	}
}
