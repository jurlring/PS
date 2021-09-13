import java.util.*;
class Solution {
	static String solution(String new_id) {
        String answer = new_id;
		//1단계
		answer=answer.toLowerCase();

		//2단계 -> 정규표현식 이용
		answer=answer.replaceAll("[^-_.a-z0-9]", "");//[^ ...]->[]사이에 있는 임의의 한 문자 또는 문자집합 제외
		
		//3단계
		answer=answer.replaceAll("[.]{2,}", ".");//[.]{2,}->[]안의 문자열이 {n,} n번 이상 일치
		
		//4단계
		answer=answer.replaceAll("^[.]|[.]$", "");//^-> 문자열의 시작,$-> 문자열의 끝, ㄱ|ㄴ-> ㄱ또는ㄴ과 일치, 즉 시작에서 .과 끝에서 .이면 replace
		
		//5단계
		if (answer.length()==0)//빈 문자열이라면 a추가
			answer+="a";

		//6단계
		if (answer.length()>15){
			answer=answer.substring(0, 15);//0~14
			answer=answer.replaceAll("[.]$", "");
		}

		//7단계
		if (answer.length()<3){//길이가 3보다 작으면 
			while(answer.length()<3){
				answer+=answer.charAt(answer.length()-1);
			}
		}

        return answer;
    }
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println(solution("=.="));
	}
}
//정규표현식을 사용하여 풀어보았다.
//사용해보니 편리한 것 같다. 자주 써서 손에 익혀야겠다.