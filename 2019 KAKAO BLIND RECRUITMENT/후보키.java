import java.util.*;
class Solution {
    static boolean[] visit;
    static List<List<Integer>> d=new ArrayList<>();
    static int solution(String[][] relation) {
        int answer = 0;
        visit=new boolean[relation[0].length];
        dfs(0,relation[0].length);
        List<List<Integer>> key=unique(d,relation);
        Comparator <List> c = new Comparator<List>() { 
            public int compare(List s1, List s2) { 
                return Integer.compare(s1.size(), s2.size()); } };
        Collections.sort(key,c);
        for(int i=0;i<key.size();i++){
            for(int j=i+1;j<key.size();j++){
                if (key.get(j).containsAll(key.get(i))){
                    key.remove(j);
                    j--;
                }
            }
        }
        return key.size();
    }
    static List<List<Integer>> unique(List<List<Integer>> list,String [][] rel){
        List<List<Integer>> key=new ArrayList<>();
        for(int i=0;i<list.size();i++){//부분집합 만큼 반복
            List<Integer> superkey=list.get(i);
            Set<List<String>> set=new HashSet<>();
            for(int j=0;j<rel.length;j++){//튜플 수 만큼 반복
                List<String> a=new ArrayList<>();
                for(int k=0;k<superkey.size();k++){//부분집합안의 수만큼 새로운 튜플 만들기
                    a.add(rel[j][superkey.get(k)]);
                }
                set.add(a);
            }
            if (set.size()==rel.length)
                key.add(superkey);
        }
        return key;
    }
    static void dfs(int n,int L){
        if (n==L)
        {List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if (visit[i])
                    list.add(i);
            }
            d.add(list);
        }
        else {
            visit[n]=true;
            dfs(n+1,L);
            visit[n]=false;
            dfs(n+1,L);
        }
    }
		public static void main(String[] args) {
        String [][] ans={{"100","ryan","music","2"},{"200","apeach","math","2"},
        {"300","tube","computer","3"},{"400","con","computer","4"},
        {"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(solution(ans));
		
		//System.out.println("gos".compareTo("gz"));
    }
}