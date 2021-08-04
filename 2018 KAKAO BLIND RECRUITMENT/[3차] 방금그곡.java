package java;

class Solution {
    static String solution(String m, String[] musicinfos) {
        String answer = "";
        String [][] music=new String[musicinfos.length][4];
        int ctime=0;//조건이 일치하는 음악 길이 저장
        m=m.replaceAll("A#", "a").replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g");//#바꾸기
        for(int i=0;i<musicinfos.length;i++){
            music[i]=musicinfos[i].split(",");
            int time=(Integer.parseInt(music[i][1].substring(0,2))-Integer.parseInt(music[i][0].substring(0,2)))
            *60+Integer.parseInt(music[i][1].substring(3,5))-Integer.parseInt(music[i][0].substring(3,5));//시간 재기
            music[i][3]=music[i][3].replaceAll("A#", "a").replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g");//#바꾸기
            String realmusic="";
            for(int j=0;j<time/music[i][3].length();j++)
                realmusic+=music[i][3];
            realmusic+=music[i][3].substring(0, time%music[i][3].length());
            if (realmusic.contains(m)&&ctime<time){
                answer=music[i][2];
                
            }
        }
        return answer;
    }
    //1. 문자열 파싱
    //a. #처리 -> replaceAll b. 음악시간만큼 반복 c. m이 musicinofs에 있는지 contains로 확인
    //2. 시간 비교 -> ctime이라는 변수를 만들어서 time저장
    public static void main(String[] args) {
        String m="CC#BCC#BCC#BCC#B";
        String [] mu={"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m,mu));
        
        
    }
}