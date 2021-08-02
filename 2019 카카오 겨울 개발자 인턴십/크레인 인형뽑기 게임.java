import java.util.*;

class code {
public int solution(int[][] board, int[] moves) {
    	Stack<Integer> stack=new Stack<>();
        int answer = 0;    	
    	for(int i=0;i<moves.length;i++) {
    		for(int j=0;j<board.length;j++) {
    			if (board[j][moves[i]-1]!=0) {
    				if (stack.isEmpty()||stack.peek()!=board[j][moves[i]-1]) {
    					stack.add(board[j][moves[i]-1]);
    				}
    				else if (stack.peek()==board[j][moves[i]-1]) {
    					answer+=2;
    					stack.pop();
    				}
                    board[j][moves[i]-1]=0;
    				break;
    			}
    		}
    	}
        return answer;
    }
	public static void main(String[] args) {
    }
}