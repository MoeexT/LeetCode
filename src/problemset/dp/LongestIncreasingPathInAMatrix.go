package main

import (
	"fmt"
)

// url: https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
// problem: 329

func longestIncreasingPath(matrix [][]int) int {
	m, n := len(matrix), len(matrix[0])
	dp := make([]int, n)

	for j := 0; j < n; j++ {
		dp[j] += matrix[0][j]
	}

	for i := 1; i < m; i++ {
		dp[0] += matrix[i][0]
		for j := 1; j < n; j++ {
			dp[j] = matrix[i][j] + max(dp[i-1], dp[j-1])
		}
	}
	return dp[n-1]
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func main() {
	fmt.Println(longestIncreasingPath([][]int{
		{9, 9, 4},
		{6, 6, 8},
		{2, 1, 1},
	}))
}
