package com.datastructures.arrays;

public class PrintInSipralOrder {

	/*		Left		Right
	 * 		Top	1 2 3 4 
	 * 			5 6 7 8
	 *   bottom 9 1 2 3
	 *          
	 */
	private void printSipira(int[][] array, int m, int n){
		int top = 0;
		int bottom = m-1;
		int right = n-1;
		int left = 0;
		int direction =0;
		
		while( top <= bottom && left <= right){
			if(direction == 0){
				// top to right
				for (int i = top; i <= right; i++) {
					System.out.println(array[top][i]);
				}
				top++;
			}else if(direction ==1){
				//top to bottom
				for (int i = top; i <= bottom; i++) {
					System.out.println(array[i][right]);
				}
				right--;
				
			}else if(direction ==2){
				//right to left
				for (int i = right; i >= left; i--){
					System.out.println(array[bottom][i]);
				}
				bottom--;
			}else if(direction ==3){
				//bottom to top
				for (int i = bottom; i >= top; i--) {
					System.out.println(array[i][left]);
				}
				left++;
			}
			direction = (direction+1)%4;
		}
	}
	
	public static void main(String[] args) {
		int[][] twoD ={{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		PrintInSipralOrder order = new PrintInSipralOrder();
		order.printSipira(twoD, 4, 4);
	}
	
	private void printArray(int[][] twoD){
		for (int[] is : twoD) {
			for (int i : is) {
				System.out.print(i);
			}
			System.out.println("\n");
		}

	}
}
