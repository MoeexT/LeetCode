package main

import "fmt"

// problem: 350
// url: https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
// Time: O(n); 0ms, 100%
// Space: O(n); 3.1MB, 100%
func intersect(nums1 []int, nums2 []int) []int {
    ans := []int{}
    set := make(map[int]int)
    for _, k := range nums1 {
        set[k]++
    }
    for _, k := range nums2 {
        if v, _ := set[k]; v > 0 {
            ans = append(ans, k)
            set[k]--
        }
    }
    return ans
}


func main() {
	fmt.Println(intersect([]int{4,9,5}, []int{9,4,9,8,4}))
}
