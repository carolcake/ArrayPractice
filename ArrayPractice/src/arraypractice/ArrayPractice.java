/*
Caroline Hsu - 10/25/2022
First program - With a 1D array of integers, I write three methods to 
display the columnSum and average of the array, display the number of odd and even
numbers, and display the largest two numbers. With two 1D arrays, I display
the common elements betweeen two arrays. With a 2D array, the columnSum of the 
maximum value of each row and column. 

 */
package arraypractice;

public class ArrayPractice
{

  public static void main(String[] args)
  {
    // initialize arrays and important variables
    int[] array1 =
    {
      4, 3, 7, 12, 1, 71, 3, 2, 6, 9, 26, 12
    };
    int[] array2 =
    {
      8, 23, 29, 45, 17, 20, 15, 7, 4, 1, 4, 8
    };
    int[][] array2D =
    {
      {
        5, 3, 55
      },
      {
        9, 21, 96
      },
      {
        32, 26, 34
      },
      {
        19, 8, 76
      }
    };
    int columns = 3;
    int rows = 4;
    int sum = 0;
    double average = 0;
    String oddEvenString = "";
    String largestTwo = "";

    // call and calculate average for 1d array and print
    sum = sumAndAverage1DArray(array1);
    average = sum / array1.length;
    System.out.println("The average is " + average);

    // call and calculate all odd and even numbers in 1d array and pring
    oddEvenString = oddAndEven1DArray(array1);
    System.out.println(oddEvenString);

    // call method to find largest 2 numbers and print
    largestTwo = largestMethod(array1);
    System.out.println(largestTwo);

    // call method to find the common elements in both arrays
    commonElements(array1, array2);

    // call method to find the maximum sum of the rows and columns
    maxValue(array2D, rows, columns);

  }

  public static int sumAndAverage1DArray(int[] array1)
  {
    int sum = 0;
    // use a for loop to iterate through array and add for sum
    for (int i = 0; i < array1.length; i++)
    {
      sum = array1[i] + sum;
    }
    // return sum  to main class
    return sum;
  }

  public static String oddAndEven1DArray(int[] array1)
  {
    // initialize variables for counters and answer
    int oddCounter = 0;
    int evenCounter = 0;
    double answer = 0;
    String oddAndEvenReturn = "";

    // for loop to iterate through 1d array to count for even numbers
    for (int i = 0; i < array1.length; i++)
    {
      //division and modulus to calculate the remainder
      answer = array1[i] % 2;
      if (answer == 0)
      {
        evenCounter = evenCounter + 1;
      }
      else
      {
        oddCounter = oddCounter + 1;
      }
    }
    // return string for main class
    oddAndEvenReturn = "The number of even numbers is " + evenCounter + " and the "
        + "number of odd numbers is " + oddCounter;
    return oddAndEvenReturn;
  }

  public static String largestMethod(int[] array1)
  {
    // find the largest 2 numbers by setting both equal to the first number first
    int largest1 = array1[0];
    int largest2 = array1[0];
    String returnString = "";
    // for loop iterates through the array 
    for (int i = 0; i < array1.length; i++)
    {
      // if the array at index is larger than the max number
      if (array1[i] > largest1)
      {
        // make it the max number
        largest1 = array1[i];
      }
      // if the array at index is less than the max number
      if (array1[i] < largest1)
      {
        //  set the 2nd largest number equal to the array at that index
        largest2 = array1[i];
      }
    }
    // print and return string
    returnString = "The largest two numbers in the array are " + largest1 + " and " + largest2;
    return returnString;
  }

  public static void commonElements(int[] array1, int[] array2)
  {
    // make a new array for common elements
    int[] returnArray = new int[array1.length];
    int counter = 0;
    // iterate through both arrays
    for (int i = 0; i < array1.length; i++)
    {
      for (int k = 0; k < array2.length; k++)
      {
        // if they are equal at their respective counters
        if (array1[i] == array2[k])
        {
          // add one to the counter and set the common elements array equal to that value
          returnArray[counter] = array1[i];
          counter++;
        }
      }
    }
    // print the common elements
    System.out.println("Common elements in both arrays are: ");

    // for duplicates (if the common elements array at index is equal to the 
    // next value then just print once
    for (int i = 0; i < returnArray.length - 1; i++)
    {
      if (returnArray[i] != returnArray[i + 1])
      {
        System.out.println(returnArray[i]);
      }
    }
  }

  // receive no of rows and columns
  public static void maxValue(int[][] array2D, int rows, int columns)
  {
    // initialize variables for column and row
    int columnSum = 0;
    int maxColumn = 0;
    int rowSum = 0;
    int maxRow = 0;
    int[] rowArray = new int[rows];
    int counter = 0;

    // columns max sum - iterate through
    for (int i = 0; i < columns; i++)
    {
      maxColumn = array2D[0][i];
      for (int j = 1; j < array2D[i].length; j++)
      {
        // if it's bigger than the max column value then set it equal
        if (array2D[j][i] > maxColumn)
        {
          maxColumn = array2D[j][i];

        }
      }
      // add the column sum up
      columnSum = columnSum + maxColumn;
    }
    // print for user
    System.out.println("The maximum sum of the columns is: " + columnSum);
    
    // row max sum - while loop for if the counter is less than rows
    while (counter < rows)
    {
      // for loop iteration
      for (int j = 0; j < array2D[counter].length; j++)
      {
        // if the array at the counter and index is greater than the max row value
        if (array2D[counter][j] > maxRow)
        {
          // set array2d at counter and index to new max row value
          maxRow = array2D[counter][j];
        }
      }
      // add to row array and add to counter
      rowArray[counter] = maxRow;
      maxRow = 0;
      counter++;
    }
    //iterate row array to calcalate row sum
    for (int i = 0; i < rows; i++)
    {
      rowSum = rowArray[i] + rowSum;
    }
    // print for user
    System.out.println("The maximum sum of the rows is: " + rowSum);
  }

}
