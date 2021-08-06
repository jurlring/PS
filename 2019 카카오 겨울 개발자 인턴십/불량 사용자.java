import java.util.*;
class Solution {
    public HashSet<Set> set=new HashSet<Set>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0; 
        HashMap<Integer,List> x=new HashMap<Integer,List>();
        String b,d;
        for(int i=0;i<banned_id.length;i++) {
        	List<Integer> y=new ArrayList<Integer>();
        	int a=0;
        	y=new ArrayList<Integer>();        	
        	for(int j=0;j<user_id.length;j++) {
        		b=user_id[j];
        		d=banned_id[i];
        		boolean p=true;
        		if (b.length()==d.length()) {
        			for(int k=0;k<d.length();k++) {
        				if (d.charAt(k)!=b.charAt(k)) {
        					if (d.charAt(k)!='*') {
        						p=false;
        					}
        				}
        			}
        			if (p) {
        			y.add(j);
        			}
        		}
        	}
        	x.put(i, y);
        }
        match(x,0,new HashSet<Integer>());
        answer=set.size();
        return answer;
    }
    public void match(HashMap<Integer,List> x,int index,HashSet<Integer> s) {
    	if (index==x.size())
    		return;
    	List<Integer> a=x.get(index);
    	if (x.size()-1==index) {
    		for(int i=0;i<a.size();i++) {
    			if (s.add(a.get(i))) {
    				HashSet<Integer> p=new HashSet<>(s);
    				set.add(p);
    				s.remove(a.get(i));
    			}
    		}
    		return;
    	}
    	if (a.size()==0)
    		match(x,index+1,s);
    	for(int i=0;i<a.size();i++) {
    		if (s.add(a.get(i))){
    			match(x,index+1,s);
    			s.remove(a.get(i));
    		}
    	}
    }
    public static void main(String[] args) {
        String m="KAKAO";
        int []x=solution(m);
        for(int i=0;i<x.length;i++)
            System.out.println(x[i]);
    }
}