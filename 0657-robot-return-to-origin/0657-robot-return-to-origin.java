class Solution {
    // time :O(n), n = number of characters to loop through
    // space:O(1) 

    public boolean judgeCircle(String moves) {
        // moves = "UD" - first move up then down
        // U = y++;
        // D = y--; 

        // moving opposite direction cancel out
        // moving same direction add up

        int x = 0;
        int y = 0;

        for(char c : moves.toCharArray()) {
            if(c == 'R') x++;
            else if(c == 'L') x--;
            else if(c == 'U') y++;
            else if(c == 'D') y--;

        }
            return x == 0 && y == 0;
    }
}