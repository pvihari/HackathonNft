import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONObject;


public class Memory {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		 JSONArray list = new JSONArray();
		 JSONObject obj = new JSONObject();
		double max=0;
		double avg=0;
		int count=0;
		double num;
		double sum = 0;
		FileInputStream fis = new FileInputStream("Memory.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String Line;
		int i=0,j=0;
		while((Line=br.readLine()) != null){
			if(i%2 != 0){
				count++;
				//System.out.println(Line);
				StringTokenizer st = new StringTokenizer(Line,": ");
				ArrayList<String> array = new ArrayList<>();
				while(st.hasMoreTokens()){
					array.add(st.nextToken());
				}
				num = Double.parseDouble(array.get(1));
				if(num>max){
					max=num;
				}
				num = num/1024;
				System.out.println(num);
				sum += num;
				
			}
			i++;
			j++;
		}
		max = max/1024;
		 avg = sum/count;
		 System.out.println(avg);
		 System.out.println(max);
		 
		
		 
		
		scan.close();
		
		
		
		

	}

}
