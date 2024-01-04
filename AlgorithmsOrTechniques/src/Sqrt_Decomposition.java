/*
The Square Root Decomposition (or Square Root Trick) is a technique used in algorithmic
problem-solving, especially in the context of competitive programming and data structures.
It is employed to optimize certain computations by dividing the input into blocks and precomputing
solutions for each block.

Here's a general idea of how the Square Root Decomposition algorithm works:

Divide the Input:
Split the input data (e.g., an array) into blocks of a certain size. The size of each block is
usually chosen to be the square root of the total number of elements.

Precompute Block Solutions:
For each block, compute and store the solution to the problem for that specific block. This step
is performed once at the beginning.

Query and Update:
When you need to perform a query or update operation, instead of processing the entire data
structure, you only consider the relevant blocks. This is possible because you have precomputed
solutions for each block.

Handle Border Cases:
For operations that span multiple blocks, handle the boundary cases separately. The boundary cases involve the elements that are not entirely within a single block.
The primary goal of using the Square Root Decomposition is to reduce the time complexity of certain operations by processing only a subset of the data rather than the entire dataset. This can be particularly useful in scenarios where a brute-force approach would be too slow.

One common application of this technique is in range query problems, where you need to perform some
operation (e.g., sum, minimum, maximum) over a subarray of the input. By dividing the array into
blocks, you can precompute solutions for each block and efficiently answer queries by considering
only relevant blocks.

Keep in mind that the specifics of "IMPLEMENTING THE SQUARE ROOT DECOMPOSITION CAN VARY DEPENDING
ON THE PROBLEM AT HAND".
 */
/*
Steps for the below implementation:
1. Divide the array into the blocks of size sqrt(n)
2. Compute ans for each block (each block would contain elements equal to sqrt)
3. Given a query for left to right combine the blocks(partially or fully) that contains this.
*/  

import java.util.Arrays;

public class Sqrt_Decomposition {   // aka MO's Algorithm
    public static void main(String[] args) {
        int[] arr = {5,7,6, 4,3,2, 8,7,12, 14};

        //build block array
        int sqrt = (int) Math.sqrt(arr.length); // in one block ans of sqrt(n) elements will be stored
        int[] blockArray = new int[sqrt+1];
        int n = arr.length;
        int blockId = -1;
        // we can observe that next idx of blockArray is starting at the idx multiple of sqrt(n) in input array
        for(int i = 0; i < n; i++) {
            if(i % sqrt == 0) {     // next idx for block array starts here
                blockId++;
            }

            blockArray[blockId] += arr[i];  // till then keep adding elements
        }
        // Alternate way to fill the block array could be (mine one)
        // for(int i = 0; i < n; i++) {
        //     blockArray[i / sqrt] += arr[i];
        // }

        System.out.println(sumQuery(blockArray, arr, 2, 7, sqrt));

        update(blockArray, arr, 5, 3, sqrt);  // updating a value from input array
        System.out.println("Update array : " + Arrays.toString(arr));
        System.out.println(sumQuery(blockArray, arr, 0, 9, sqrt));
    }

    public static int sumQuery(int[] blockArray, int[] arr, int left, int right ,int sqrt) {
        int sum = 0;
        // left part  (border case  see intro comments)
        while(left % sqrt != 0 && left < right) {
            sum += arr[left];
            left++;
        }

        // middle part (where w'll find use of our blocks)
        while(left + sqrt <= right) {
            sum += blockArray[left / sqrt];  // bcz for that block we already have stored ans
            left += sqrt;
        }

        // right part   (border case)
        while(left <= right) {
            sum += arr[left];
            left++; 
        }

        return sum;
    }

    public static void update(int[] blockArray, int[] arr, int idx, int value, int sqrt) {
        // checkout at which idx of block array the target idx falls in and update accordingly
        if(idx < arr.length) {
            int block_id = idx / sqrt;
            blockArray[block_id] += (value - arr[idx]);  // rhs basically represents sum + (newVal - oldVal)
            arr[idx] = value; 
        } else {
            System.out.println("Index out of bound.");
        }
    }
}

// Now see if you want sum of each elements in array it will take O(sqrt(n)) time than O(n).
