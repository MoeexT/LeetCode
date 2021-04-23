package main

import (
	"fmt"
)

// url: https://leetcode-cn.com/problems/house-robber-iii/
// problem: 337

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func rob(root *TreeNode) int {
	result := helper(root)
	return max(result[0], result[1])
}

func helper(root *TreeNode) []int {
	result := make([]int, 2)
	if root != nil {
		left := helper(root.left)
		right := helper(root.right)
		result[0] = max(left[0], left[1]) + max(right[0], right[1])
		result[1] = left[0]+right[0]+root.val
	}
	return result
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func main() {
	root := &TreeNode{val: 3}
	root.left = &TreeNode{val: 2}
	root.left.right = &TreeNode{val: 3}
	root.right = &TreeNode{val: 3}
	root.right.right = &TreeNode{val: 1}
	fmt.Println(rob(root))
}
