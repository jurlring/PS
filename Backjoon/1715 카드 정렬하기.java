import java.util.*;
class Solution {
    	public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            PriorityQueue<Integer> queue=new PriorityQueue<>();

            for(int i=0;i<n;i++){
                int a=s.nextInt();
                queue.add(a);
            }
            int sum=0;
            for(int i=0;i<n-1;i++){
                int count=0;
                count+=queue.poll()+queue.poll();
                sum+=count;
                queue.add(count);
            }
            System.out.println(sum);
    }
}