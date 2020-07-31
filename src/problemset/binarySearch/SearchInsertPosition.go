package binarySearch

// import "fmt"
// problem: 35
// url: https://leetcode-cn.com/problems/search-insert-position/
// Time: O(logn); 4ms, 90.19%
// Space: O(1); 3.1MB, 33.33%
func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)
	if target <= nums[0] {
		return 0
	}
	if right == 1 {
		return 1
	}

	for left < right {
		mid := left + (right - left) >> 1
		if nums[mid] >= target && nums[mid-1] < target {
			return mid
		} else if nums[mid] > target {
			right = mid
		} else {
			// nums[mid] < target
			left = mid + 1
		}
	}
	// fmt.Printf("(%d, %d)", left, right)
	return right
}

// func main() {
// 	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 5))
// 	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 2))
// 	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 7))
// 	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 0))
// 	fmt.Println(searchInsert([]int{1, 2, 3, 4, 5, 10}, 2))
// }
