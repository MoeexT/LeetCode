package main

import (
	"fmt"
	"sort"
)

// 排序，二分查找
func threeSum(nums []int) [][]int {
	// map := map[int]int
	n := len(nums)
	sort.Ints(nums)
	ans := [][]int{}

	for first := 0; first < n; first++ {
		if first > 0 && nums[first] == nums[first-1] {
			continue
		}
		third := n - 1
		target := -1 * nums[first]
		for second := first + 1; second < n; second++ {
			if second > first+1 && nums[second] == nums[second-1] {
				continue
			}
			for second < third && nums[second]+nums[third] > target {
				third--
			}
			if second == third {
				break
			}
			if nums[second]+nums[third] == target {
				ans = append(ans, []int{nums[first], nums[second], nums[third]})
			}
		}
	}
	return ans
}

// set查找
func threSum(nums []int) (ans [][]int) {
	ans = make([][]int, 0)
	if len(nums) < 3 {
		return
	}
	// 排序为了方便判重
	sort.Ints(nums)

	for i, v := range nums[:len(nums)-2] {
		if i >= 1 && v == nums[i-1] {
			continue
		}
		d := map[int]int{}
		for _, x := range nums[i+1:] {
			if _, ok := d[x]; ok == false {
				d[-v-x] = 1
			} else {
				if !contain(ans, []int{v, -v - x, x}) {
					ans = append(ans, []int{v, -v - x, x})
				}
			}
		}
	}
	return
}

func contain(matrix [][]int, vector []int) (equal bool) {
	equal = false
	for _, v := range matrix {
		equal = equal || sliceEqual(v, vector)
	}
	return
}

func sliceEqual(alpha, beta []int) bool {
	if len(alpha) != len(beta) {
		return false
	}
	if (alpha == nil) || (beta == nil) {
		return false
	}
	for i, v := range alpha {
		if v != beta[i] {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(threSum([]int{-1, 0, 1, 2, -1, -4}))
}
