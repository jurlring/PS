import java.util.*;
class Link {
    String url;
    int basic;
    double match=0;
    List<String> href=new ArrayList<>();
    public Link(String url,int basic, List<String> href){
        this.url=url;
        this.basic=basic;
        this.href=href;
    }
}
class Solution {
    
    static List<Link> links=new ArrayList<>();
    static int solution(String word, String[] pages) {
        int answer = 0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<pages.length;i++){
            //url알아내기
            String [] sp=pages[i].split("<meta property=\"og:url\" content=\"https://|<a href=\"https://");
            String [] spi=sp[1].split("\"");
            String url=spi[0];
            List<String> hr=new ArrayList<>();//링크들 모아놓을 리스트
            //링크 찾기
            for(int j=2;j<sp.length;j++){
                spi=sp[j].split("\"");
                hr.add(spi[0]);
            }
            word=word.toUpperCase();//대문자로 바꿔서 찾기
            pages[i]=pages[i].toUpperCase();//대문자로 바꾸기
            int b=0,index=pages[i].indexOf(word); 
            while(index!=-1){//일치하는 문자의 시작 위치
                if (!Character.isLetter(pages[i].charAt(index-1))&&!Character.isLetter(pages[i].charAt(index+word.length())))
                    b++;//양옆이 문자가 아니라면 기본점수 더하기
                index=pages[i].indexOf(word,index+word.length());
            }
            map.put(url,i);//링크 찾기 쉽게 맵 이용
            links.add(new Link(url,b,hr));
        }
        for(int i=0;i<links.size();i++){//매칭점수 구하기
            for(int j=0;j<links.get(i).href.size();j++){
                String u=links.get(i).href.get(j);
                if (!map.containsKey(u))
                    continue;
                int index=map.get(u);
                links.get(index).match+=(double)links.get(i).basic/(double)links.get(i).href.size();
            }
        }
        double max=0;
        for(int i=0;i<links.size();i++){//제일 높은 점수인 링크 구하기
            if (max<links.get(i).basic+links.get(i).match){
                answer=i;
                max=links.get(i).basic+links.get(i).match;
            }
        }
        return answer;
    }
		public static void main(String[] args) {
        String [] l={"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		System.out.println(solution("blind",l));
    }
}