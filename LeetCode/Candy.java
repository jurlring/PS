import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if (n==1)
        	return 1;
        int []x=new int [n];
        Arrays.fill(x, 1);
        for(int i=0;i<n-1;i++) {
        	if (ratings[i+1]>ratings[i])
        		x[i+1]=x[i]+1;
        	if (ratings[i+1]==ratings[i]&&x[i]!=1)
        		x[i+1]=1;
        }
        for(int i=0;i<n;i++) {
        	System.out.print(x[i]+" ");
        }
        System.out.println();
        for(int i=n-1;i>0;i--) {
        	if (ratings[i]<ratings[i-1]&&x[i-1]<x[i]+1)
        		x[i-1]=x[i]+1;
        }
        int sum=0;
        for(int i=0;i<n;i++) {
        	sum+=x[i];
        	System.out.print(x[i]+" ");
        }
        return sum;
    }
		public static void main(String[] args) {
        int [] ans={5,1,4,2,3};
		System.out.println(solution(ans, 12));
		
		//System.out.println("gos".compareTo("gz"));
    }
}