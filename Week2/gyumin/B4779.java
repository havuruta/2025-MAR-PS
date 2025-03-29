package gyumin;

import java.io.*;

public class B4779 {
	
	static int length;
	static char[] kkanpu;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		while((input = br.readLine()) != null && !input.isEmpty()) {
			length = (int) Math.pow(3, Integer.parseInt(input));
			kkanpu = new char[length]; // 3^n 크기의 배열
			
			for(int i = 0; i < length; i++) {
				kkanpu[i] = '-';
			}
			
			impl(0, length);
			
			String res = toString(length);
			bw.write(res+"\n");
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}

	private static String toString(int l) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < l; i++) {
			sb.append(kkanpu[i]);
		}
		
		return sb.toString();
	}

	private static void impl(int s, int l) {
		if(l <= 1 || l > length) return;
		
		int sub = l / 3;
		
		for(int i = sub + s; i < (sub * 2) + s; i++) {
			kkanpu[i] = ' ';
		}// 두번째 묶음(중간) 공백 처리
		
		impl(s, sub); // 첫 묶음 처리
		impl(s + sub * 2, sub); // 세번째 묶음 처리
	}
	
}
