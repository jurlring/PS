import java.util.*;
class Solution {
    static int solution(String[] words) {
        int answer = 0;
		int n=words.length;
		int [] ans=new int [n];
		Arrays.fill(ans, 1);
		Arrays.sort(words);
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if (words[i].charAt(0)!=words[j].charAt(0))//앞글자가 다르면 
					break;//비교 중지!
				int c=words[i].compareTo(words[j]);
				int ch=words[j].length()-(-c);
				if (c<0&&ch>0&&words[i].equals(words[j].substring(0,ch))){//i번째 워드가 j번쪠 워드에 속해있다면
					ans[i]=Math.max(ans[i], words[i].length());
					ans[j]=Math.max(ans[j], words[i].length()+1);
				}
				else{//이외의 경우 겹치는 문자가 없을때까지 while
					c=0;
					while(words[i].charAt(c)==words[j].charAt(c)){
						c++;
					}
					ans[i]=Math.max(ans[i], c+1);
					ans[j]=Math.max(ans[j], c+1);
				}
			}
		}
		for(int i=0;i<n;i++){
			answer+=ans[i];
		}
        return answer;
    }
	    public static void main(String[] args) {
        String [] m={"word","war","warrior","world"};
		System.out.println(solution(m));
		//System.out.println("gos".compareTo("gz"));
    }
}