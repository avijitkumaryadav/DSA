import java.util.*;

public class SearchInMatrix {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int rows = sc.nextInt();
      int cols = sc.nextInt();

      int matrix[][] = new int[rows][cols];

      // Input matrix
      for(int i = 0; i < rows; i++) {
          for(int j = 0; j < cols; j++) {
              matrix[i][j] = sc.nextInt();
          }
      }

      // Read number to search
      int x = sc.nextInt();

      // Search for x in the matrix
      for(int i = 0; i < rows; i++) {
          for(int j = 0; j < cols; j++) {
              if(matrix[i][j] == x) {
                  System.out.println("x found at location (" + i + ", " + j + ")");
              }
          }
      }
      
      sc.close();
   }
}