package main

import "fmt"

// https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

// 暴力法
// 枚举A中起始位置i与B中起始位置j，然后计算A[i:]与[j:]
// 的最长公共前缀
func findLength1(A, B []int) int {
	na, nb := len(A), len(B)
	ans := 0

	for i := 0; i < na; i++ {
		for j := 0; j < nb; j++ {
			k := 0
			for i+k < na && j+k < nb && A[i+k] == B[j+k] {
				k++
			}
			ans = max(ans, k)
		}
	}

	return ans
}

// dp
func findLength2(A, B []int) int {
	na, nb := len(A), len(B)
	dp := make([][]int, na+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, nb + 1)
	}

	ans := 0

	for i := na - 1; i >= 0; i-- {
		for j := nb - 1; j >= 0; j-- {
			if A[i] == B[j] {
				dp[i][j] = dp[i+1][j+1] + 1
			} else {
				dp[i][j] = 0
			}
			if ans < dp[i][j] {
				ans = dp[i][j]
			}
		}
	}

	return ans
}

func maxLength(A, B []int, addA, addB, len int) int {
	ret, k := 0, 0
	for i := 0; i < len; i++ {
		if A[addA+i] == B[addB+i] {
			k++
		} else {
			k = 0
		}
		ret = max(ret, k)
	}
	return ret
}

// sliding window
func findLength3(A, B []int) int {
	n, m := len(A), len(B)
	ret := 0
	for i := 0; i < n; i++ {
		len := min(m, n-i)
		maxLen := maxLength(A, B, i, 0, len)
		ret = max(ret, maxLen)
	}
	for i := 0; i < m; i++ {
		len := min(n, m-i)
		maxLen := maxLength(A, B, 0, i, len)
		ret = max(ret, maxLen)
	}
	return ret
}

func main() {
	fmt.Println(findLength1([]int{3, 2, 1, 4, 7}, []int{1, 2, 3, 2, 1}))
}
