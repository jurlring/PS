import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class Food implements Comparable<Food> {

	int t;
	int i;

	public Food(int t, int i) {
		this.t = t;
		this.i = i;
	}
	
	@Override//우선순위 큐에서 비교하기 위해 사용
	public int compareTo(Food other) {
		return Integer.compare(this.t, other.t);
	}
}
class Solution {
    static int solution(int[] food_times, long k) {
		Long totalsum=(long) 0;
		PriorityQueue<Food> queue=new PriorityQueue<Food>();

		for(int j=0;j<food_times.length;j++){
			totalsum+=food_times[j];
			queue.offer(new Food(food_times[j],j+1));
		}
		if (totalsum<=k)//예외처리!!!!!!!
			return -1;
		long total=(long) 0;//지나간 시간
		int prev=0;//마지막으로 없앤 시간
		int length=food_times.length;
		while(total+length*(queue.peek().t-prev)<=k){
			int now=queue.poll().t;
			total+=(now-prev)*length;
			length--;
			prev=now;
		}
		List<Food> foods=new ArrayList<>();
		while(!queue.isEmpty()){
			foods.add(queue.poll());
		}
		Collections.sort(foods,new Comparator<Food>(){

			@Override
			public int compare(Food o1, Food o2) {
				return Integer.compare(o1.i,o2.i);
			}
		});
        return foods.get((int)((k-total)%length)).i;
    }
		public static void main(String[] args) {
        int [] ans={5,1,4,2,3};
		System.out.println(solution(ans, 12));
		
		//System.out.println("gos".compareTo("gz"));
    }
}