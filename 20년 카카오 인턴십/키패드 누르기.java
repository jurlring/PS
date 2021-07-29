import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int l=10,r=12,le,ri;
        for(int num:numbers) {
        	if (num==0) {
        		num=11;
        		le=Math.abs(num-l);
        		ri=Math.abs(num-r);
        		le=le/3+le%3;
        		ri=ri/3+ri%3;
        		if (le>ri||(le==ri)&&hand.equals("right")) {//오른손이 더 가까울 때
        			answer+='R';
        			r=num;
        		}
        		else if (le<ri||(le==ri)&&hand.equals("left")) {//왼손이 더 가까울 때
        			answer+='L';
        			l=num;
        		}
        	}
        	else if (num%3==1) {//left
        		answer+='L';
        		l=num;
        	}
        	else if (num%3==0) {//right
        		answer+='R';
        		r=num;
        	}
        	else {//mid
        		le=Math.abs(num-l);
        		ri=Math.abs(num-r);
        		le=le/3+le%3;
        		ri=ri/3+ri%3;
        		if (le>ri||(le==ri)&&hand.equals("right")) {//오른손이 더 가까울 때
        			answer+='R';
        			r=num;
        		}
        		else if (le<ri||(le==ri)&&hand.equals("left")) {//왼손이 더 가까울 때
        			answer+='L';
        			l=num;
        		}
        	}
        }
        return answer;
    }
    public static void main(String[] args) {
        String []s={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4,5,s));
    }
}