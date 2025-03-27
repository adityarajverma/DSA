package dataStructure.dynamic;

public class Memoization {

    static int counter=0;
    static int counter1=0;
    static Integer[] memo = new Integer[100];

    public static void main(String args[])
    {
        System.out.println(fibonacci(40));
        System.out.println("Normal Counter: "+counter);

        System.out.println(memoizationFibonacci(40));
        System.out.println("Memoization Counter: "+counter1);

    }

    public static int fibonacci( int n)
    {
        counter++;
        if(n==0 ||n==1)
        {
            return n;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static int memoizationFibonacci(int n)
    {
        counter1++; // To count the number of times the function is called
        if(n==0 ||n==1)
        {
            return n;
        }

        if(memo[n]!=null)
        {
            return memo[n];
        }

        return memo[n]=memoizationFibonacci(n-1)+memoizationFibonacci(n-2);

    }



}
