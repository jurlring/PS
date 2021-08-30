import java.util.*;
class Solution {
    static int solution(String s) {
        int answer = Integer.MAX_VALUE,i,j;
        for(i=1;i<s.length();i++){//자를 단위 i
            String prev=s.substring(0,i),next="";
            int count=1;
            int min=0;
            for(j=i;j<s.length();j+=i){
                if (j+i>s.length()){
                    break;
                }
                next=s.substring(j, j+i);
                if (next.equals(prev)){//prev와 next가 같은 경우 카운트
                    count++;
                }
                else {
                    if (count==1){//겹치는게 없는 경우 자른 단위길이 더하기
                        min+=i;
                    }
                    else {//겹치는게 있는 경우
                        String ans=prev+count;//더할 문자열 구하기
                        min+=ans.length();
                        count=1;//count초기화
                    }
                }
                prev=next;//prev를 next로 바꾸기
                
            }
            if (count==1){//겹치는게 없는 경우 자른 단위길이 더하기
                min+=i;
            }
            else {//겹치는게 있는 경우
                String ans=prev+count;//더할 문자열 구하기
                min+=ans.length();
            }
            System.out.print(min);
            min+=s.length()-j;
            System.out.println(" "+min);
            answer=Math.min(min,answer);
        }
        return answer;
    }
    	public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            String sa="a";
            System.out.println(solution(sa));
            
    }
}