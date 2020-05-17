package p1;

public class solution {
    public String solution(int[] numbers, String hand) {
        
        String answer = "";
        //1. 배열의 크기 검사
        if( numbers.length < 1 || numbers.length > 1000) return "ERROR";

        //2. 배열의 원소값 검사
        for(int i=0;i<numbers.length;i++)
       		if(numbers[i] < 0 || numbers[i] > 9) return "ERROR";
        
        //3. hand 값 검사
        if	(hand.equals("left"))        	hand = "L";
	else if (hand.equals("right"))         	hand = "R";
	else 			        	return "ERROR";

        //키보드 배열 선언.
        char[][] board = {	{'1','2','3'}, 
				{'4','5','6'}, 
				{'7','8','9'}, 
				{'*','0','#'} 	}; 
        
        char left_pos 	= '*'; // *
        char right_pos 	= '#'; // #
        
        //5. 시작
        for(int i=0; i<numbers.length; i++) {

        	//5.1. 1,4,7인 경우 = L
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        		left_pos = Character.forDigit(numbers[i], 10);
        		answer += "L";
        	}
        	
        	//5.2. 3,6,9인 경우 = R
        	else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        		right_pos = Character.forDigit(numbers[i], 10);
        		answer += "R";
        	}
        	
        	//5.3. 가운데 숫자인 경우 (2,5,8,0)
        	else {
        		
        		int left_row 	= 4;
        		int left_col 	= 3;
        		
        		int right_row 	= 4;
        		int right_col 	= 3;
        		
        		int cur_row		= 4;
        		int cur_col		= 3;
        		
        		//left_pos, right_pos, numbers[i] 의 row,col 계산.
        		for(int l=0; l<board.length; l++) 
        			for(int m=0; m<board[0].length; m++) {

        				//5.3.1. left_pos 현재 위치 계산
        				if(board[l][m] == left_pos) {
        					left_row = l;
        					left_col = m;
        				}
        				
        				//5.3.2. right_pos 현재 위치 계산
        				if(board[l][m] == right_pos) {
        					right_row = l;
        					right_col = m;
        				}
        				
        				//5.3.3. numbers[i] 현재 위치 계산.
        				if( board[l][m] == Character.forDigit(numbers[i], 10) ) {
        					cur_row = l;
        					cur_col = m;
        				}
        			}
        		
        		int left_dist = Math.abs((cur_row-left_row)) + Math.abs((cur_col-left_col));
        	
        		int right_dist = Math.abs((cur_row-right_row)) + Math.abs((cur_col-right_col));
        		
        		if(left_dist > right_dist) {
        			
            		right_pos = Character.forDigit(numbers[i], 10);
            		answer += "R";
            		
        		}else if(left_dist < right_dist) {
        			
            		left_pos = Character.forDigit(numbers[i], 10);
            		answer += "L";
            		
        		}else { // 같은 경우.
        			
        			answer += hand;
        			
				if	(hand == "L") 	left_pos = Character.forDigit(numbers[i], 10);
        			else if	(hand == "R") 	right_pos = Character.forDigit(numbers[i], 10);
        			else 	        	return "ERROR";
        			
        		}
        		
        	}
        	
        }
        
        return answer;
    }
}
