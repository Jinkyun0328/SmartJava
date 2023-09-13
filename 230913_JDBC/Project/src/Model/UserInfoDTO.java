package Model;
// Model은 데이터와 관련된 부분을 다루는 곳

public class UserInfoDTO {
	// Data Transfer Object
	// 데이터를 전달할 자료형
	private String id;
	private String pw;
	private String nickname;
	private int score;
	
	// 생성자
	// 생성자는 회원가입할 때만 사용
	// 회원가입할 때는 id, pw, nickname만 기재하고 초기 점수는 0점
	public UserInfoDTO() {
		
	}
	
	public UserInfoDTO(String id, String pw, String nickname){
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.score = 0;
	}

	
	// get, set 함수
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
