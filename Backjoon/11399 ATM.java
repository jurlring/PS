import java.util.*;
class Solution {
    	public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            int [] time=new int[n];
            for(int i=0;i<n;i++)
                time[i]=s.nextInt();
            Arrays.sort(time);
            int sum=0;
            int count=0;
            for(int i=0;i<n;i++){
                count+=time[i];
                sum+=count;
            }
            System.out.println(sum);
    }
}