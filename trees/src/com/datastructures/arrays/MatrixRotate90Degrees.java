package com.datastructures.arrays;

public class MatrixRotate90Degrees {
	static 	int [][]matrix = new int[4][4];
	static{
		for(int i =0; i<4; i++){
			for(int j=0; j<4; j++){
				matrix[i][j] = j;
			}
		}
	}
	
	static void rotate(int [][]matrix, int n){
		
		for(int layer = 0; layer < n/2; ++layer){
			int first = layer;
			int last = n-1-layer;
			for(int i = first; i < last; ++i){
				int offset = i - first;
				
				int top = matrix[first][i];
				
				matrix[first][i] = matrix[last - offset][first];
				
				matrix[last -offset][first] = matrix[last][last - offset];
				
				matrix[last][last - offset] = matrix[i][last];
				
				matrix[i][last] = top;
				displayMatrix();
				System.out.println("**************");
			}
		}
	}

	static void displayMatrix(){
		for(int i =0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		displayMatrix();
		System.out.println("**************");
		rotate(matrix, 4);
		displayMatrix();
	}
	
}


