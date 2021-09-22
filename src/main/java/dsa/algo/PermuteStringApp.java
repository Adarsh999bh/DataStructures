package dsa.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class PermuteStringApp {

    static List<String> permutations=new ArrayList<>();

    public static String swapCharacter(String str,int index1,int index2){
        char[] charArr=str.toCharArray();
        char temp=charArr[index1];
        charArr[index1]=charArr[index2];
        charArr[index2]=temp;
        return String.valueOf(charArr);
    }

    public static void generatePermutations(String str,int start,int end){
        if(start==end-1){
            permutations.add(str);
        }
        else{
            for(int i=start;i<end;i++){
                str=swapCharacter(str, start, i);
                generatePermutations(str, start+1, end);
                str=swapCharacter(str, start,i);
            }
        }
    }

    public static void printPermutations(){
        int i=1;
        for(String str:permutations){
            System.out.println(i+" "+str);
            i++;
        }
    }

    /**
     * Says welcome.
     * calls functions that generates permutation
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string");
        String str=sc.nextLine();
        generatePermutations(str, 0, str.length());
        printPermutations();
        sc.close();
    }
}
