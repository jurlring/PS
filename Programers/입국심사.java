import java.util.Arrays;

public class Solution {

    static long answer = Long.MAX_VALUE;
    static long start,mid,end;
    int people;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        start=0;
        end=times[times.length-1]*n;

        while(start<=end){
            mid=(start+end)/2;
            people=findAuditPeople(times, mid);
            findMinimumTime(n,people);
            System.out.println(start+""+end);
        }
        return answer;
    }

    public static void findMinimumTime(int n, int people) {
        if (people<n){ //n명보다 검사를 덜 했을 때
            start=mid+1;
        }
        else{
            end=mid-1;
            answer=Math.min(answer,mid);
        }
    }

    public static int findAuditPeople(int[] times, long mid) {
        int sum;
        sum=0;
        for(int time:times){
            sum+=mid/time;
        }
        return sum;
    }
}