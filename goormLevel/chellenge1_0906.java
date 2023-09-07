import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String [] dataSplit =input.split(" ");
		int size = Integer.parseInt(dataSplit[0]);
		int line = Integer.parseInt(dataSplit[1]);
		int [][] x = new int[size+1][size+1];
		int [][] y = new int[size+1][size+1];
		

		Long point = 0L;
		for(int i=0; i<line; i++){
			int [] data = new int[size];

			String [] inputData = br.readLine().split(" ");


			if(inputData[2].equals("R")||inputData[2].equals("L")){
				for(int j=Integer.parseInt(inputData[1]);j<=size&&j>=1;){
					x[Integer.parseInt(inputData[0])][j]++;
					if(inputData[2].equals("R")){
						j++;
					}
					else{
						j--;
					}		
				}
			}
			else if(inputData[2].equals("U")||inputData[2].equals("D")){
				for(int j=Integer.parseInt(inputData[0]);j<=size&&j>=1;){
					
					y[j][Integer.parseInt(inputData[1])]++;
					if(inputData[2].equals("D")){
						j++;
					}
					else{
						j--;
					}		
				}
			}
		}
		for(int i=1; i<=size; i++){
			for(int j=1; j<=size; j++){
				point+=x[i][j]*y[i][j];
			}
		}
		System.out.print(point);

	}
}