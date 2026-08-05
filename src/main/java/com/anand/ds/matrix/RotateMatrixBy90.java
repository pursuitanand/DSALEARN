package com.anand.ds.matrix;

/*
Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.

        Examples:

Input: mat[][] = [[0, 1, 2],
        [3, 4, 5],
        [6, 7, 8]]
Output: [[2, 5, 8],
        [1, 4, 7],
        [0, 3, 6]]
Input: mat[][] = [[1, 2],
        [3, 4]]
Output: [[2, 4],
        [1, 3]]


Rotate matrix 90° clockwise in-place :
Rotate     = Transpose     + Reverse Rows

Rotate matrix 90° counter-clockwise in-place :
Rotate     = Transpose     + Reverse Columns

Complexity
Time: O(n*n)
Space: O(1) (in-place)
 */

public class RotateMatrixBy90 {

    public void rotateMatrixClockWise(int[][] mat) {
        // code here
        int length = mat.length;
        transpose(mat,length);
        reverseRow(mat, length);
    }

    public void rotateMatrixCounterClockWise(int[][] mat) {
        // code here
        int length = mat.length;
        transpose(mat,length);
        reverseColumn(mat, length);
    }

    public static void main(String[] args) {
        RotateMatrixBy90 rotateMatrix = new RotateMatrixBy90();
        int[][] mat = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        System.out.println("Original matrix: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        rotateMatrix.rotateMatrixClockWise(mat);
        System.out.println("Rotated matrix 90 degree clock wise: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        rotateMatrix.rotateMatrixCounterClockWise(mat);
        System.out.println("Rotated matrix 90 degree clock wise: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] transpose(int[][] mat, int matLen){
        for(int i=0; i<matLen; i++){
            for(int j=i+1; j<matLen; j++){
                int temp = mat[i][j];
                mat[i][j]  = mat[j][i];
                mat[j][i] = temp;
            }
        }

        return mat;
    }

    private int[][] reverseRow(int[][] mat, int matLen){

        for(int row=0; row<matLen; ++row){
            int left = 0;
            int right = matLen -1;

            while(left < right){
                int temp = mat[row][left];
                mat[row][left] = mat[row][right];
                mat[row][right] = temp;

                left++;
                right--;
            }
        }

        return mat;
    }

    private int[][] reverseColumn(int[][] mat, int matLen){
        for(int col=0;col < matLen; col++){
            int top=0;
            int bottom = matLen-1;

            while(top<bottom){
                int temp = mat[top][col];
                mat[top][col] = mat[bottom][col];
                mat[bottom][col] = temp;

                top++;
                bottom--;
            }
        }

        return mat;
    }
}
