/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1
https://www.spoj.com/submit/CHOCOLA/     (Got accepted here also)

FROM THE PROBLEM STATEMENT WE CAN INFER FOLLOWING POINTS:
1. It is going to take (n-1) + (m-1) cuts to cut the whole chocolate into single square.
   So our main concern is to find the right seq./order to cut the chocolate for min. costs.
2. After each cut, pieces of chocolate will increase.
   So it is wise to choose to cut the chocolate by using the highest cutting cost first bcz if we use lower cost to
   cut the choco first then for the new extra pieces we have to use max cost multiple times. Eg:
       
    ____|____
   |    |    |
___|____|____|___ 3
   |    |    |
   |____|____|
        | 
        2
    Lets say we have this chocolate (all pieces are joint) horizontal cut price is given (3) and vertical also (2).
    Lets assume two scenarios:
    1. Cutting the choco first with the vertical cut (less cost), it takes cost 2 and then 
       we will be having 2 vertical pieces so cost of cutting them into single square piece will be 3 + 3
       So total amount taken in this case would be 2+3+3 = 8.
    2. Cutting the choco first with the horizontal cut (highest cost), it takes cost 3 and then we will be having 
       2 horizontal pieces of so, cost of cutting them into single square piece will be 2+2.
       So total amount taken in this case would be 3+2+2 = 7.
       WHICH IS LESS THAN IF WE CHOOSE TO CUT CHOCO WITH MIN CUT COST.
 
3. Lets say we have 4 horizontal pieces of chocolate and we want to cut them vertically and cost of vertical cut is
   x. So, total cost of cutting those pieces would be 4 * x.
   Similarly for the horizontal cut : 4*y
*/

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblemIMP {
    public static void main(String[] args) {
        // Greed criteria : At each step use the max cost to cut the chocolate.
        // int n = 4;  // rows 
        // int m = 6;  // cols
        Integer[] verCost = {2,1,3,1,4};    // vertical cut cost    (m-1)
        Integer[] horCost = {4,1,2};       // horizontal cut cost   (n-1)

        // we need to sort them cutting cost in desc order 
        Arrays.sort(verCost, Collections.reverseOrder());
        Arrays.sort(horCost, Collections.reverseOrder());

        int hptr = 0, vptr = 0;   // for comparing from horCost & verCost to find max cost
        // horizontal , vertical pieces 
        int hp = 1, vp = 1;
        int cost = 0;

        while(hptr < horCost.length && vptr < verCost.length) {
            if(verCost[vptr] < horCost[hptr]) {  // then do the horizontal cut
                cost += (horCost[hptr] * vp);
                hptr++;
                hp++;  // every time h cut lagega then h peieces will increase
            } else {  // vertical cut
                cost += (verCost[vptr] * hp);
                vptr++;
                vp++;
            }
        }

        // check for the remaining cuts
        while(hptr < horCost.length) {
            cost += (horCost[hptr] * vp);
            hptr++;
            hp++;  
        }

        while(vptr < verCost.length) {
            cost += (verCost[vptr] * hp);
            vptr++;
            vp++;
        }

        System.out.println("Total min cost of cuts is : " + cost);
    }
}
// This is a hard level question
// Understand the logic of the code it may come in various forms like instead of chocolate we can be given a chess
// board same code will apply there also.