import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] ans={0,0,0};
        int index=0;
        for(int i=0;i<dartResult.length();i++){
            if (dartResult.charAt(i)=='*'){
                int c=index-1;
                while(c>=index-2){
                    ans[c--]*=2;
                }
                continue;
            }
            else if (dartResult.charAt(i)=='#'){
                ans[index-1]*=-1;
                continue;
            }
            if (dartResult.charAt(i)>='0'&&dartResult.charAt(i)<='9'){
                ans[index]=ans[index]*10+dartResult.charAt(i)-'0';
            }
            else if (dartResult.charAt(i)=='S'){
                index++;
            }
            else if (dartResult.charAt(i)=='D'){
                ans[index]*=ans[index];
                index++;
            }
            else if (dartResult.charAt(i)=='T'){
                ans[index]*=(ans[index]*ans[index]);
                index++;
            }

        }
        for(int i=0;i<3;i++){
            answer+=ans[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        String a="1D2S3T*";
        System.out.println(solution(a));
    }
}