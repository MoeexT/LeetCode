package main

// TreeNode is a tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	return atot(nums, 0, len(nums))
}

// 左闭右开
func atot(nums []int, low, high int) *TreeNode {
	n := high - low
	if n == 1 {
		return &TreeNode{Val: nums[low]}
	}
	if n == 2 {
		root := &TreeNode{Val: nums[high-1]}
		root.Left = &TreeNode{Val: nums[low]}
		return root
	}
	/* if n == 3 {
		root := &TreeNode {Val: nums[low + (high-low) >> 1]}
		root.Left = &TreeNode{Val: nums[low]}
		root.Right = &TreeNode{Val: nums[high-1]}
		return root
	} */
	mid := low + (high-low)>>1
	root := &TreeNode{Val: nums[mid]}

	root.Left = atot(nums, low, mid)
	root.Right = atot(nums, mid+1, high)

	return root
}
