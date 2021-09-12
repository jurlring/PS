import java.util.*;
import java.util.Map.Entry;
class TrieNode{
	private Map<Character,TrieNode> childnode =new HashMap<>();//자식 노드 map에 저장
	private boolean isLast;//마지막 노드인지 저장

	Map<Character,TrieNode> getChildnode(){
		return this.childnode;
	}
	boolean getisLast(){
		return this.isLast;
	}
	void setisLast(boolean isLast){
		this.isLast=isLast;
	}
}
class Trie{
	TrieNode rootNode;//루트 노드 필드에 저장

	Trie(){
		rootNode=new TrieNode();
	}

	void insert(String word){
		TrieNode thisNode=this.rootNode;
		for(int i=0;i<word.length();i++){
			thisNode=thisNode.getChildnode().computeIfAbsent(word.charAt(i), c-> new TrieNode());
		}
		thisNode.setisLast(true);
	}

	boolean contains(String word){
		TrieNode thisNode=this.rootNode;
		for(int i=0;i<word.length();i++){
			char character=word.charAt(i);
			TrieNode node=thisNode.getChildnode().get(character);
			if (node==null)
				return false;
			thisNode=node;
		}
		return thisNode.getisLast();
	}
}
class Solution {
	static int [] answer;
	public static int[] solution(String[] words, String[] queries) {
        answer = new int [queries.length];
		Trie trie=new Trie();
		for(String word:words){
			trie.insert(word);
		}
		for(int i=0;i<queries.length;i++){
			iscontains(queries[i], 0, trie.rootNode, i);
		}
        return answer;
    }
	static void iscontains(String query,int i,TrieNode thisNode,int wordindex){
		if (i==query.length()){//query만큼 반복했을 때
			if (thisNode.getisLast()){
				answer[wordindex]++;
				return;
			}
			else
				return;
		}
		char c=query.charAt(i);
		if (c!='?'){//?가 아니라면 해당 문자에 맞는 trienode찾기
			TrieNode node=thisNode.getChildnode().get(c);
			if (node==null)//만약 없다면 끝
				return;
			System.out.println(c+" "+i);
			//있다면 다음 index와 다음 노드 리턴
			iscontains(query, i+1, node,wordindex);
		}
		else {//?라면 모든 child map뒤져서 찾기
			Map<Character,TrieNode> childnode=thisNode.getChildnode();
			for(Entry<Character, TrieNode> entry:childnode.entrySet()){
				TrieNode node= entry.getValue();
				if (node==null)
					continue;
				System.out.println(i+" "+entry.getKey());
				iscontains(query, i+1, node, wordindex);
			}
		}
	} 
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String []a={"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String []b={"fro??", "????o", "fr???", "fro???", "pro?"};
		solution(a,b);	
	}
}