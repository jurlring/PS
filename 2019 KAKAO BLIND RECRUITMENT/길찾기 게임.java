import java.util.*;
class Node{
    int index,x,y;
    Node left,right;

    public Node(int index,int x,int y){
        this.index=index;
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public static int index = 0;
    static List<Node> nodes=new ArrayList<>();
    static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            nodes.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }
        Comparator c=new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o2.y-o1.y;
            }
        };
        Collections.sort(nodes,c);
        Node root=nodes.get(0);
        for(int i=1;i<nodeinfo.length;i++){
            connect(root, nodes.get(i));
        }
        preorder(root, answer);
        index=0;
        postorder(root, answer);
        return answer;
    }
    static void preorder(Node root,int [][] answer){
        if (root!=null){
            answer[0][index++]=root.index;
            if (root.left!=null)
                preorder(root.left, answer);
            if (root.right!=null)
                preorder(root.right, answer);
        }
    }
    static void postorder(Node root,int [][] answer){
        if (root!=null){
            if (root.left!=null)
                postorder(root.left, answer);
            if (root.right!=null)
                postorder(root.right, answer);
            answer[1][index++]=root.index;
        }
    }
    static void connect(Node parent, Node child){
        if (parent.x>child.x){//왼쪽 짜식
            if (parent.left==null){
                parent.left=child;
            }
            else {
                connect(parent.left, child);
            }
        }
        else {//오른쪽 짜식
            if (parent.right==null){
                parent.right=child;
            }
            else{
                connect(parent.right, child);
            }
        }
    }
		public static void main(String[] args) {
        int [][] ans={{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(solution(ans).toString());
		
		//System.out.println("gos".compareTo("gz"));
    }
}