package p1;

import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        
    	int answer = 0;
    	int[] arr_height = new int[board.length];
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	   				
        //1. 범위 체크 (board)
        if( board[0].length != board.length	) 				return -1;
        if( board.length < 5 	|| board.length > 30 	)	return -1;
        if( board[0].length < 5 || board[0].length > 30	) 	return -1;
        
        //1. 범위 체크 (moves)
        if( moves.length<1 		|| moves.length>1000	) 	return -1;
        
        if(moves.length == 1) return 0;
        
        for(int i=0;i<board.length;i++)
        	for(int j=0; j<board[0].length; j++) {
        		arr_height[j] = board.length;
        	}
        //2. 높이 관리하는 배열 선언 및 정의.
        for(int i=0; i<board.length ; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(arr_height[j] == board.length && board[i][j] != 0) {
        			arr_height[j] = i;
        		}
        	}
        }

        //2. 유효성 체크(board)
        
        //2. 유효성 체크(moves)
        
        
//    	[0,0,0,0,0]
//    	[0,0,1,0,3]
//    	[0,2,5,0,1]
//    	[4,2,4,4,2]
//    	[3,5,1,3,1]
//      -----------
//       1,2,3,4,5
        
//		arr_height[] = [3,2,1,3,1]; 
        
        // [1,5,3,5,1,2,1,4]
        //3. 
        for(int i=0; i<moves.length; i++) {
        	
        	//3.1. 변수 선언.
        	int col = moves[i]-1;
        	int row = arr_height[col]; 

        	if(row >= board.length) continue; 	// 3.1. col의 모든 값을 소진한 경우.
        	arr_height[col]++; 						// 3.2. 높이를 관리하는 배열을 ++ 한다.
        	
        	int cur_value = board[row][col]; 	// 3.3. moves[i] 값에 해당하는 가장 높이가 높은 친구의 값을 꺼내온다.
        	
        	//3.3. 스택이 비어있는 경우
        	if(stack.isEmpty()) { 
        		stack.push(cur_value);
        	}
        	//3.2. stack 에 값이 하나라도 있는 경우.
        	else {
        		if(stack.peek() == cur_value ) {
        			stack.pop();
        			answer +=2;
        		} else {
        			stack.push(cur_value);
        		}
        	}
        		
        }
       
        return answer;
    }

}
