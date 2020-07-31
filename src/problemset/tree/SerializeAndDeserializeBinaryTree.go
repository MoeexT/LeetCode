package main

import "fmt"

// TreeNode is a tree node
type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

// Codec is
type Codec struct {}

// Constructor is
func Constructor() Codec {
	return Codec{}
}


func (codec *Codec) serialize(root *TreeNode) string {

}

func (codec *Codec) deserialize(data string) *TreeNode {

}


// func main() {
// 	root := TreeNode{Val: 1}
// 	root.Left = &TreeNode{Val: 2}
// 	root.Right = &TreeNode{Val: 3}
// 	root.Right.Left = &TreeNode{Val: 4}
// 	root.Right.Right = &TreeNode{Val: 5}
// 	codec := Constructor()
// 	fmt.Println(codec.serialize(&root))
// 	fmt.Println(codec.serialize(codec.deserialize(codec.serialize(&root))) == codec.serialize(&root))
// }
