package org.asml;

import java.util.Arrays;

public class Assignment
{
    public static void main(String[] args) {

        /** Sample run with the provided array of size 4 x 4:
         * ------------
         *  1  2  3  4
         *  5  6  7  8
         *  9 10 11 12
         * 13 14 15 16
         * -------------
         * Expected output: [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        */
        int[] sample1 = traverseArray(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        /** Sample run with the provided array of size 5 x 3:
         * ------------
         *  1  2  3  4  5
         *  6  7  8  9 10
         * 11 12 13 14 15
         * -------------
         * Expected output: [1,2,3,4,5,10,15,14,13,12,11,6,7,8,9]
         */
        int[] sample2 = traverseArray(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        });

        System.out.println(Arrays.toString(sample1));
        System.out.println(Arrays.toString(sample2));

    }
    public static int[] traverseArray(int[][] array){

        /**-----------------------------------------------------------------------------
          Initialize the minimum and maximum values to serve as bounds for the traversal
          These boundary values determine the conditions for change in movement of the
          viewport represented by the position array[row][col]
          ----------------------------------------------------------------------------- */
        int rowMax = array.length - 1; // The max boundary for row
        int colMax = array[0].length - 1; // The max boundary for column
        int rowMin = 0; // The min boundary for row
        int colMin = 0; // The min boundary for column


        // A traversal array of length equal to number of elements in array
        int[] traversalOrder = new int[(rowMax+1) * (colMax+1)];
        // Initialize an index for the traversal array
        int idx = 0;

        // Setting the initial condition - The start point is (0,0)
        int row = 0;
        int col = 0;

        // The first element is set in the traversal array as the starting point
        traversalOrder[idx++] = array[row][col];

        do{
            /**
             * This section represents the movement of the viewport denoted by (row,col) towards the right of the viewer
             * The viewport moves rightwards till it encounters a boundary
             * Additionally, the index is checked against the length of the traversal array as a termination condition
             * If idx == traversalOrder length, then all data has been visited
             * */
            while(col < colMax && idx < traversalOrder.length){
                traversalOrder[idx++] = array[row][++col];
            }
            // Reduce the max boundary value for column
            // Since we have encountered the right boundary wall, we move the boundary towards the center of the matrix
            colMax--;

            /**
             * This section represents the movement of the viewport denoted by (row,col) downwards
             * The viewport moves downwards till it encounters a boundary
             * Additionally, the index is checked against the length of the traversal array as a termination condition
             * If idx == traversalOrder length, then all data has been visited
             * */
            while(row < rowMax && idx < traversalOrder.length){
                traversalOrder[idx++] = array[++row][col];
            }

            // Move the min boundary of the row closer to the center.
            rowMin++;

            /**
             * This section represents the movement of the viewport denoted by (row,col) towards the left of the viewer
             * The viewport moves leftwards till it encounters a boundary
             * Additionally, the index is checked against the length of the traversal array as a termination condition
             * If idx == traversalOrder length, then all data has been visited
             * */
            while(col > colMin && idx < traversalOrder.length){
                traversalOrder[idx++] = array[row][--col];
            }

            // Move the min boundary of the column closer to the center
            colMin++;

            /**
             * This section represents the movement of the viewport denoted by (row,col) upwards
             * The viewport moves upwards till it encounters a boundary
             * Additionally, the index is checked against the length of the traversal array as a termination condition
             * If idx == traversalOrder length, then all data has been visited
             * */
            while(row > rowMin && idx < traversalOrder.length){
                traversalOrder[idx++] = array[--row][col];
            }

            // Move the max boundary closer to the center of the matrix
            rowMax--;

        }while(idx < traversalOrder.length); // Terminating condition is when all elements are visited

        // Returns the array containing the travered elements in order.
        return traversalOrder;
    }
}
