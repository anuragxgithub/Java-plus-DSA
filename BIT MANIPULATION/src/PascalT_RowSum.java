/*
FEW PROPERTIES OF PASCAL Triangle:
1)Each number is the sum of the two numbers above it.
2)The outside numbers are all 1.
3)The sums of the rows give the powers of 2.
*/
//  1   --> 2^0
//  1 1  ---> 2^1
//  1 2 1  ----> 2^2
//  1 3 3 1
//  1 4 6 4 1
//  15 10 10 5 1  ----> 2^(n-1)
//Que.) Find the sum of given row in pascal triangle.
public class PascalT_RowSum {
    public static void main(String[] args) {
        int rowNo = 6;
        //As we know the power of 2 number representation in binary no eg 1000
        int sum = 1 << (rowNo-1);
        System.out.println(sum);
    }
}
