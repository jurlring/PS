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
		for(int i=1;i<files.length;i++){//insertionsort -> stable sort!
			int [] saves=number[i];
			String save=files[i];
			int j=i-1;
			String a=files[i].substring(0, number[i][1]);
			while(j>=0){//j를 --하면서 i번째 값보다 작은 값 찾기
				String b=files[j].substring(0,number[j][1]);
				if (a.compareToIgnoreCase(b)<0){//i번째 값이 j번째 값보다 작음
					t=files[j];
					files[j]=files[j+1];
					files[j+1]=t;
					tmp=number[j];
					number[j]=number[j+1];
					number[j+1]=tmp;
				}
				else if (a.compareToIgnoreCase(b)>0){//i번째 값이 j번째 값보다 큼
					break;
				}
				else {//문자열이 같으면
					if (saves[0]<number[j][0]){//i번째 값이 j번째 값보다 작음
						t=files[j];
						files[j]=files[j+1];
						files[j+1]=t;
						tmp=number[j];
						number[j]=number[j+1];
						number[j+1]=tmp;
					}
					else if (number[i][0]>number[j][0]){//i번째 값이 j번째 값보다 큼
						break;
					}
				}
				j--;
			}
			number[j+1]=saves;
			files[j+1]=save;
		}
        return files;
    }//1,2,16,18,19,20
	    public static void main(String[] args) {
        String [] m={"img12.png", "img10.png", "img02.png", "iMg1.png", "IMG01.GIF", "img2.JPG"};
		String [] k=solution(m);
		for(int i=0;i<k.length;i++)
			System.out.println(k[i]);
    }
}