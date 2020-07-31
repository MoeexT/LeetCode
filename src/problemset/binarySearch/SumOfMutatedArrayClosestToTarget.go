package binarySearch

import (
	"math"
)
// leetcode 1300

func findBestValue(arr []int, target int) int {
	n := len(arr)
	avg, max := int(math.Round(float64(target)/float64(n))), 0

	for _, v := range arr {
		if v > max {
			max = v
		}
	}
	if max < avg {
		return max
	}

	abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}

	pre := math.MaxInt64
	for i := avg; ; i++ {
		sum := 0
		for _, v := range arr {
			sum += min(i, v)
		}
		if abs(sum-target) >= pre {
			return i - 1
		}
		pre = abs(sum - target)
	}
}

// func main() {
// 	fmt.Println(findBestValue([]int{4, 6, 3}, 10))
// }
