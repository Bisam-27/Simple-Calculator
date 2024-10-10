package calpackage;

import java.util.Scanner;

public class calculator 
{
    public int addition(int a, int b) throws IllegalArgumentException 
    {
        if (a < 0 || b < 0)
        {
            throw new IllegalArgumentException("Both inputs must be non-negative.");
        }
        return a + b;
    }
    public int multiplication(int a, int b) throws IllegalArgumentException 
    {
        if (a < 0 || b < 0) 
        {
            throw new IllegalArgumentException("Both inputs must be non-negative.");
        }
        return a * b;
    }

    public static void main(String[] args) 
    {
        calculator calculator = new calculator();
        Scanner scanner = new Scanner(System.in);

        try 
        {
            System.out.print("Enter the first number for addition: ");
            int addNum1 = scanner.nextInt();
            System.out.print("Enter the second number for addition: ");
            int addNum2 = scanner.nextInt();
            System.out.println("Addition Result: " + calculator.addition(addNum1, addNum2));

            System.out.print("Enter the first number for multiplication: ");
            int mulNum1 = scanner.nextInt();
            System.out.print("Enter the second number for multiplication: ");
            int mulNum2 = scanner.nextInt();
            System.out.println("Multiplication Result: " + calculator.multiplication(mulNum1, mulNum2));

        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Error: " + e.getMessage());
        } 
        finally 
        {
            scanner.close(); 
        }
    }
}
