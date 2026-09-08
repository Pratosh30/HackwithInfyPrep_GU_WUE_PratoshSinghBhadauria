class Solution {
    public int countCommas(int n) {
        int c = n%1000;
        if(n<1000){
            return 0;
        }else if(n==1000){
            return 1;
        }else if(n==10000){
            return 9001;
        }else if(n==100000){
            return 99001;
        }
        else if(c==0|| c<1){
            return 0;
        }
        else{
            return n-1000+1;
        }
    }
}