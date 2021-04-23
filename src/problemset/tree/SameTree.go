package main

// url: https://leetcode-cn.com/problems/same-tree/
// problem: 100


type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

// Time: O(n); 0ms, 100.00%
// Space: O(1); 2.1MB, 46.05%
func isSameTree(p, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	if p.Val != q.Val {
		return false
	}
	return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
