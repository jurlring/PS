import java.util.*;
class Solution {
    static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
		Arrays.sort(stages);
		int total=stages.length;
		int c=0;
		Map<Integer,Float> map=new HashMap<>();
		float [] count=new float[N];
		for(int i=1;i<=N;i++){
			int co=0;
			while(c<stages.length&&i==stages[c++]){
				co++;
			}
			System.out.println(co+" "+total);
			map.put(i,co/(float)total);
			if (co==0)
			map.put(i,(float)0.0);
			total-=co;
			c--;
		}
		int []n=new int[N];
		for(Map.Entry<Integer,Float> entry : map.entrySet()){
			c=0;
			for(Float j:map.values()){
				if (entry.getValue()<j)
					c++;
			}
			answer[c+n[c]]=entry.getKey();
			n[c]++;
		}
        return answer;
    }
		public static void main(String[] args) {
        int []m={2,1,2,4,2,4,3,3};
		int []k=solution(5,m);
		for(int u:k){
			System.out.println(u);
		}
		//System.out.println("gos".compareTo("gz"));
    }
}