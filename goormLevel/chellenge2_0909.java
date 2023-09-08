package chellenge.programmers.week3.friday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class challenge1 {
	static class Index{
		int y, x;
        public Index(int y, int x){
            this.y = y;
            this.x = x;
        }
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String [] inputData = input.split(" ");
		//input Data 변수정리
		int N = Integer.parseInt(inputData[0]);//첫째 줄에 배열의 크기
		int K = Integer.parseInt(inputData[1]);//연결 요소를 지울 기준크기 --처음에는 K이상인 요소가 존재하지 않는다.
		int Q = Integer.parseInt(inputData[2]); //문자를 적을 횟수

		//초기배열
		char [][] ar = new char[N][N];

		String insertData = "";
		for(int i=0; i<N; i++){
			insertData=br.readLine();
			for(int j=0; j<N; j++){
				ar[i][j]=insertData.charAt(j);
			}
		}	

		for(int i=0; i<Q; i++){
			ArrayList<Index> indexList = new ArrayList<>();
			insertData=br.readLine();
			inputData = insertData.split(" ");
			Index initIndex  = new Index(Integer.parseInt(inputData[0])-1, Integer.parseInt(inputData[1])-1);
			indexList.add(initIndex);
			ar[initIndex.y][initIndex.x]=inputData[2].charAt(0);
			
			indexList= search(ar,indexList);
			if(indexList.size()>=K) {
				for(int j=0; j<indexList.size(); j++) {
					ar[indexList.get(j).y][indexList.get(j).x]='.';
				}
			}
		}
		for(int i=0; i<N; i++) {
			String result = "";
			for(int j=0; j<N; j++) {
				result+=ar[i][j];
			}
			System.out.println(result);
		}
	}
	public static ArrayList<Index> search(char[][] ar,ArrayList<Index> indexList){
		int [] dy={0,-1,0,1};
		int [] dx={1,0,-1,0};
		boolean [][] room =new boolean [ar.length][ar.length];//방문 체크
		room[indexList.get(0).y][indexList.get(0).x] = true;
		
		for(int i=0; i<indexList.size(); i++) {
			int yIdx = indexList.get(i).y;
			int xIdx = indexList.get(i).x;
			
			
			for(int j=0; j<4; j++) {
				int tempY =yIdx+dy[j]; 
				int tempX =xIdx+dx[j]; 
				if(tempY<0||tempY>ar.length-1||tempX<0||tempX>ar.length-1)
					continue;
				else if (ar[tempY][tempX]==ar[yIdx][xIdx]) {
					if(!room[tempY][tempX]) {
						indexList.add(new Index(tempY, tempX));
						room[tempY][tempX] = true;
					}
				}
			}
		}
		return indexList;
	}
}
