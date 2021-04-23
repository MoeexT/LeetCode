package main

import "fmt"

// url: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
// problem: 122

// Time: O(n); 4ms, 95.47%
// Space: O(1); 3.1MB, 100.00%
func maxProfit(prices []int) int {
	sum, n := 0, len(prices)
	for i := 1; i < n; i++ {
		if sub := prices[i] - prices[i-1]; sub > 0 {
			sum += sub
		}
	}
	return sum
}

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
}
