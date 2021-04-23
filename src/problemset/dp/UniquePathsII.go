package main

// problem: 63
// url: https://leetcode-cn.com/problems/unique-paths-ii/submissions/

// time: O(mn); 0ms, 100.00%
// mem: O(mn); 2.5MB, 100.00%
func uniquePathsWithObstacles(grid [][]int) int {
	m, n := len(grid), len(grid[0])

	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	if grid[0][0] == 0 {
		dp[0][0] = 1
	} else {
		dp[0][0] = 0
	}

	for i := 1; i < m; i++ {
		if dp[i-1][0] == 1 && grid[i][0] == 0 {
			dp[i][0] = 1
		} else {
			dp[i][0] = 0
		}
	}
	for j := 1; j < n; j++ {
		if dp[0][j-1] == 1 && grid[0][j] == 0 {
			dp[0][j] = 1
		} else {
			dp[0][j] = 0
		}
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if grid[i][j] == 1 {
				dp[i][j] = 0
			} else {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}
	return dp[m-1][n-1]
}


// Time: O(mn); 0ms, 100.00%
// Space: O(n); 2.4MB, 100.00%
func uniquePathsWithObstacles_(grid [][]int) int {
	m, n := len(grid), len(grid[0])

	dp := make([]int, n)
	if grid[0][0] == 0 {
		dp[0] = 1
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				dp[j] = 0
				continue
			}
			if j-1 >= 0 && grid[i][j-1] == 0 {
				dp[j] += dp[j-1]
			}
		}
	}
	return dp[n-1]
}

