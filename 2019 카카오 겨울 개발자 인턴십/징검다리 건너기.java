import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int min=Integer.MAX_VALUE,a;
        for(int i=0;i<stones.length;i++) {
        	if (stones[i]<min) {
        		a=1;
        		for(int j=i-1;j>=0;j--) {
        			if (stones[j]-stones[i]>0)
        				break;
        			a++;
        			if (a==k)
        				break;
        		}
        		if (a==k) {
        			min=stones[i];
        			continue;
        		}
        		for(int j=i+1;j<stones.length;j++) {
        			if (stones[j]-stones[i]>0)
        				break;
        			a++;
        			if (a==k)
        				break;
        		}
        		if (a==k) 
        			min=stones[i];
        	}
        }
        return min;
    }
    public static void main(String[] args) {
        String [] m={"img202.png123","img100.p2ng"};
		String [] k=solution(m);
		for(int i=0;i<k.length;i++)
			System.out.println(k[i]);
    }
}