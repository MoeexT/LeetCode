package main

import (
	"fmt"
	"math"
)

// problem: 174
// url: https://leetcode-cn.com/problems/dungeon-game/
// 题解
// Time: O(n^2); 4ms, 97.56%
// Space: O(n^2); 3.7MB, 100.00%
func calculateMinimumHP(dungeon [][]int) int {
	n, m := len(dungeon), len(dungeon[0])

	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, m+1)
		for j := 0; j < m+1; j++ {
			dp[i][j] = math.MaxInt32
		}
	}

	dp[n][m-1], dp[n-1][m] = 1, 1

	for i := n - 1; i >= 0; i-- {
		for j := m-1; j >= 0; j-- {
			minn := min(dp[i+1][j], dp[i][j+1])
			dp[i][j] = max(minn - dungeon[i][j], 1)
		}
	}

	return dp[0][0]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func main() {
	fmt.Println(calculateMinimumHP([][]int{
		{-2, -3, 3},
		{-5, -10, 1},
		{10, 30, -5},
	}))
}
