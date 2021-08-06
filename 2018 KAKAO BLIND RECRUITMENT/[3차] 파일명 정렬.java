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
			number[i][1]=j;
			while(j<files[i].length()&&files[i].charAt(j)>='0'&&files[i].charAt(j)<='9'&&number[i][1]+4>=j){
				a=a*10+files[i].charAt(j++)-'0';
			}
			number[i][0]=a;
		}
		for(int i=0;i<files.length;i++){//정렬방법을 바꿔봐야겠다.
			for(int j=i+1;j<files.length;j++){
				String a=files[i].substring(0, number[i][1]),b=files[j].substring(0,number[j][1]);
				System.out.println(a+" "+b);
				if (a.compareToIgnoreCase(b)<0){//a가 b보다 앞
					continue;
				}
				else if (a.compareToIgnoreCase(b)>0){//b가 a보다 앞
					t=files[i];
					files[i]=files[j];
					files[j]=t;
					tmp=number[i];
					number[i]=number[j];
					number[j]=tmp;
				}
				else {//문자열이 같으면
					if (number[i][0]<number[j][0]){//a가 b보다 앞
						continue;
					}
					else if (number[i][0]>number[j][0]){//b가 a보다 앞
					t=files[i];
					files[i]=files[j];
					files[j]=t;
					tmp=number[i];
					number[i]=number[j];
					number[j]=tmp;
					}
				}
			}
		}
        return files;
    }
    public static void main(String[] args) {
        String [] m={"img202.png123","img100.p2ng"};
		String [] k=solution(m);
		for(int i=0;i<k.length;i++)
			System.out.println(k[i]);
    }
}