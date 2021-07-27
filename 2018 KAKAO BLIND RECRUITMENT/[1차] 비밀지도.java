import java.util.*;
class Solution {
    boolean [][]v;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        v=new boolean [n][n];
        binary(arr1,arr2);
        for(int i=0;i<n;i++){
            String a="";
            for(int j=n-1;j>=0;j--){
                if (v[i][j])
                    a+="#";
                else 
                    a+=" ";
            }
            answer[i]=a;
        }
        return answer;
    }
    public void binary(int[] arr1,int [] arr2){
        for(int i=0;i<arr1.length;i++){
            int c=0;
            while(arr1[i]>0&&arr2[i]>0){
                if (arr1[i]%2==1){
                    v[i][c]=true;
                }
                else if (arr2[i]%2==1)
                    v[i][c]=true;
                c++;
                arr1[i]/=2;
                arr2[i]/=2;
            }
        }

    }
    public static void main(String[] args) {
        int []arr1={46, 33, 33 ,22, 31, 50};
        int []arr2={27 ,56, 19, 14, 14, 10};
        solution(6, arr1, arr2);
        
    }
}