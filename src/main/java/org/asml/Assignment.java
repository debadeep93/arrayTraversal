package org.asml;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment {
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
        int[][] sample2DArray1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[] sample1 = traverseArray(sample2DArray1);


        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1. Sample array: ");
        for (int[] i : sample2DArray1) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\nTraversal Result: ");
        System.out.println(Arrays.toString(sample1));

        /** Sample run with the provided array of size 5 x 3:
         * ------------
         *  1  2  3  4  5
         *  6  7  8  9 10
         * 11 12 13 14 15
         * -------------
         * Expected output: [1,2,3,4,5,10,15,14,13,12,11,6,7,8,9]
         */
        int[][] sample2DArray2 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("2. Sample array: ");
        for (int[] i : sample2DArray2) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\nTraversal Result: ");
        int[] sample2 = traverseArray(sample2DArray2);
        System.out.println(Arrays.toString(sample2));
        System.out.println("-------------------------------------------------------------------------------");

        /** ================================================================================================ */
        /** User input */
        Scanner scanner = new Scanner(System.in);
        int rowSize = scanner.nextInt();
        int colSize = scanner.nextInt();
        int[][] testArray = new int[rowSize][colSize];
        int i = 0, j = 0;

        scanner.useDelimiter("[,\n]");
        while (scanner.hasNext() && i < rowSize - 1) {
            while (j < colSize) {
                testArray[i][j++] = scanner.nextInt();
            }
            i++;
            j = 0;
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Entered array: ");
        for (int[] k : testArray) {
            System.out.println(Arrays.toString(k));
        }
        System.out.println("\nTraversal Result: ");
        int[] result = traverseArray(testArray);
        System.out.println(Arrays.toString(result));
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static int[] traverseArray(int[][] array) {

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
        int[] traversalOrder = new int[(rowMax + 1) * (colMax + 1)];
        // Initialize an index for the traversal array
        int idx = 0;

        // Setting the initial condition - The start point is (0,0)
        int row = 0;
        int col = 0;

        // The first element is set in the traversal array as the starting point
        traversalOrder[idx++] = array[row][col];

        do {
            /**
             * This section represents the movement of the viewport denoted by (row,col) towards the right of the viewer
             * The viewport moves rightwards till it encounters a boundary
             * Additionally, the index is checked against the length of the traversal array as a termination condition
             * If idx == traversalOrder length, then all data has been visited
             * */
            while (col < colMax && idx < traversalOrder.length) {
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
            while (row < rowMax && idx < traversalOrder.length) {
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
            while (col > colMin && idx < traversalOrder.length) {
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
            while (row > rowMin && idx < traversalOrder.length) {
                traversalOrder[idx++] = array[--row][col];
            }

            // Move the max boundary closer to the center of the matrix
            rowMax--;

        } while (idx < traversalOrder.length); // Terminating condition is when all elements are visited

        // Returns the array containing the travered elements in order.
        return traversalOrder;
    }
}
