package main

import "fmt"

// url: https://leetcode-cn.com/problems/minimum-path-sum/
// problem: 64
// Time: O(n^2); 8ms, 89.86%
// Space: O(n^2); 4.4MB, 33.33%
func minPathSum(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	dp[0][0] = grid[0][0]
	for i := 1; i < m; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}
	for j := 1; j < n; j++ {
		dp[0][j] = dp[0][j-1] + grid[0][j]
	}
	fmt.Println(dp)

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}

	return dp[m-1][n-1]
}

// Time: O(n^2); 8ms, 89.86%
// Space: O(n); 3.9MB, 66.67%
func minPathSum_(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([]int, n)
	// dp[0] = grid[0][0]

	// for j := 1; j < n; j++ {
	// 	dp[j] = dp[j-1] + grid[0][j]
	// }

	for i := 0; i < m; i++ {
		dp[0] += grid[i][0]
		for j := 1; j < n; j++ {
			if i == 0 {
				dp[j] = dp[j-1] + grid[i][j]
			} else {
				dp[j] = min(dp[j-1], dp[j]) + grid[i][j]
			}
		}
	}

	return dp[n-1]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	fmt.Println(minPathSum_([][]int{
		{1,3,1},
		{1,5,1},
		// {4,2,1},
	}))
}
