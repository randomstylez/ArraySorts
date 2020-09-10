/**************************************************************
 Purpose/Description: < creates and sorts a radix array >
 Author’s Panther ID: <5901749>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/

package problem.pkg1;
import java.util.Arrays;

/**
 *
 * @author Joey
 */


public class Problem2 {
    
    //Obtains the max value of an array
    static int getMaximum(int intArray[]) 
    { 
        int max = intArray[0]; 
        for (int i = 1; i < intArray.length; i++) 
            if (intArray[i] > max) 
                max = intArray[i]; 
        return max; 
    }    
    
    //out puts an array length and inputs items into an array
    static void countSort(int intArray[], int exp) 
    { 
        int output[] = new int[intArray.length];
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
        for (i = 0; i < intArray.length; i++) 
            count[ (intArray[i]/exp)%10 ]++; 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
        for (i = intArray.length - 1; i >= 0; i--) 
        { 
            output[count[ (intArray[i]/exp)%10 ] - 1] = intArray[i]; 
            count[ (intArray[i]/exp)%10 ]--; 
        } 
        for (i = 0; i < intArray.length; i++) 
            intArray[i] = output[i]; 
    } 

    // sorts the array
    static void radixsort(int intArray[]){
        
        for(int i=0;i<intArray.length;i++){
            if(!(intArray[i]%2==0)){
                System.out.println("*** Abort *** the input has at least one key with odd digits");
            }
            else{
                int m = getMaximum(intArray);
                for (int exp = 1; m/exp > 0; exp *= 10) 
                    countSort(intArray,exp);
            }
        }    
    } 
  
    // outputs the sorted array
    static void outputArray(int intArray[]){
        System.out.print("Output:");
        for (int i=0; i<intArray.length; i++) 
            System.out.print(intArray[i]+" "); 
    } 
    public static void main(String[] args) {
        
        int[] intArray = {24, 2, 4, 466, 48, 66, 8, 44};
        radixsort(intArray); 
        outputArray(intArray); 
    
    }
}


///  Part B: What is the running time complexity of your radixSort method? 
///  Answer: nLogn.


