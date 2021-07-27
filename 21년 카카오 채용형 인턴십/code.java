import java.util.*;
class Solution {
    static String solution(int n, int k, String[] cmd) {
        String answer = "";
        List<Integer> result=new LinkedList<>();
        Stack<List> stack=new Stack<>();
        for(int i=0;i<n;i++){
            result.add(i, i);
            answer+="X";
        }
        for(String s:cmd){
            if (s.charAt(0)=='D'){
                k+=Integer.parseInt(s.substring(2));
            }
            else if (s.charAt(0)=='U'){
                k-=Integer.parseInt(s.substring(2));
            }
            else if (s.charAt(0)=='C'){
                List<Integer> a=new ArrayList<>();
                a.add(k);
                a.add(result.get(k));
                stack.add(a);
                result.remove(k);
                if (k==result.size())
                    k--;
            }
            else{
                List<Integer> a=stack.pop();
                int k1=a.get(0),k2=a.get(1);
                if (k1<=k)//등호 안해줘서 틀렸었음;
                    k++;
                result.add(k1, k2);
            }
        }
        for(int i=0;i<result.size();i++){
            int a = result.get(i);
            answer=answer.substring(0,a)+"O"+answer.substring(a+1);
        }
        return answer;
    }
    //stack, result 출력 부분에서 시간이 오래 걸리는 듯 하다 해결 책을 찾자~!
    public static void main(String[] args) {
        String a="1D2S3T*";
    }
}