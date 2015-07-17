public class Solution {
    // O(n) space:
    // one n for status array, another n if consider recursion stack
    // How to get the best performance according to O(n) space? 
    // The answer is having a cache line which is larger than n.
    // 
    // O(n * c(n)) or O(n!) time:
    // At first glance, the time complexity maybe O(n * n^n).  We know that 
    // in each step, we need another O(n) time to check the status array.
    // Finally, we get O(n * n^n) running time.

    // 那么问题来了: Can we do better? Yes
    // 
    // T(n) = n * [T(n-1) + O(n)] 
    // divide by n! in each side: T(n)/n! = T(n-1)/n-1! + O(n)/n-1!
    // Then: T(n)/n! = O(n)/n-1! + O(n-1)/n-2! + O(n-2)/n-3! + ...
    //               = n/n-1! + n-1/n-2! + n-2/n-3! + ... 
    //               = 据说是个常数
    // 
    // 
    // Another thing is that this kind of quesion usually run into TLE error
    // rather than SMO(Stack Memeory Overflow) error
    public int totalNQueens(int n) {
        if(n <= 1)  return n;
        int[] ret = {0};
        int[] status = new int[n];
        doDFS(0, n, status, ret);
        return ret[0];
    }
    
    private void doDFS(int row, int n, int[] status, int[] ret){
        if(row == n){
            ret[0]++;
            return;
        }
        
        for(int j = 0; j < n; j++){
            status[row] = j;
            if(isValid(status, row))
                doDFS(row + 1, n, status, ret);
        }
    }
    
    private boolean isValid(int[] status, int row){
        for(int i = 0; i < row; i++){
            if(status[i] == status[row] || 
                row - i == Math.abs(status[i] - status[row]))
                return false;
        }
        return true;
    }
}