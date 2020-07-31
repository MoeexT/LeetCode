package main

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
// time: 16ms, 31.03%
// mem: 3.1MB, 45.16%
func lengthOfLongestSubstring(s string) int {
	p, q := 0, 0
	m := 0
	set := map[byte]int{}

	/* abcabcbb
	   p q
	*/
	for q < len(s) {
		if set[s[q]] == 0 {
			set[s[q]]++
			q++
		} else {
			for s[p] != s[q] {
				set[s[p]]--
				p++
			}
			set[s[p]]--
			p++
		}
		m = max(m, q-p)
	}

	return m
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
