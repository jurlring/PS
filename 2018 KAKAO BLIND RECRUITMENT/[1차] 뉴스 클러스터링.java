import java.util.*;
class Solution {
    static int solution(String str1, String str2) {
        int answer = 65536;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        List<String> list1=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i=0;i<str1.length()-1;i++){
            if ((str1.charAt(i)>='a'&&str1.charAt(i)<='z')&&(str1.charAt(i+1)>='a'&&str1.charAt(i+1)<='z')){
                String a="";
                a+=str1.charAt(i);
                a+=str1.charAt(i+1);
                if (map1.containsKey(a)){
                    map1.put(a, map1.get(a)+1);
                    a+=map1.get(a);
                }
                else {
                    map1.put(a,0);
                    a+=0;
                }
                list1.add(a);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            if ((str2.charAt(i)>='a'&&str2.charAt(i)<='z')&&(str2.charAt(i+1)>='a'&&str2.charAt(i+1)<='z')){
                String a="";
                a+=str2.charAt(i);
                a+=str2.charAt(i+1);
                if (map2.containsKey(a)){
                    map2.put(a, map2.get(a)+1);
                    a+=map2.get(a);
                }
                else {
                    map2.put(a,0);
                    a+=0;
                }
                list2.add(a);
            }
        }
        List<String> list3=new ArrayList<String>(list1);
        list1.retainAll(list2);//교집합
        list2.addAll(list3);//합집합
        HashSet<String> set=new HashSet<>(list2);
        double a1=list1.size(),a2=set.size();
        if (a1==0)
            return 0;
        answer*=(a1/a2);
        System.out.println(a1+" "+a2);
        if (answer==0)
            return 65536;
        return answer;
    }
    //아니 교집합 합집합이 둘다 size가 0이면 1이고 교집합만 0이면 0을 리턴하는 거인데 문제 잘못읽어서 오래걸림ㅠㅠ
    public static void main(String[] args) {
        String a1="";
        String a2="";
        System.out.println();
        System.out.println(solution(a1, a2));
    }
}