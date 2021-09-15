import java.util.*;
import java.util.Map.Entry;
class Solution {
	static Map<String,Integer> map;//메뉴 조합과 나온 횟수를 저장할 map
	public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
		for(int i=0;i<orders.length;i++){
			orders[i]=sorting(orders[i]);//알파벳 순서대로 정렬
		}
		for(int i=0;i<course.length;i++){
			map=new HashMap<>();
			int max=Integer.MIN_VALUE;
			for(String order:orders){
				StringBuilder sb=new StringBuilder();
				if (order.length()>=course[i])//해당 문자열이 원하는 코스 수 보다 크거나 같을 경우 조합
					mapping(order, sb, 0, 0, course[i]);//조합
			}
			for(Entry<String, Integer> m:map.entrySet()){//가장 많이 나온 수 찾기
				max=Math.max(max,m.getValue());
			}
			if (max<2)//2번 이상 나오지 않으면 다시 돌아가기
				continue;
			for(Entry<String, Integer> m:map.entrySet()){
				if (m.getValue()==max)
					answer.add(m.getKey());
			}
		}
		Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
	private String sorting(String string) {
		char[] arr=string.toCharArray();
		Arrays.sort(arr);
		string=String.valueOf(arr);
		return string;
	}
	static void mapping(String order,StringBuilder sb,int idx,int cnt,int n){
		if (cnt==n){
			map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
			return;
		}
		for(int i=idx;i<order.length();i++){
			sb.append(order.charAt(i));
			mapping(order, sb, i+1, cnt+1, n);
			sb.delete(cnt, cnt+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
	}
}