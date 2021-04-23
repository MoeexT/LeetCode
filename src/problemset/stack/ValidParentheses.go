package main

import "fmt"

// url: https://leetcode-cn.com/problems/valid-parentheses/
// problem: 20

// Time: O(n); 0ms, 100%
// Space: O(n); 2MB, 37.85%
func isValid(s string) bool {
	dict := map[rune]rune{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := []rune{}
	for _, ch := range s {
		if _, ok := dict[ch]; !ok {
			stack = append(stack, ch)
		} else {
			if len(stack) != 0 && stack[len(stack)-1] == dict[ch] {
				stack = stack[0:len(stack)-1]
			} else {
				return false
			}
		}
	}
	fmt.Println(stack)
	return len(stack) == 0
}

func main() {
	fmt.Println(isValid("]"))
}
