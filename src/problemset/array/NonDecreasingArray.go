package main

import "fmt"

func checkPossibility(nums []int) bool {
	if len(nums) <= 2 {
		return true
	}
	count := 0
	for i := 1; i < len(nums) && count < 2; i++ {
		if nums[i-1] <= nums[i] {
			continue
		}
		count++
		if i-2 >= 0 && nums[i-2] > nums[i] {
			nums[i] = nums[i-1]
		} else {
			nums[i-1] = nums[i]
		}
	}
	return count <= 1
}

func main() {
	fmt.Println(checkPossibility([]int{3,4,2,3}))
}
