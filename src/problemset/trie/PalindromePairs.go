package main

import "fmt"

// url: https://leetcode-cn.com/problems/palindrome-pairs/comments/
// problem: 336

func palindromePairs(words []string) [][]int {
	ans := [][]int{}
	for i := 0; i < len(words); i++ {
		for j := i + 1; j < len(words); j++ {
			if isPalindrome(words[i]+words[j]) {
				ans = append(ans, []int{i, j})
			}
			if isPalindrome(words[j]+words[i]) {
				ans = append(ans, []int{j, i})
			}
		}
	}
	return ans
}

func isPalindrome(str string) bool {
	n := len(str)
	for i := 0; i < n >> 1; i++ {
		if str[i] != str[n-i-1] {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(palindromePairs([]string{
		"abcd","dcba","lls","s","sssll",
	}))
}
