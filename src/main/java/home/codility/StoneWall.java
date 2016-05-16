package home.codility;

import java.util.Stack;

public class StoneWall {

	public int solution(int[] H) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for(int i = 0; i < H.length; i++){             
              if(stack.size() == 0)
              {
                 count++;
                 stack.push(H[i]);
              }else{
                 if(stack.peek() > H[i]){
                    while(stack.size() > 0 && stack.peek() > H[i]){
                        stack.pop();
                    }
                    i--;
                }else if(stack.peek() < H[i]){
                    count++;
                    stack.push(H[i]);
                }
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 3 , 6 };
		int result = new StoneWall().solution(arr) ;
        System.out.println(result);
	}

}
