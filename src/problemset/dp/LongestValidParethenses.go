package dp

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func longestValidParenthesesDP(s string) int {
	maxAns, n := 0, len(s)
	dp := make([]int, n)
	for i := 0; i < n; i++ {
		/* pos := i - dp[i-1] - 1
		if s[i] == ')' && pos >= 0 && s[pos] == '(' {
			dp[i] = dp[i-1] + dp[pos-1] + 2
			maxAns = max(maxAns, dp[i])
		} */

		if s[i] == ')' {
			if s[i-1] == '(' {
				if i >= 2 {
					dp[i] = dp[i-2] + 2
				} else {
					dp[i] = 2
				}
			} else if i-dp[i-1] > 0 && s[i-dp[i-1]-1] == '(' {
				if i-dp[i-1] >= 2 {
					dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
				} else {
					dp[i] = dp[i-1] + 2
				}
			}
			maxAns = max(maxAns, dp[i])
		}
	}
	return maxAns
}
