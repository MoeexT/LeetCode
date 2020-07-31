package problemset.array;

/**
 * date: 2020-03-26 time: 15:28:13 author: MoeexT problem: 999 url:
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 */

public class AvailableCapturesForRook {
    /** 
     * time: 0ms 100.00%
     * mem: 36.8MB 5.40%
     */
    public int numBookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int x = i, y = j;
                    while (x > -1) {
                        if (board[x][j] == 'B')
                            break;
                        else if (board[x][j] == 'p') {
                            res ++;
                            break;
                        }
                        x--;
                    }
                    x = i;
                    while (x < 8) {
                        if (board[x][j] == 'B')
                            break;
                        else if (board[x][j] == 'p') {
                            res ++;
                            break;
                        }
                        x++;
                    }
                    while (y > -1) {
                        if (board[i][y] == 'B')
                            break;
                        else if (board[i][y] == 'p') {
                            res ++;
                            break;
                        }
                        y--;
                    }
                    y = j;
                    while (y<8) {
                        if (board[i][y] == 'B')
                            break;
                        else if (board[i][y] == 'p') {
                            res ++;
                            break;
                        }
                        y++;
                    }
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        AvailableCapturesForRook obj = new AvailableCapturesForRook();
        System.out.println(obj.numBookCaptures(
                new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
                        { '.', '.', '.', 'R', '.', '.', '.', 'p' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
                        { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
                        { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } }));
    }
}
