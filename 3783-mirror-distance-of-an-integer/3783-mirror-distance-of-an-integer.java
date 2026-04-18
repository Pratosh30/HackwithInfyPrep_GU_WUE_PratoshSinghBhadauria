import java.util.*;
class Solution {
    public static int rev(int a){
        int rnum=0;
        while(a!=0){
        int digit = a % 10;
          rnum = rnum * 10 + digit;
           a/= 10;
        }
        return rnum;
    }
    public static int ans(int n){
        int x= rev(n);
        int y = n;
        int z = Math.abs(y-x);

        return z;
    }
    public int mirrorDistance(int n) {
       return ans(n);
        
  }
}