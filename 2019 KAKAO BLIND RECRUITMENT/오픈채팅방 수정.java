import java.util.*;
class Solution {
    static String[] solution(String[] record) {
		Map<String,String> id=new HashMap<>();
		List<String> list=new ArrayList<>();
		for(int i=0;i<record.length;i++){
			String [] spl=record[i].split(" ");
			if (spl[0].equals("Enter")||spl[0].equals("Change")){//enter,change일 경우 닉네임을 맵에 추가,수정한다.
				id.put(spl[1], spl[2]);
			}
			if (spl[0].equals("Enter")||spl[0].equals("Leave")){//로그에 찍혀야하는경우 리스트에 넣는다.
				list.add(spl[0]+" "+spl[1]);
			}
		}
		String[] answer=new String[list.size()];
		for(int i=0;i<list.size();i++){
			String []spl=list.get(i).split(" ");
			String in;
			if (spl[0].equals("Enter"))
				in="들어왔습니다.";
			else 
				in="나갔습니다.";
			answer[i]=id.get(spl[1])+"님이 "+in;
		}
        return answer;
    }
		public static void main(String[] args) {
        String [] ans={"Enter uid0606 Gimoi", "Enter uid4567 Prodo", "Leave uid0606", "Enter uid1234 Prodo", "Change uid1234 OhYeah"};
		String []k=solution(ans);
		for(String u:k){
			System.out.println(u);
		}
		//System.out.println("gos".compareTo("gz"));
    }
}