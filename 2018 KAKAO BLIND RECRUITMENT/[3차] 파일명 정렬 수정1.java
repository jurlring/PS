import java.util.*;
class Solution {
    static String[] solution(String[] files) {
		int [][] number=new int[files.length][2];
		String t="";
		int[] tmp={0,0};
		for(int i=0;i<files.length;i++){
			int j;
			for(j=0;j<files[i].length();j++){
				if (files[i].charAt(j)>='0'&&files[i].charAt(j)<='9')
					break;
			}
			int a=0;
			number[i][1]=j;//숫자가 처음 나오는 index저장
			//숫자 찾을 때 
			//예외1 -> 파일명을 넘어가면 안됨
			//예외2 -> number는 0~99999이므로 최대 5자리임
			//예외3 -> 숫자가 아니면 멈춰야함
			while(j<files[i].length()&&number[i][1]+4>=j&&files[i].charAt(j)>='0'&&files[i].charAt(j)<='9'){
				a=a*10+files[i].charAt(j++)-'0';
			}
			number[i][0]=a;//number저장
		}
		for(int i=0;i<files.length-1;i++){//selectionsort
			int k=i;
			for(int j=i+1;j<files.length;j++){
				String a=files[k].substring(0, number[k][1]),b=files[j].substring(0,number[j][1]);
				if (a.compareToIgnoreCase(b)<0){//a가 b보다 앞
					continue;
				}
				else if (a.compareToIgnoreCase(b)>0){//b가 a보다 앞
					k=j;
				}
				else {//문자열이 같으면
					if (number[k][0]<number[j][0]){//a가 b보다 앞
						continue;
					}
					else if (number[k][0]>number[j][0]){//b가 a보다 앞
						k=j;
					}
				}
			}
			t=files[i];
			files[i]=files[k];
			files[k]=t;
			tmp=number[i];
			number[i]=number[k];
			number[k]=tmp;
		}
        return files;
    }//1,2,13,14,15,17 
	    public static void main(String[] args) {
        String [] m={"img12.png", "img10.png", "img02.png", "iMg1.png", "IMG01.GIF", "img2.JPG","F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String [] k=solution(m);
		for(int i=0;i<k.length;i++)
			System.out.println(k[i]);
    }
}
