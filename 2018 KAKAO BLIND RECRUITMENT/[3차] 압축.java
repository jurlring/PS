import java.util.*;
class Solution {
    static int[] solution(String msg) {
        int[] answer;
        List<Integer> result=new ArrayList<Integer>();
        List<String> lzw=new ArrayList<String>();
        for(int i=0;i<26;i++){
            char ti=(char) ('A'+i);
            String t="";
            t+=ti;
            lzw.add(t);
        }
        for(int i=0;i<msg.length();){
            String a="";
            int index=0;
            while(a==""||(i<msg.length()&&lzw.contains(a))){
                a+=msg.charAt(i++);
                if (lzw.contains(a))
                    index=lzw.indexOf(a);
            }
            if (!lzw.contains(a))
                i--;
            result.add(index+1);
            lzw.add(a);
        }
        answer=new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        String m="KAKAO";
        int []x=solution(m);
        for(int i=0;i<x.length;i++)
            System.out.println(x[i]);
    }
}