import java.util.*;

class code {
	static String solution(int n, int t, int m, int p) {
        String answer = "";
        int count=0,c=0;
        for(int i=0;;i++){
            int index=i;
            String make="";
            while(index>0){
                if (index%n>=10)//10넘어가는 거는 따로 처리
                    make+="A";
                else if (index%n==11)
                    make+="B";
                else if (index%n==12)
                    make+="C";
                else if (index%n==13)
                    make+="D";
                else if (index%n==14)
                    make+="E";
                else if (index%n==15)
                    make+="F";
                else 
                    make+=index%n;
                index=index/n;
            }
            if (i==0)
                make+="0";
            for(int j=make.length()-1;j>=0;j--){
                count++;
                if (count%m==p%m){
                    answer+=make.charAt(j);
                    c++;
                }
                if (c==t)
                    break;
            }
            if (c==t)
            break;
        }
        return answer;
    }
	public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));
        
    }
}