/*

https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1?
Whatever the deadline is but every job is going to be finished in 1 unit of time.

Simple Logic:
1. First sort the array on the basis of profit (in decreasing order).
2. We will take the maxprofit jobs first and complete it. But wait.. should I do the max profit
   job on the first unit of time whether it has deadline of more than this???
   The answer is NO!!   Lets see why: 
   Suppose you have job sequence  like this :  (deadline, profit)
2 80
6 70
6 65
5 60
4 25
2 22
4 20
2 10

CASE 1: DOING THE MAX PROFIT JOB ON THE FIRST UNIT OF TIME
On time =1 1st job done, t =2 second job done, t =3 third job done, t = 4 fourth job is done,
now at t = 5 we are not left with tasks which has deadline of 5 or more. In this way I am only able
to complete 4 tasks which is not ideal we could have done more taks if we followed other appraoch.
This is the problem in doing the max work at first unit of time without leveraging its deadline.
In this case profit is : 80+70+65+60 = 275.

CASE 2: DOING THE MAX PROFIT JOB ON THE DEADLINE DAY/UNIT OF TIME
Consider the same eg:
At time = 1 we fix the time slot of max profit job on second unit of time , at t = 2 we
fix slot for second job on 6th unit of time, t = 3 now "AT 6TH UNIT OF TIME WE ALREADY HAD
A TASK ASSIGNED SO WE WILL FIND THE NEXT AVAILABLE TIME SLOT BEFORE" 6 so we have 5th
slot free assign the 3rd task to 5th slot, at t = 4 assign 4th task to 4th unit of
time's slot, at t = 5 assign 5th job to 3rd slot and at t = 6 assign the 6th job to the 1st slot.
These slot thing is generated using an array which is of size (max deadline here 6).
Now after t = 6 we have no free slot to assign work here it is done.
In this case profit is : 80+70+65+60+25+22 = 322
That's how we generate max profit.

The logic is simple : Do the work at the last date so that we can preserve the previous time 
in doing other work. Simple.

We can use disjoint set to remove the from the last day to first day, but in Interviews, this solution is what
the interviewer usually look for. However you can solve COLORFUL ARRAY from SPOJ to understand how to solve
this in O(N Log N).
*/

import java.util.ArrayList;
import java.util.Collections;


public class JobSequenceIMP {
    static class Job {
        int id, deadline, profit;

        // constructor
        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }

    }
    public static void main(String[] args) {
        int[][] jobsInfo = {{4,20}, {1,10}, {1,40}, {1,30}};

        // Taking the jobs info in array list which is easy to modify
        ArrayList<Job> list = new ArrayList<>();
        for(int i = 0; i < jobsInfo.length; i++) {
            list.add(new Job(i+1, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Now lets sort the jobs on the basis of profit in desc order
        Collections.sort(list, (a,b) -> (b.profit-a.profit));

        // Now create an array of size max time(deadline) because we will do that many jobs.
        int maxDeadline = -1;
        for(int i = 0; i < jobsInfo.length; i++) {
            if(list.get(i).deadline > maxDeadline) {
                maxDeadline = list.get(i).deadline;
            }
        }
        boolean[] timeSlot = new boolean[maxDeadline+1];   // lets take 1 based indexing
        int maxProfit = 0;
        int cnt = 0;

        for(int i = 0; i < list.size(); i++) {
            int currJobDeadline = list.get(i).deadline;
            for(int j = currJobDeadline; j >= 1; j--) {   // starting from the last date of deadline and finding the available slot nearest to the last deadline date
                if(timeSlot[j] == false) {
                    timeSlot[j] =  true;
                    cnt++;
                    maxProfit += list.get(i).profit;
                    break;
                }
            }
        }
        System.out.println("Total jobs done  is : " + cnt + " Max Profit is : " + maxProfit);
    }
}
// If you want the job ids too you can create a seperate array to store the jbo ids.
/*
 * Time : O(nlogn) for sorting and O(n*maxDeadline)  for iterating for all jobs and checking for its slot
 * Space : O(maxDealine)
 */
/*
 See the last chat to understand how naive appraoch works here.
 https://chat.openai.com/share/bd5c8a23-3252-48ae-a4da-639f16816f33
*/