package TwoDimensionWordGrid;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAWordInGrid {
    public static int[] ansIndex= new int[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] grid = {
                {'F', 'R', 'I', 'E', 'N', 'D', 'S', 'H', 'I', 'P'},
                {'L', 'O', 'V', 'E', 'R', 'F', 'A', 'M', 'I', 'L'},
                {'B', 'R', 'O', 'T', 'H', 'E', 'R', 'S', 'I', 'S'},
                {'S', 'I', 'S', 'T', 'E', 'R', 'S', 'D', 'A', 'D'},
                {'M', 'O', 'T', 'H', 'E', 'R', 'S', 'T', 'E', 'P'},
                {'F', 'A', 'T', 'H', 'E', 'R', 'T', 'E', 'A', 'C'},
                {'H', 'E', 'A', 'L', 'I', 'N', 'G', 'C', 'A', 'R'},
                {'E', 'M', 'P', 'A', 'T', 'H', 'Y', 'F', 'R', 'I'},
                {'E', 'N', 'C', 'O', 'U', 'R', 'A', 'G', 'E', 'M'},
                {'E', 'N', 'D', 'L', 'E', 'S', 'S', 'P', 'O', 'S'}
        };

        String[] wordsToSearch = {
                "FRIENDSHIP",
                "LOVE",
                "FAMILY",
                "BROTHER",
                "SISTER",
                "MOTHER",
                "FATHER",
                "HEALING",
                "EMPATHY",
                "ENCOURAGEMENT",
                "ENDLESS"
        };

//        System.out.print("Enter a word to search in grid: ");
        for (int i = 0; i < wordsToSearch.length; i++) {
            boolean ans = findWord(grid, wordsToSearch[i]);
            if (ans) {
                System.out.println();
                System.out.println("Word: "+wordsToSearch[i]);
                System.out.println(ans);
                System.out.println("Word starts from: ");
                System.out.print("Row : "+ansIndex[0]+", Col : "+ansIndex[1]);
                System.out.println();
            } else {
                System.out.println();
                System.out.println(wordsToSearch[i]);
                System.out.println(ans);
            }
        }
    }

    public static boolean findWord(char[][] grid, String word) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == word.charAt(0)){
                    if ( searchPossibilities(grid, word, i, j) )
                        return true;
                }
            }// end of inner for
        }// end of outer for
        return false;
    }

    private static boolean searchPossibilities(char[][] grid, String word, int r, int c) {

        Horizontl_F:// 1
        {// Horizontal front check;
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if ( row >= grid.length || row < 0 || col >= grid[0].length || col < 0 )
                    break Horizontl_F;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                col++;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of horizantal front block

        Horizontl_B:// 2
        {// Horizontal back check;
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Horizontl_B;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                col--;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of horizontal back block

        Vertical_U:// 3
        {// vertical up check;
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Vertical_U;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                row--;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of vertical up block

        Vertical_D:// 4
        {// Start vertical down check;
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Vertical_D;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                row++;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of vertical down block

        Digonal_L_R_D:// 5
        {// Start of Digonal top left to bottom right
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Digonal_L_R_D;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                row++;
                col++;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of Digonal top left to bottom right

        Digonal_R_L_U:// 6
        {// Start of Digonal bottom right to top left
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Digonal_R_L_U;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                row--;
                col--;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of Digonal bottom right to top left

        Digonal_L_R_U:// 7
        {// Start of digonal bottom left to top right.
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Digonal_L_R_U;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                row--;
                col++;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of digonal bottom left to top right.

        Digonal_R_L_D:// 8
        {// Start of reverse Digonal top right to bottom left
            int check = 0;
            int row = r;
            int col = c;
            for (int count = 0; count < word.length(); count++) {
                if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
                    break Digonal_R_L_D;
                else if (grid[row][col] == word.charAt(count))
                    check++;
                row++;
                col--;
            }
            if( check == word.length() ) {
                ansIndex[0] = r + 1;
                ansIndex[1] = c + 1;
                return true;
            }
        }// End of reverse Digonal top right to bottom left

        return false;

    }
}