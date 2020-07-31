package main

// import "fmt"

func groupAnagrams(strs []string) [][]string {
	dict := map[rune]uint64{
		'a': 2, 'b': 3, 'c': 5, 'd': 7, 'e': 11, 'f': 13,
		'g': 17, 'h': 19, 'i': 23, 'j': 29, 'k': 31, 'l': 37,
		'm': 41, 'n': 43, 'o': 47, 'p': 53, 'q': 59, 'r': 61,
		's': 67, 't': 71, 'u': 73, 'v': 79, 'w': 83, 'x': 89,
		'y': 97, 'z': 101,
	}

	ans := [][]string{}
	ap := 0
	ext := map[uint64]int{}

	for _, str := range strs {
		var harsh uint64 = 1
		for _, c := range str {
			harsh *= dict[c]
		}
		if idx, ok := ext[harsh]; ok == false {
			ext[harsh] = ap
			ans = append(ans, []string{})
			ans[ap] = append(ans[ap], str)
			ap++
		} else {
			ans[idx] = append(ans[idx], str)
		}
	}

	return ans
}

/* func main() {
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
} */
