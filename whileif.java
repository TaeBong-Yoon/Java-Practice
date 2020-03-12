package practice;

import java.util.*;

public class whileif {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		char keyCode = scan.next().charAt(0);
		do {
			System.out.println("프로그램을 시작하려면 enter 키를 누르세요");
			keyCode = scan.next().charAt(0);
			if ((keyCode == 13 && keyCode == 10)) {
			
				System.out.println("프로그램을 시작합니다.");
				System.out.println("PIN 번호 네자리를 입력하세요.");

				for (int n = 5; n >= 1; n--) {
					int pass = scan.nextInt();
					if (pass == 1357) {
						System.out.println("인증이 완료되었습니다.");
						break;
					} else {
						if (n > 1) {
							System.out.println("틀렸습니다.");
							System.out.println();
							System.out.println((n - 1) + "번 남았습니다.");
						}
						if (n == 1) {
							System.out.println("틀렸습니다.");
							System.out.println();
							System.out.println("횟수 초과");
						}
					}
				}
			}
		}System.out.println("재시작 하려면 enter키를 누르세요"); 
		while (keyCode == 13 && keyCode == 10);
	}
	
}
