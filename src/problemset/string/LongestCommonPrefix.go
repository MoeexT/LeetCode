package main

import (
	"fmt"
)

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	/* ans := ""
	for j := 0;; j++ {
		if j >= len(strs[0]) {
			break
		}
		pre := strs[0][j]
		for _, str := range strs {
			if j >= len(str) || str[j] != pre {
				return ans
			}
		}
		ans += string(pre)
	}
	return ans */
	for i := 0; i < len(strs[0]); i++ {
		for j := 1; j < len(strs); j++ {
			if i == len(strs[j]) || strs[j][i] != strs[0][i] {
				return strs[0][:i]
			}
		}
	}
	return strs[0]
}
