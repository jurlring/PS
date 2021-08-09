import java.util.*;
class Solution {
    HashMap<Long,Long> map=new HashMap<Long,Long>();
	public long[] solution(long k, long[] room_number) {
	int n = room_number.length;
	long[] answer = new long[n];
	for (int i = 0; i < n; i++) {
			answer[i] = find(room_number[i]);
		}

		return answer;
	}
	public long find(long r) {
		if (!map.containsKey(r)) {
			map.put(r,r+1);
			return r;
		}
		long next=map.get(r);
		long empty=find(next);
		map.put(r,empty+1);
		return empty;
		}
    public static void main(String[] args) {
        String [] m={"img202.png123","img100.p2ng"};
		String [] k=solution(m);
		for(int i=0;i<k.length;i++)
			System.out.println(k[i]);
    }
}