import java.util.*;
class Solution {
    static String[] solution(String[] record) {
		String [][] sp=new String[record.length][3]; 
		Map<String,String> id=new HashMap<>();
		List<String> list=new ArrayList<>();
		for(int i=record.length-1;i>=0;i--){//뒤에서 부터 닉네임 정해주기 위해서
			sp[i]=record[i].split(" ");//명령어 유저아이디 닉네임을 각각 분리한다
			if (sp[i][0].equals("Enter")||sp[i][0].equals("Change")){//enter,change일 경우 닉네임을 고정한다.
				if (!id.containsKey(sp[i][1])){
					id.put(sp[i][1], sp[i][2]);
				}
			}
		}
		for(int i=0;i<record.length;i++){
			if (sp[i][0].equals("Enter")){
				list.add(id.get(sp[i][1])+"님이 들어왔습니다.");
			}
			else if (sp[i][0].equals("Leave")){
				list.add(id.get(sp[i][1])+"님이 나갔습니다.");
			}
		}
		String[] answer=list.toArray(new String[list.size()]);
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