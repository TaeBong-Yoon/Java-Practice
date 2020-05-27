package Game2048;

public class Scan_test2 {

   public static void main(String[] args) {

      int[][] a = { { 1, 0, 2 }, { 0, 0, 3 }, { 0, 2, 4 } };

      for (int i = 0; i < a.length; i++) {
         LOOP1:for (int j = 0; j < a.length - 1; j++) {
            if (a[i][j] != 0) {
               for (int k = j + 1; k < a.length; k++) {
                  if (a[i][k] != 0) {
                     if (a[i][j] != a[i][k]) {
                        if (k == j + 1) {
                           System.out.println("right error " + "i: " + i + " j:" + j + " k: " + k);
                        }
                     } else {
                        System.out.println("okay " + "i: " + i + " j:" + j + " k: " + k);
                     }
                  } else if (a[i][k] == 0) {
//                     두 좌표 사이에 0이 존재한다면 true
                     System.out.println("zero " + "i: " + i + " j:" + j + " k: " + k);
                  }
               }
            }
            if (a[i][a.length - 1] != 0) {
               // 0 0 2
               // 0 0 4
               // 0 0 2 일때
               for (int k = a.length - 2; k >= 0; k--) {
//                  !=0 기준으로 왼쪽에 숫자가 있는지 있다면 같은지 - true 다른지 - false
                  if (a[i][k] != 0) {
                     System.out.println("bark! " + "i: " + i + " j:" + j + " k: " + k + " num: " + a[i][k]);
                  } else {
//                     없는지 없다면 j스캔 그만하고 i++
                     System.out.println("zero2 " + "i: " + i + " j:" + j + " k: " + k);
                     break LOOP1;
                  }
               }
            }
         }
      }

      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a.length; j++) {
            System.out.print(a[i][j] + " ");
         }
         System.out.println();
      }

   }

}