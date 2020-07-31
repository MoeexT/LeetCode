package dp

// import (
// 	"fmt"
// )

// Node is a tree node
type node struct {
	val   int
	lcount int // current node's count of left subtree
	count int  // 插入树后有多少个节点小于当前值
	left  *node
	right *node
}

// push a node into the binary search tree, then return the count of numbers less than node.val
func push(root, node *node) int {
	if node.val >= root.val {
		if node.val > root.val {
			node.count++
		}
		node.count += root.lcount
		if root.right == nil {
			root.right = node
			return node.count
		}
		return push(root.right, node)
	}
	// else statement. 
	root.lcount++
	if root.left == nil {
		root.left = node
		return node.count
	}
	return push(root.left, node)
}

// Time: O(nlogn); 16ms, 60.77%
// Space: O(n); 5.4MB, 100.00%
func countSmaller(nums []int) []int {
	n := len(nums)
	ans := make([]int, n)
	if n == 0 {
		return ans
	}

	root := &node{val: nums[n-1]}
	for i := n - 2; i >= 0; i-- {
		ans[i] = push(root, &node{val: nums[i]})
	}

	return ans
}

// func main() {
// 	fmt.Println(countSmaller([]int{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}))
// }
