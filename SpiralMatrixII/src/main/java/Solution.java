public class Solution {

    public int[][] generateMatrix(int n){

        //we declare a 2d matrix with the dimensions from n
        int[][] res = new int[n][n];

        //we keep a boundary of the row begining and row end (0 and n-1)
        //when we do a spiral traversal aka increment row and col boundary by 1

        int rowBegin = 0;
        int rowEnd = n-1;
        int columnBegin = 0;
        int columnEnd = n-1;
        //have a counter set to 1, increment to n squared
        int counter = 1;

        while(rowBegin <= rowEnd && columnBegin <= columnEnd){
            //the main condition to ensure we are within the boundary, we are doing 4 loops now

            for(int i = columnBegin; i<= columnEnd; i++){
                res[rowBegin][i] = counter++;
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++){
                res[i][columnEnd] = counter++;
            }

            columnEnd--;

            if(rowBegin <= rowEnd){
                for(int i = columnEnd; i>= columnBegin; i--){
                    res[rowEnd][i] = counter++;
                }
            }

            rowEnd--;

            if(columnBegin <= columnEnd){
                for(int i =  rowEnd; i>= rowBegin; i--){
                    res[i][columnBegin] = counter++;
                }
            }

            columnBegin++;

        }

        return res;

    }
    

}
