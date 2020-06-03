import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.json.JSONException;
import org.json.JSONObject;


public class cpu {

	public static void main(String[] args) throws IOException {
		JSONObject obj = new JSONObject();
		double max=0;
		FileInputStream fis = new FileInputStream("cpu.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String Line="";
		double num=0;
		double avg=0;
		int count=0;
		int i=0;
		double sum=0;
		while((Line = br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(Line," ");
			ArrayList<String> array = new ArrayList<>();
			while(st.hasMoreTokens()){
				array.add(st.nextToken());
			}
			num = Double.parseDouble(array.get(8));
			try {
				obj.put(i+"s:", num);
			} catch (JSONException e) {
				System.out.println(e);
			}
			if(max<=num){
				max = num;
			}
			sum += num;
			i++;
			count++;
		}
		
		avg = sum/count;
		br.close();
		FileWriter fw = new FileWriter("cpu.json");
		PrintWriter pw = new PrintWriter(fw);
		pw.println("sampletransaction:");
		pw.println("values:"+obj);
		DecimalFormat df = new DecimalFormat("#.##");
		pw.format("\nMAX:%s", df.format(max));
		pw.format("\nAVG:%s", df.format(avg));
		pw.close();
			
		
	}

}
