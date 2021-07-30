import java.util.Arrays;

class code {
    public int solution(String[] lines) {
        int answer = 0;
		double [][] log=new double[lines.length][2];
		for(int i=0;i<lines.length;i++){//끝나는 시간이랑 t를 double로 바꿔서 저장
			lines[i]=lines[i].substring(11).replace(":", "").replace("s","");
			String [] a=lines[i].split(" ");
			log[i][0]=Integer.parseInt(a[0].substring(0, 2))*3600+Integer.parseInt(a[0].substring(2,4))*60+Double.parseDouble(a[0].substring(4));
			log[i][1]=Double.parseDouble(a[1]);
		}
		for(int i=0;i<lines.length;i++){
			double in=log[i][0]+1;
			int count=1;
			for(int j=i+1;j<lines.length;j++){
				double s=log[j][0]-log[j][1]+0.001;
				if (in>s)
					count++;
			}
			if (answer<count)
				answer=count;
		}
        return answer;
    }
	public static void main(String[] args) {
		String [] t={"2016-09-15 20:59:57.421 0.351s",
		"2016-09-15 20:59:58.233 1.181s",
		"2016-09-15 20:59:58.299 0.8s",
		"2016-09-15 20:59:58.688 1.041s",
		"2016-09-15 20:59:59.591 1.412s",
		"2016-09-15 21:00:00.464 1.466s",
		"2016-09-15 21:00:00.741 1.581s",
		"2016-09-15 21:00:00.748 2.31s",
		"2016-09-15 21:00:00.966 0.381s",
		"2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(t));
    }
}