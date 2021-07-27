import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize==0)
            return 5*cities.length;
        Queue<String> queue=new LinkedList<String>();
        for(String city:cities){
            city=city.toUpperCase();
            if (queue.contains(city)){
                List<String> list=new LinkedList<String>(queue);
                int index=list.indexOf(city);
                list.remove(index);
                queue=new LinkedList<String>(list);
                queue.add(city);
                answer+=1;
            }
            else {
                if (queue.size()>=cacheSize){
                    queue.remove();
                }
                queue.add(city);
                answer+=5;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String []s={"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(2,s));
    }
}