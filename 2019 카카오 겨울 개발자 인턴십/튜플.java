import java.util.*;

class code {
	public int[] solution(String s) {
        int a=0,b=0;
        List<Integer> abc=new ArrayList<Integer>();
        HashMap<Integer,List> arr=new HashMap<>();
        for(int i=1;i<s.length()-1;i++) {
        	if (s.charAt(i)=='{') {
        		abc=new ArrayList<>();
        	}
        	else if (s.charAt(i)=='}') {
        		abc.add(a);
        		arr.put(abc.size()-1, abc);
        		a=0;
        	}
        	else {
        		if (s.charAt(i)==','&&s.charAt(i-1)!='}') {
        			abc.add(a);
        			a=0;
        		}
        		else if (s.charAt(i)==','&&s.charAt(i-1)=='}')
        			continue;
        		else {
        			a=a*10+s.charAt(i)-'0';
        		}
        	}
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        abc=arr.get(arr.size()-1);
        for(int i=0;i<arr.size();i++) {
        	map.put(abc.get(i),i);
        }
        int [] answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++) {
        	abc=arr.get(i);
        	for(int j=0;j<abc.size();j++) {
        		a=abc.get(j);
        		if(map.containsKey(a)) {
        			answer[b++]=a;
        			map.remove(a);
        			break;
        		}
        	}
        }
        return answer;
    }//복잡하게 푼 것 같음
	public static void main(String[] args) {
    }
}