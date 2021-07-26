import java.util.Arrays;
import java.util.Collection;
import java.util.List;
public class code {
    public int solution(String s) {
        int answer = 0;
        String ans="";
        String [] num={"zero","one","two","three","four","five","six","seven","eight","nine"};
        List<String> n=Arrays.asList(num);
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)>='0'&&s.charAt(i)<='9')
                answer=answer*10+s.charAt(i)-'0';
            else {
                ans+=s.charAt(i);
                if (n.contains(ans)){
                    answer=answer*10+n.indexOf(ans);
                    ans="";
                }
            }
        }
        return answer;
}
    public static void main(String[] args) {
    }
}