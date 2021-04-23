package main

import "image/gif"

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return nil
	}
	// return helper(1, n)
	return generateTree(1, n)
}

func helper(start, end int) []*TreeNode {
	if start > end {
		return []*TreeNode{nil}
	}
	allTrees := []*TreeNode{}
	for i := start; i <= end; i++ {
		leftTrees := helper(start, i-1)
		rightTrees := helper(i+1, end)
		for _, left := range leftTrees {
			for _, right := range rightTrees {
				currTree := &TreeNode{i, nil, nil}
				currTree.left = left
				currTree.right = right
				allTrees = append(allTrees, currTree)
			}
		}
	}
	return allTrees
}


func generateTree(start, end int) []*TreeNode {
	if start > end {
		return []*TreeNode{nil}
	}
	allTrees := []*TreeNode{}
	for i := start; i <= end; i++ {
		leftTrees := generateTree(start, i-1)
		rightTrees := generateTree(i+1, end)

		for _, left := range leftTrees {
			for _, right := range rightTrees {
				node := &TreeNode{val: i}
				node.left = left
				node.right = right
				allTrees = append(allTrees, node)
			}
		}
	}
	return allTrees
}
