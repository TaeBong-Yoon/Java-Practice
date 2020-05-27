package Game2048;

public class CheckingMap_test {

	static int[][] ar = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	static int[][] ar2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	static int fill_count = 0;
	static int empty_count = 0;
	static boolean tf;

	static boolean scan(int[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] != 0) {
					fill_count++;
				}
			}
		}

		LOOP1:if (fill_count == a.length*a.length) {
			int k;
			
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length-1; j++) {
					k = j+1;
					if(a[i][j]!=a[i][k]) {
						System.out.println("오른쪽 ㄱㅊ");
					} else {
						break LOOP1;
					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = a.length-1; j >0; j--) {
					k = j-1;
					if(a[i][j]!=a[i][k]) {
						System.out.println("왼쪽 ㄱㅊ");
					} else {
						break LOOP1;
					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = a.length-1; j >0; j--) {
					k = j-1;
					if(a[j][i]!=a[k][i]) {
						System.out.println("위쪽 ㄱㅊ");
					} else {
						break LOOP1;
					}
				}
			}
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length-1; j++) {
					k = j+1;
					if(a[j][i]!=a[k][i]) {
						System.out.println("아래쪽 ㄱㅊ");
					} else {
						break LOOP1;
					}
				}
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		tf = scan(ar2);
		
		System.out.println(tf);
		
	}

}
