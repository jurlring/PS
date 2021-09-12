import java.util.*;
class Solution {
	static int solution(int n, int k) {
        int answer = 0;
		String ans=n(k,n);//n진수로 변환
		System.out.println(ans);
		String [] prime=ans.split("0");
		for(int i=0;i<prime.length;i++){
			if (prime[i].length()==0)
				continue;
			if (isprime(Integer.parseInt(prime[i]))){
				answer++;
			}
		}
        return answer;
    }

	static String n(int n, int num) { 
		String result = "";
        if (num == 0) {
            return "0";
        }

        while (num > 0) {
            int share = num / n;
            int remainder = num % n;
            if (remainder > 9) {
                result = (char) (remainder + 55) + result;
            } else {
                result = remainder + result;
            }
            num = share;
        }
        return result;
	}
	
	static boolean isprime(int num){
		if (num==1)
			return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                return false;
			}
        }
		return true;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println(solution(110011,10));	
	}

	
}