package Game2048;

import java.util.Random;

public class ver_4 {
	//map
	static Random rand = new Random();
	static int[][] ar = new int[5][5];
	static int persentX;
	static int persentY; 

	public static void main(String[] args) {

//		int count = 0;
		
//		while(count<5) {
//			
//			for (int i = 0; i < 2; i++) {
//				ar[persentX][persentY]=2;
//			}
//			
//			persentX = rand.nextInt(ar.length);
//			persentY = rand.nextInt(ar.length);
//			ar[persentX][persentY]=2;
//			
//			if(ar[persentX][persentY]!=0) {
//				
//			}
//			
//			for (int i = 0; i < ar.length; i++) {
//				for (int k = 0; k < ar.length; k++) {
//					System.out.print(ar[i][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("------------");
//
//			
//			count++;
//		}
		int count = 0;
		
		persentX = rand.nextInt(ar.length);
		persentY = rand.nextInt(ar.length);
		ar[persentX][persentY]=2;
		persentX = rand.nextInt(ar.length);
		persentY = rand.nextInt(ar.length);
		ar[persentX][persentY]=2;
		
		LOOP1 : while(count<5) {
			persentX = rand.nextInt(ar.length);
			persentY = rand.nextInt(ar.length);
			if(ar[persentX][persentY]!=0) {
				continue LOOP1;
			} else {
				ar[persentX][persentY]=2;
			}
			
			for (int i = 0; i < ar.length; i++) {
				for (int k = 0; k < ar.length; k++) {
					System.out.print(ar[i][k]+" ");
				}
				System.out.println();
			}
			System.out.println("------------");
			
			count++;
		
		}
		
	}

}
