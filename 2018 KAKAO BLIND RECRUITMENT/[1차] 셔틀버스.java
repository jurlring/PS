import java.util.Arrays;

class code {
    public String solution(int n, int t, int m, String[] timetable) {
		Arrays.sort(timetable);
		int num=0;//버스 탄 사람 수
		String time="09:00";//현재 가장 가까운 버스 도착 시간
		String [][] mem=new String[n][m];//시간대 별로 버스 탄 사람들
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if (num==timetable.length)
					break;
				if (time.compareTo(timetable[num])>=0){//버스 탈 수 있으면
					mem[i][j]=timetable[num++];
				}
				else {//버스 못타면 다음 시간으로..
					break;
				}
			}
			if (i!=n-1){
 				int b=Integer.parseInt(time.substring(3))+t;//분
				int c=Integer.parseInt(time.substring(0,2));//시
				if (b>=60){
					c+=1;
					b-=60;
				}
				if (c<10){
					time="0"+c+":";
				}
				else 
					time=""+c+":";
				if (b<10){
					time+="0"+b;
				}
				else 
					time+=b;
			}
		}
		if (mem[n-1][m-1]==null)
			return time;
		time=mem[n-1][m-1];
		int b=Integer.parseInt(time.substring(3))-1;//분
		int c=Integer.parseInt(time.substring(0,2));//시
		if (b<0){
			c-=1;
			b+=60;
		}
		if (c<10){
			time="0"+c+":";
		}
		else 
			time=""+c+":";
		if (b<10){
			time+="0"+b;
		}
		else 
			time+=b;
        return time;

    }
	//시간이 변하는 부분처리를 어떻게 할 지 고민하는데 시간이 조금 걸림
	public static void main(String[] args) {
		String [] t={"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		
        System.out.println(solution(10,60,45,t));
    }
}