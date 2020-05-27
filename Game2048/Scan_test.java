package Game2048;
public class Scan_test {

	public static void main(String[] args) {

		int[][] ar = {{0,1,0},{1,0,0},{0,0,1}};
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j]);
			}System.out.println();
		}
		System.out.println("-----------");
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				for (int x = -1; x <= 1; x++) {
					for (int y = -1; y <= 1; y++) {
						if(i+x<0) {
							System.out.print("i가 - : "+i+" , "+j+" x: "+x+" y: "+y);
							System.out.println();
							i=0;
						} else if(j+y<0) {
							System.out.print("j가 - : "+i+" , "+j+" x: "+x+" y: "+y);
							System.out.println();
							j=0;
						} else if(i+x==3) {
							System.out.print("i over : "+i+" , "+j+" x: "+x+" y: "+y);
							System.out.println();
							i=3-1;
						} else if(j+y==3) {
							System.out.print("j over : "+i+" , "+j+" x: "+x+" y: "+y);
							System.out.println();
							j=3-1;
						} else {
							System.out.println(i+" , "+j+" = "+ar[i][j]);
						}
					}
				}
			}
		}
		System.out.println("-----------");
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j]);
			}System.out.println();
		}
		//참고!
//		int dx[] = {-1,1,0,0};
//		int dy[] = {0,0,1,-1};
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a.length; j++) {
//				for(int k=0;k<4;k++) {
//					if(dx[k]>=0 && dy[k] >=0 && dx[k]>a.length && dy[k] >a.length
//							&& a[i][j]!=a[i+dx[k]][j+dy[k]]){
//						
//					}
//				}
//			}
//		}
	}

}
