package main

import "fmt"

func median(A, B []int) int {

	low1, high1 := 0, len(A)-1
	low2, high2 := 0, len(B)-1

	for low1 != high1 || low2 != high2 {
		span1, span2 := high1-low1, high2-low2
		mid1, mid2 := low1+span1>>1, low2+span2>>1
		if A[mid1] == B[mid2] {
			return A[mid1]
		}
		if A[mid1] < B[mid2] {
			low1 = mid1 + span1&1
			high2 = mid2
		} else {
			high1 = mid1 + span2&1
			low2 = mid2
		}
	}
	if A[low1] < B[low2] {

		return A[low1]
	}
	return B[low2]
}

func main() {
	ans := median([]int{2, 4, 6, 8, 20}, []int{11, 13, 15, 17, 19})
	fmt.Println(ans)
}
