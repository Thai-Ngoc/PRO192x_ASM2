package pro192x_asm2;
import java.util.*;
public class PRO192x_ASM2 {

    private static Scanner input = new Scanner(System.in); //instance variables, get user input
    public static final int max = 100; //instance variables
    public static int shiftedBool; //instance variables, ask user's mark is shifted or not
    public static int weightMid; //instance variables, weight of midterm
    public static int weightFinal; //instance variables, weight of finalterm
    public static int weightHW; //instance variables, weight of homework
    
    public static void begin() {
        
        //Print out the introduce of program
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println();
    }
    
    public static int check(int n) {
        
        //Require entering a number in range 0 - 100
        while (n < 0 || n > 100) {
            System.out.print("Please enter an integer in range 0 - 100 ");
            n = inputCheck();
        }
        return n;
    }
    
    public static int inputCheck() {
        
        //Require entering an integer
        int in = 0;
        boolean check = false;
        while (!check) {
            if (input.hasNextInt()) {
                in = input.nextInt();
                check = true;
                return in;
            } else {
                System.out.print("Please enter an integer value: ");
                check = false;
            }
            input.next();
        } 
        return in;
    }
    
    public static double midterm() {
        System.out.println("Midterm:");
        System.out.print("Weight (0 - 100)? ");
        //Check conditions for weight of mid term
        weightMid = inputCheck(); //must be an integer
        weightMid = check(weightMid); //must be in range 0 - 100
        System.out.print("Score earned? ");
        //Check conditions for score of integer
        int score = inputCheck(); //must be an integer
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        //Require entering an integer
        shiftedBool = inputCheck(); //must be an integer
        int shifted; //local variables, store shift amount
        int total; //local variables, store total points
        double midWeight = 0; //local variables, store weighted score
        if (shiftedBool == 2) {
            //if there is no shift amount, total score is score
            total = score;
            midWeight = (double)total / max * weightMid; //calculate the weighted score
            System.out.println("Total points = " + total + " / " + max); //print out the total score
            System.out.println("Weighted score = " + Math.round(midWeight * 100.0) / 100.0 + " / " + weightMid); //print out the weighted score
        } else if (shiftedBool == 1) {
            //if there is a shift amount, the total score is the sum of score and shift amount
            System.out.print("Shift amount? ");
            shifted = inputCheck(); //Require entering an integer
            if (score + shifted <= max) {
                //if the sum of score of shift amount is less than or equal to the max value, the total score is the sum of score and shift amount
                total = score + shifted;
                midWeight = (double)total / max * weightMid; //calculate the weighted score
                System.out.println("Total points = " + total + " / " + max); //print out the total score
                System.out.println("Weighted score = " + Math.round(midWeight * 100.0) / 100.0 + " / " + weightMid); //print out the weighted score
            } else {
                //if the sum of score and shift amount is greater than the max value, total points is the max value
                total = max;
                midWeight = (double)total / max * weightMid; //calculate the weighted score
                System.out.println("Total points = " + total + " / " + max); //print out the total score
                System.out.println("Weighted score = " + Math.round(midWeight * 100.0) / 100.0 + " / " + weightMid); //print out the weighted score
            }
        }
        System.out.println();
        return midWeight; //return the weighted score of mid term
    }
    
    public static int finalCheck (int n) {
        //Input must satisfy these conditions
        while (n < 0 || weightMid + n > max) {
            System.out.print("Weight must be positive, the sum of weights must be equal or less than " + (max - weightMid) + " ");
            n = inputCheck();
        }
        return n;
    }
    
    public static double finalterm() {
        System.out.println("Final:");
        System.out.print("Weight (0 - 100)? ");
        //Check conditions for weight of final term
        weightFinal = inputCheck(); //must be an integer
        weightFinal = finalCheck(weightFinal); //must be positive, less than (max - weightMid)
        System.out.print("Score earned? ");
        //Check conditions for score of final term
        int score = inputCheck(); //must be an integer
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        //Check conditions for yes no answer
        shiftedBool = inputCheck(); //must be an integer
        int shifted; //local variable, store shift amount
        int total; //local variables, store total score
        double finalWeight = 0; //local variables, weighted score of final term
        if (shiftedBool == 2) {
            total = score; //there is no shift amount, the total score equal score
            finalWeight = (double)total / max * weightFinal; //calculate weighted score of final term
            System.out.println("Total points = " + total + " / " + max); //print out the total score
            System.out.println("Weighted score = " + Math.round(finalWeight * 100.0) / 100.0 + " / " + weightFinal); //print out the weighted score
        } else if (shiftedBool == 1) {
            //there is shift amount
            System.out.print("Shift amount? ");
            shifted = inputCheck(); //must be an integer
            if (score + shifted <= max) {
                total = score + shifted; //the total score is the sum of score and shift amount when score + shift amount <= max value
                finalWeight = (double)total / max * weightFinal; //calculate the weighted score
                System.out.println("Total points = " + total + " / " + max); //print out the total score
                System.out.println("Weighted score = " + Math.round(finalWeight * 100.0) / 100.0 + " / " + weightFinal); //print out the weighted score
            } else {
                total = max; //the total point is equal to the max value when score + shift amount > max
                finalWeight = (double)total / max * weightFinal; //calculate the weighted score
                System.out.println("Total points = " + total + " / " + max); //print out the total score
                System.out.println("Weighted score = " + Math.round(finalWeight * 100.0) / 100.0 + " / " + weightFinal); //print out the weighted score
            }
        }
        System.out.println();
        return finalWeight; //return the weight of the final term
    }
    
    public static int hwCheck (int n) {
        //Input must satisfy these conditions
        while (n < 0 || weightMid + weightFinal + n != max) {
            System.out.print("Weight must be " + (max - weightMid - weightFinal) + " ");
            n = inputCheck();
        }
        return n;
    }
    
    public static double homework() {
        System.out.println("Homework:");
        System.out.print("Weight (0 - 100)? ");
        //Check condition for weight of homework
        weightHW = inputCheck(); //must be an integer
        weightHW = hwCheck(weightHW); //must be positive, the sum of 3 weights is 100
        System.out.print("Number of asignments? ");
        int numAsm = inputCheck(); //local variable, store number of assignments, must be an integer
        int score = 0; //local variable, store the sum of assignments' score
        int maximum = 0; //local variable, store the sum of assignments' max score
        for (int i = 1; i <= numAsm; i++) {
            System.out.print("Assignment " + i + " score and max? "); //print out the score and max score of each assignment
            score += inputCheck(); //calculate the sum of all assignments' score
            maximum += inputCheck(); //calculate the sum of all assignments' max score
        }
        
        int finalScore = 0; //local variables, store the final sum of score to calculate total score
        if (score >= 150) {
            finalScore = 150; //final sum is 150 when the sum of score is equal or greater than 150
        } else {
            finalScore = score; //final sum is equal to the sum of score when the sum of score less than 150
        }
        
        int finalMax = 0; //local variables, store the final sum of max score to calculate total score
        if (maximum >= 150) {
            finalMax = 150; //final max sum is 150 when the sum of max score is equal or greater than 150
        } else {
            finalMax = maximum; //final max sum is equal to the sum of max score when the sum of max score less than 150
        }
        System.out.print("How many section did you attend? ");
        int attendance = inputCheck(); //local variables, number of classes, must be an integer
        int attendScore; //local variable, score for attendance
        if (attendance < 6) { 
            attendScore = attendance * 5; //if number of classes is less than 6
            System.out.println("Section points = " + (attendScore) + " / 30");
        } else {
            attendScore = 30; //if number of classes is equal to or greater than 6
            System.out.println("Section points = 30 / 30");
        }
        int totalScore = finalScore + attendScore; //local variable, the total score is the sum of assignments' score and attending score
        int totalMax = finalMax + 30; //local variable, the total max score is the sum of assignments' max score and attending max score
        double homeworkWeight = (totalScore / (double)totalMax * weightHW); //local variable, the weight of homework
        System.out.println("Total points = " + (totalScore) + " / " + (totalMax)); //print out the total score
        System.out.println("Weighted score = " + Math.round(homeworkWeight * 100.0) /100.0 + " / " + weightHW); //print out the weight score
        System.out.println();
        return homeworkWeight; //return the weight of homework
    }
    
    public static void report() {
        double grade = midterm() + finalterm() + homework(); //calculate the percentage
        System.out.println("Overall percentage = " + Math.round(grade * 100.0) / 100.0); //print out the percentage
        if (grade >= 85) {
        //check conditions and print out minimum grade
            System.out.println("Your grade will be at least: 3.0");
        } else if (grade >= 75 && grade < 85) {
            System.out.println("Your grade will be at least: 2.0");
        } else if (grade >= 60 && grade < 75) {
            System.out.println("Your grade will be at least: 0.7");
        } else {
            System.out.println("Your grade will be at least: 0.0");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        begin();
        report();
    }


}
