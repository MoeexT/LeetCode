package main

import "fmt"

// url: https://leetcode-cn.com/problems/rotate-array/solution/
// problem: 189

func rotate(nums []int, k int) {
	n := len(nums)
	k = k % n
	if k == 0 {
		return
	}

	if n&1 == 0 && k&1 == 0 {
		vessle, target := nums[0], k
		for i := 0; i < n/2; i++ {
			nums[target], vessle = vessle, nums[target]
			target = (target + k) % n
		}
		vessle, target = nums[1], k+1
		for i := 0; i < n/2; i++ {
			nums[target], vessle = vessle, nums[target]
			target = (target + k) % n
		}
	} else {
		vessle, target := nums[0], k
		for i := 0; i < n; i++ {
			nums[target], vessle = vessle, nums[target]
			target = (target + k) % n
		}
	}
	fmt.Println(nums)
}

func main() {
	rotate([]int{1, 2, 3, 4, 5, 6}, 3)
	/**
	[1,2,3,4,5,6]
	[3,4,5,6,1,2]
	[1,2,3,4,5,6,7]
	[6,7,1,2,3,4,5]
	*/
}
