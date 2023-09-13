package Veiw;
// View는 사용자에게 보이는 부분 main 함수

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

import Model.*;

public class ViewMain {
	public static void main(String[] args) {
		new ViewMain();
	}

	public ViewMain() {
		// 입력 도구생성
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		UserInfoDAO dao = new UserInfoDAO();
		UserInfoDTO dto;

		while (true) {
			int qeu = question();
			if(qeu == 1) {
				// 전체 테이블 출력
				System.out.println("====CLOUDMEMBER TABLE을 출력합니다====");
				dao.PrintTable("SCORE");
				
			}else if(qeu == 2) {
				// 회원가입
				System.out.println("====회원가입====");
				if(join()) {
					System.out.println("회원가입에 성공했습니다.");
				}else {
					System.out.println("회원가입에 실패했습니다.");
				}
			}else if(qeu == 3) {
				// 로그인
				System.out.println("====로그인====");
				dto = login();
				if(dto == null) {
					System.out.println("등록되지 않은 아이디 혹은 비밀번호입니다.");
					continue;
				}
				
				// 이제 여기서부터 게임을 실행
				int score = 0;
				for(int i = 0; i < 10; i++) {
					int a = rd.nextInt(8) + 2;
					int b = rd.nextInt(8) + 2;
					
					System.out.print(a + " * " + b + " = ");
					int ans = sc.nextInt();
					
					if(a*b == ans) {
						score++;
					}
				}
				
				System.out.println("현재 점수는 " + score + "점입니다.");
				
				if(dto.getScore() < score) {
					System.out.println("최고 점수는 " + score + "점입니다.");
					dto.setScore(score);
					setdata(dto);
				}else {
					System.out.println("최고 점수는 " + dto.getScore() + "점입니다.");
				}
				
			}else if(qeu == 4) {
				// 회원탈퇴
				System.out.println("====회원탈퇴====");
				if(withdraw()) {
					System.out.println("회원탈퇴에 성공했습니다.");
				}else {
					System.out.println("회원탈퇴에 실패했습니다.");
				}
			}else if(qeu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public int question() {
		Scanner sc = new Scanner(System.in);

		System.out.println("====보기를 선택해주세요====");
		System.out.print("[1]테이블보기 [2]회원가입 [3]로그인 [4]회원탈퇴 [5]종료 >> ");
		int input = sc.nextInt();
		sc.nextLine();
		
		System.out.println();
		return input;
	}
	
	public boolean join() {
		Scanner sc = new Scanner(System.in);

		System.out.print("ID을 입력해주세요 >> ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 >> ");
		String pw = sc.nextLine();
		System.out.print("닉네임을 입력해주세요 >> ");
		String nickname = sc.nextLine();
		
		UserInfoDTO dto = new UserInfoDTO(id, pw, nickname);
		UserInfoDAO dao = new UserInfoDAO();
		
		return dao.Join(dto);
	}
	
	public boolean withdraw() {
		Scanner sc = new Scanner(System.in);

		System.out.print("ID을 입력해주세요 >> ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 >> ");
		String pw = sc.nextLine();
		
		UserInfoDTO dto = new UserInfoDTO(id, pw, "");
		UserInfoDAO dao = new UserInfoDAO();
		
		return dao.Withdraw(dto);
	}
	
	public UserInfoDTO login() {
		Scanner sc = new Scanner(System.in);

		System.out.print("ID을 입력해주세요 >> ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 >> ");
		String pw = sc.nextLine();
		
		UserInfoDTO dto = new UserInfoDTO(id, pw, "");
		UserInfoDAO dao = new UserInfoDAO();
		
		return dao.login(dto);
	}
	
	public Boolean setdata(UserInfoDTO dto) {
		UserInfoDAO dao = new UserInfoDAO();
		return dao.SetData(dto);
	}
}
