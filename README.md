# SmartJava
JDBC을 사용하여 유저 데이터를 DB에 저장하고 불러오는 과정                
TABLE CLOUDMEMBER              
ID VARCHAR(50) PRIMARY KEY              
PW VARCHAR(50) NOT NULL              
NICKNAME VARCHAR(50) NOT NULL              
SCORE NUMBER DEFAULT 0              

게임은 구구단을 문제 풀어서 맞춘 개수를 저장했고 만약 현재 점수가 이전에 저장한 점수보다 높다면              
테이블을 UPDATE하여 최고점을 저장하도록 했다.              

<hr> </hr>
230914 콘솔에서만 실행하는 것이 매우 불편하여           
오늘은 GUI을 사용하여 창을 생성하고 마우스와 키보드 이벤트를 실행해보자.          
