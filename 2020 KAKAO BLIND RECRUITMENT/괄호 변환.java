import java.util.*;
class Solution {
    static String solution(String p) {
        String answer = rightString(p);
        return answer;
    }
    static String rightString(String p){
        if (p=="")
            return "";
        int c=0;
        String u="",v="";
        for(int i=0;i<p.length();i++){
            if (p.charAt(i)=='(')
                c++;
            else 
                c--;
            u+=p.charAt(i);
            if (c==0){
                v=p.substring(i+1);
                break;
            }
        }
        if (right(u))
            return u+rightString(v);
        return "("+rightString(v)+")"+reverse(u.substring(1,u.length()-1));
    }
    static String reverse(String u){
        String re="";
        for(int i=0;i<u.length();i++){
            if (u.charAt(i)==')')
                re+="(";
            else 
                re+=")";
        }
        return re;
    }
    static boolean right(String u){
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<u.length();i++){
            if (u.charAt(i)=='(')
                queue.add(i);
            if(!queue.isEmpty()&&u.charAt(i)==')')
                queue.poll();
        }
        if (queue.isEmpty())
            return true;
        else
            return false;
    }
    	public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            String sa=")()()()(()";
            System.out.println(solution(sa));
            
    }
}