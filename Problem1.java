/**************************************************************
 Purpose/Description: < creates an array, sorts and prints the array length and the array>
 Author’s Panther ID: <5901749>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/

package problem.pkg1;
import java.util.Scanner;
/**
 *
 * @author Joey
 */

//Makes an arry of ints to be sorted
class Sort {
    
    private int[] intArray;
    private int size;
    Scanner in;
    
    // sets up the scanner for the array 
    public Sort(){
        size=0;
        in = new Scanner(System.in);
    }
    
    // sets up the size of the array
    private void inputSize(){
        System.out.println("Enter Array Size:");
        this.size= in.nextInt();
    }
    
    // asks the user to enter array values
    private void inputArray(){
        this.inputSize();
        intArray=new int[size];
        System.out.println("Input Array Values:");
        for(int i=0;i<size;i++){
            intArray[i]=in.nextInt();
        }
    }

    // parses the array and outputs the aaray 
    public void moveAllNegativeOne(){
        this.inputArray();
        int temp,dupSize=size;
        
        for(int i=0; i< dupSize; i++){
            if(intArray[i]<0){
                temp=intArray[i];
                for(int j=i;j<size-1;j++){
                    intArray[j]=intArray[j+1];
                }
                intArray[size-1]=temp;
                dupSize--;
            }
        }
        this.outputArray();
    }
    
    // prints the size of the array
    private void outputArray(){
        System.out.print("Output:");
        for(int i=0;i<size;i++)   
            System.out.print(intArray[i] + " ");
    }
}


public class Problem1{

    public static void main(String[] args) {
      Sort obj=new Sort();
      obj.moveAllNegativeOne();
    }
    
}
