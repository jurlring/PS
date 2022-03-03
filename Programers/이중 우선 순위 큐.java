import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
public class Solution {

    private static final int COMMAND_INDEX=0;
    private static final int NUMBER_INDEX=1;
    private static final int MAX_NUMBER_INDEX=0;
    private static final int MIN_NUMBER_INDEX=1;

    static Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder()); 
    static Queue<Integer> minQueue = new PriorityQueue<>(); 

	public static int[] solution(String[] operations) {
		int[] answer = {0,0};
		Arrays.stream(operations).forEach(element -> operate(element.split(" ")));
        if (!maxQueue.isEmpty()||!minQueue.isEmpty()){
            answer[MAX_NUMBER_INDEX]=maxQueue.poll();
            answer[MIN_NUMBER_INDEX]=minQueue.poll();
        }
		return answer;
	}

	private static void operate(String[] operator) {
		if (operator[COMMAND_INDEX].equals("I")){
			maxQueue.add(Integer.parseInt(operator[NUMBER_INDEX]));
            minQueue.add(Integer.parseInt(operator[NUMBER_INDEX]));
            return;
		}
        if (!maxQueue.isEmpty() && operator[COMMAND_INDEX].equals("D")){
            substractQueue(operator);
        }
	}

    private static void substractQueue(String[] operator) {
        if (operator[NUMBER_INDEX].equals("1")){
            int max=maxQueue.poll();
            minQueue.remove(max);
        }
        else if (operator[NUMBER_INDEX].equals("-1")){
            int min=minQueue.poll();
            maxQueue.remove(min);
        }
    }

    public static void main(String[] args) {
        String[] oper ={"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(solution(oper)[1]);
    }

}