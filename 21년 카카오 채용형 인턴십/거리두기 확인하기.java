import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<5;i++){
            answer[i]=corona(places[i]);
        }
        return answer;
    }
    public int corona(String[] place){
        List<Integer> num=new ArrayList<Integer>();
        for(int i=0;i<5;i++){
            while(place[i].contains("P")){
                int a=place[i].indexOf("P");
                num.add((i+1)*10+a+1);
                place[i]=place[i].substring(0, a)+"p"+place[i].substring(a+1);
            }
        }
        for(int i=0;i<num.size()-1;i++){
            for(int j=i+1;j<num.size();j++){
                int a1=num.get(i)%10,a2=num.get(i)/10,b1=num.get(j)%10,b2=num.get(j)/10;
                int gap=Math.abs(a1-b1)+Math.abs(a2-b2);
                if (gap>2)
                    continue;
                if (gap==1)
                    return 0;
                if (a1==b1){
                    if (place[(a2+b2)/2-1].charAt(a1-1)=='O')
                        return 0;
                }
                else if (a2==b2){
                    if (place[a2-1].charAt((a1+b1)/2-1)=='O')
                        return 0;
                }
                else{
                    if (place[b2-1].charAt(a1-1)=='O')
                        return 0;
                    if (place[a2-1].charAt(b1-1)=='O')
                        return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
    }
}