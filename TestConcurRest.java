import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TestConcurRest {

	public static InputStream inputStream;
	public static FileOutputStream outputStream;
	
	public static void main(String[] args) throws IOException{
		OkHttpClient client = new OkHttpClient();

		String singleReceiptImageUrl = "https://imagingupload.concursolutions.com/file/d0020719wlc8/16F86193F0D0B076859E2F50F687DF5356B6DCB053B94DC2DCA15FD766E91968AE1D97837CC75F2BF3240EE65B7450437F2F4BB0222D20B7031DDED70CBC68B27027518F4356393FE16133BA38F2A232HE1AFB16D09E3C0E275F974B01DB41B4C?id=F0AF1921117C32C78FE7835A1C6D144A&amp;e=d0020719wlc8&amp;t=AN";
		String receiptImage = "https://www.concursolutions.com/api/v3.0/expense/receiptimages/gWgdqyyys0N5id45Vfflxe2QHhtc$sqy$sQbqNnqXPpNjUIXtn4nLnMlMj1DKpTeeWb$sw";
		Request request = new Request.Builder()
		      .url(singleReceiptImageUrl)
		      .addHeader("Authorization", "OAuth xKDR6ZAfLZIniYbOhliRaCNcr8U=").build();


		    client.newCall(request).enqueue(new Callback() {
		        
		        public void onFailure(Call arg0, IOException e) {
		            System.out.println("request failed: " + e.getMessage());
		        }

		        public void onResponse(Call arg0, Response response) throws IOException {
		        	inputStream = response.body().byteStream(); // Read the data from the stream
		        	System.out.println(response.isSuccessful());
		        	System.out.println(response.body().contentLength());
		        	System.out.println(response.body().toString());
		        	try {
		        		// read this file into InputStream
		        		 //inputStream = is;
		        		 

		        		// write the inputStream to a FileOutputStream
		        		 outputStream = 
		                            new FileOutputStream(new File("/Users/swetashah/Desktop/TestConcur.txt"));

		        		int read = 0;
		        		byte[] bytes = new byte[1024000];

		        		while ((read = inputStream.read(bytes)) != -1) {
		        			outputStream.write(bytes, 0, read);
		        		}

		        		System.out.println("Done!");

		        	} catch (IOException e) {
		        		e.printStackTrace();
		        	} finally {
		        		if (inputStream != null) {
		        			try {
		        				inputStream.close();
		        			} catch (IOException e) {
		        				e.printStackTrace();
		        			}
		        		}
		        		if (outputStream != null) {
		        			try {
		        				// outputStream.flush();
		        				outputStream.close();
		        			} catch (IOException e) {
		        				e.printStackTrace();
		        			}

		        		}
		        	}
		            }
		    });
	}
}
