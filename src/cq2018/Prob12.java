package cq2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Prob12 {
    //String to file path
    public static final String filePath = "inputs/2018/Prob12.in.txt";

    public static void main(String[] args){
        try{
            //Create BufferedReader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            //Grab test cases
            int T = Integer.parseInt(br.readLine());
            //Loop through test cases
            while(T-- > 0){
                /*
                 *  2 <= N <= 45000
                 */
                //Grab N(limit for sieve)
                int N = Integer.parseInt(br.readLine());
                /**
                 * Using a linked list will allow for values to be added and removed
                 * easily and quickly. Since each item is linked to each other, the
                 * data set will not have to be resorted and resized if a value is
                 * removed or added.
                 */
                //Create linked list which will contain Integers from 2 to N. This will be called the working set.
                LinkedList<Integer> set = new LinkedList<>();
                //Loop from 2 to N
                for(int i = 2; i <= N; i++){
                    //Add according value into linked list
                    set.add(i);
                }
                //Create list with primes. This will be filled as prime numbers are removed from our sets
                ArrayList<Integer> primes = new ArrayList<>();
                //Set working number variable. This will be used to iterate through our set to filter out primes.
                int workingPrime = 2;
                //Initialize a boolean variable to track if algorithm is finished
                boolean finished = false;
                //Loop until finished
                while(!finished){
                    //Initialize counter variable for counting how many members in our set can be divided by the working prime
                    int compositeSetCnt = 0;
                    //Loop through working set(don't check first value since that is the divisor)
                    for(int i = 1; i < set.size(); i++){
                        //If current number in set can be divided by working prime(mod operator)
                        if(set.get(i) % workingPrime == 0) {
                            //Increase the count for composite set
                            compositeSetCnt++;
                            //Remove non-prime from set
                            set.remove(i);
                            //Decrement i since set just lost a value, so its index decreased
                            i--;
                        }
                    }
                    //Only print composite set if it is greater than 0
                    if(compositeSetCnt != 0){
                        //Print out the prime and its composite set
                        System.out.printf("Prime %d Composite Set: %d\n", workingPrime, compositeSetCnt);
                        //Add the working prime to the prime set
                        primes.add(workingPrime);
                        //Remove the working prime from the working set(which will always be the first number)
                        set.removeFirst();
                        //Since first was removed, set working prime to next value
                        workingPrime = set.getFirst();
                    }else{
                        /* At this point, the rest of the numbers are primes */
                        //Take the rest of the values and put them in the primes list
                        for(int i = 0; i < set.size(); i++){
                            //Add the value from the set to the prime list
                            //Since this is the last iteration, the working set doesn't need to be changed anymore
                            primes.add(set.get(i));
                        }
                        //Set finished flag to true to exit while loop
                        finished = true;
                    }
                }
                //Initialize output string
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                //Add each prime(and a comma to each) to the output string)
                for(int s : primes){
                    sb.append(s + ",");
                }
                //Remove last comma
                sb.deleteCharAt(sb.length() - 1);
                //Finish off with curly bracket
                sb.append("}");
                //Print out prime set
                System.out.println(sb.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.exit(0);
        }
    }
}
