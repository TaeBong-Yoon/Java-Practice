package Game2048;

public class Scan_test3 {
	
	public static void main(String[] args) {
		
	     int[][] ar = { { 1, 0, 2 }, { 0, 0, 3 }, { 0, 2, 4 } };
	     
	     for (int i = 0; i < ar.length; i++) {
			for (int j = ar.length-1; j >= 0 ; j--) {
				if(ar[i][j]!=0) {
					for (int k = j-1; k >= 0; k--) {
						if(ar[i][k]!=0) {
						}
					}
				}
			}
		}
		
	}

}
//for (int k = a.length - 2; k >= 0; k--) {
////  !=0 기준으로 왼쪽에 숫자가 있는지 있다면 같은지 - true 다른지 - false
//  if (a[i][k] != 0) {
//     System.out.println("bark! " + "i: " + i + " j:" + j + " k: " + k + " num: " + a[i][k]);
//  } else {
////     없는지 없다면 j스캔 그만하고 i++
//     System.out.println("zero2 " + "i: " + i + " j:" + j + " k: " + k);
//     break LOOP1;
