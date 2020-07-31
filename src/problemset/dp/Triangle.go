package main

import (
	"fmt"
)

// problem: 120
// url: https://leetcode-cn.com/problems/triangle/

func minimumTotal(triangle [][]int) int {
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
		}
	}
	return triangle[0][0]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	fmt.Println(minimumTotal([][]int{
		{-1},
		{2, 3},
		{1, -1, -3},
		// {4, 1, 8, 3},
	}))
}
