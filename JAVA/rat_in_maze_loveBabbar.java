// Input:
// N = 4
// m[][] = {{1, 0, 0, 0},
//          {1, 1, 0, 1}, 
//          {1, 1, 0, 0},
//          {0, 1, 1, 1}}
// Output:
// DDRDRR DRDDRR



class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }

        if (m[0][0] == 0) {
            ans.add("-1");
            return ans;
        }
        solve(0, 0, m, n, "", ans, visited);
        return ans;

    }

    public static void solve(int row, int col, int[][] m, int n, String path, ArrayList<String> ans, int[][] visited) {

        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        if (row + 1 < n && m[row + 1][col] == 1 && visited[row + 1][col] == 0) {
            visited[row][col] = 1;
            solve(row + 1, col, m, n, path + "D", ans, visited);
            visited[row][col] = 0;
        }

        if (col + 1 < n && m[row][col + 1] == 1 && visited[row][col + 1] == 0) {
            visited[row][col] = 1;
            solve(row, col + 1, m, n, path + "R", ans, visited);
            visited[row][col] = 0;
        }

        if (row - 1 >= 0 && m[row - 1][col] == 1 && visited[row - 1][col] == 0) {
            visited[row][col] = 1;
            solve(row - 1, col, m, n, path + "U", ans, visited);
            visited[row][col] = 0;
        }

        if (col - 1 >= 0 && m[row][col - 1] == 1 && visited[row][col - 1] == 0) {
            visited[row][col] = 1;
            solve(row, col - 1, m, n, path + "L", ans, visited);
            visited[row][col] = 0;
        }
    }
}
