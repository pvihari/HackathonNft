import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.json.JSONException;
import org.json.JSONObject;


public class battery {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("BATTERY.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		JSONObject obj = new JSONObject();
		String Line = "";
		double DrainPercentage=0;
		double DrainValue = 0;
		while((Line = br.readLine())!=null){
			if(Line.contains("Uid u0a202")){
				StringTokenizer st = new StringTokenizer(Line,": ");
				ArrayList<String> array = new ArrayList<>();
				while(st.hasMoreTokens()){
					array.add(st.nextToken());
				}
				DrainValue = Double.parseDouble(array.get(2));
				DrainPercentage = DrainValue/1000;
				System.out.println(DrainValue);
				System.out.println(DrainPercentage);
				try {
					obj.put("%s", DrainValue);
					obj.put("%s", DrainPercentage);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				
			}
			
		}
		FileWriter fw = new FileWriter("Battery.json");
		PrintWriter pw = new PrintWriter(fw);
		pw.format("%s", obj);
		

	}

}
