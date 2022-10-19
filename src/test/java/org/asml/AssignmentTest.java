package org.asml;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for the Assignment.
 */
public class AssignmentTest
{
    @Test
    public void squareEvenSized2DArray_returnsExpectedOrder()
    {
        /** Test run with the provided array of size 4 x 4:
         * ------------
         *  1  2  3  4
         *  5  6  7  8
         *  9 10 11 12
         * 13 14 15 16
         * -------------
         * Expected output: [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
         */
        int[] expected = new int[] {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10};
        int[] result = Assignment.traverseArray(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void squareOddSized2DArray_returnsExpectedOrder()
    {
        /** Test run with the provided array of size 5 x 5:
         * ------------
         *  1  2  3  4  5
         *  6  7  8  9 10
         * 11 12 13 14 15
         * 16 17 18 19 20
         * 21 22 23 24 25
         * -------------
         * Expected output: [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13]
         */
        int[] expected = new int[] {1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13};
        int[] result = Assignment.traverseArray(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        });
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void oddRowByEvenCol2DArray_returnsExpectedOrder()
    {
        /** test run with the provided array of size 3 x 4:
         * ------------
         *  1  2  3  4
         *  5  6  7  8
         *  9 10 11 12
         * -------------
         * Expected output: [1,2,3,4,5,10,15,14,13,12,11,6,7,8,9]
         */
        int[] expected = new int[] {1,2,3,4,8,12,11,10,9,5,6,7};
        int[] result = Assignment.traverseArray(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void oddRowByOddCol2DArray_returnsExpectedOrder()
    {
        /** Test run with the provided array of size 3 x 5:
         * ------------
         *  1  2  3  4  5
         *  6  7  8  9 10
         * 11 12 13 14 15
         * -------------
         * Expected output: [1,2,3,4,5,10,15,14,13,12,11,6,7,8,9]
         */
        int[] expected = new int[] {1,2,3,4,5,10,15,14,13,12,11,6,7,8,9};
        int[] result = Assignment.traverseArray(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        });
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void singleElement2DArray_returnsSingleElement()
    {
        /** Test run with the provided array of size 1 x 1:
         * ------------
         *  1
         * -------------
         * Expected output: [1]
         */
        int[] expected = new int[] {1};
        int[] result = Assignment.traverseArray(new int[][]{
                {1}
        });
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void empty2DArray_returnsArrayWithZeros()
    {
        /** Test run with the provided array of size 1 x 1:
         * ------------
         *  1
         * -------------
         * Expected output: [1]
         */
        int[] result = Assignment.traverseArray(new int[3][3]);

        assertTrue(Arrays.equals(result, new int[9]));
    }
}
