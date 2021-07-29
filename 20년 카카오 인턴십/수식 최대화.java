```java
import java.util.*;
class Solution {
    char[] oper= {'+','-','*'};
	 int [][] n= {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
	 long answer;
	public long solution(String expression) {
        answer = 0;
        for(int i=0;i<expression.length();i++) {
        	if (expression.charAt(i)=='-'||expression.charAt(i)=='+'||expression.charAt(i)=='*') {
        		expression=expression.substring(0, i)+","+expression.charAt(i)+","+expression.substring(i+1);
        		i+=2;
        	}
        }
		String[] array=expression.split(",");
		List<Long> num=new LinkedList<Long>();
		List<Character> ar=new LinkedList<Character>();
		for(String arr:array) {
			if (arr.equals("+")||arr.equals("-")||arr.equals("*"))
				ar.add(arr.charAt(0));
			else 
				num.add(Long.parseLong(arr));
		}
		answer=Math.max(Math.abs(math(num,ar,n[0])),Math.abs(math(num,ar,n[1])));
		for(int i=2;i<6;i++) {
			answer=Math.max(answer,Math.abs(math(num,ar,n[i])));
		}
        return answer;
    }
	public long math(List<Long> num,List<Character> ar,int [] index) {
		List<Long> num1=new LinkedList<Long>(num);
		List<Character> ar1=new LinkedList<Character>(ar);
		for(int i:index) {
			char op=oper[i];
			while(ar1.contains(op)) {
				int in=ar1.indexOf(op);
				num1.set(in,calc(num1.get(in),num1.get(in+1),op));
				num1.remove(in+1);
				ar1.remove(in);
			}
		}
		return num1.get(0);
	}
	public long calc(Long num1, Long num2, char op) {
    	switch (op) {
			case '+': {
				return num1 + num2;
			}
			case '-': {
				return num1 - num2;
			}
			case '*': {
				return num1 * num2;
			}
    	}
    	return (long)0;
    }
}
```

처음에 이 부분을

```java

        for(int i=0;i<expression.length();i++) {
        	if (expression.charAt(i)=='-'||expression.charAt(i)=='+'||expression.charAt(i)=='*') {
        		expression=expression.substring(0, i)+","+expression.charAt(i)+","+expression.substring(i+1);
        		i+=2;
        	}
        }
```

```java
String b=expression;
        for(int i=0;i<b.length();i++) {
        	if (expression.charAt(i)=='-'||expression.charAt(i)=='+'||expression.charAt(i)=='*') {
        		expression=expression.substring(0, i)+","+expression.charAt(i)+","+expression.substring(i+1);
        		i++;
        	}
        }
```

이렇게 했더니 끝에 연산자까지 닿지 않았음;; 완전 바보였던거임 ㅠㅠ ,,→2개니까 2를 추가해야하는데 다음꺼까지 가려면 총3 for문에서 1을 더해주니까 i+=2를 해주면 되는거였삼

## **1. ArrayList.indexOf()**

`indexOf(Object o)`는 인자로 객체를 받습니다.

리스트의 앞쪽부터 인자와 동일한 객체가 있는지 찾으며, 존재한다면 그 인덱스를 리턴합니다. 

존재하지 않는다면 -1을 리턴합니다.

## 2. List 값 변경

위에서 넣은 값을 변경하고 싶은 경우에는

google.set(0, 8);

첫 번째 파라미터는 List안에 값 위치를 뜻하고 두 번째 파라미터는 변경할 즉 새로 넣을 값을 넣는다.