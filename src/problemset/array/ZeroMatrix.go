package main

// import "fmt"

func setZeros(matrix [][]int) {
	col, row := false, false

	if matrix[0][0] == 0 {
		col, row = true, true
	} else {
		for i := 1; i < len(matrix); i++ {
			if matrix[i][0] == 0 {
				col = true
			}
		}
		for j := 1; j < len(matrix[0]); j++ {
			if matrix[0][j] == 0 {
				row = true
			}
		}
	}

	for i := 1; i < len(matrix); i++ {
		for j := 1; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				matrix[i][0] = 0
				matrix[0][j] = 0
			}
		}
	}
	
	for i := 1; i < len(matrix); i++ {
		if matrix[i][0] == 0 {
			for j := 1; j < len(matrix[0]); j++ {
				matrix[i][j] = 0
			}
		}
	}

	for j := 1; j < len(matrix[0]); j++ {
		if matrix[0][j] == 0 {
			for i := 1; i < len(matrix); i++ {
				matrix[i][j] = 0
			}
		}
	}

	if row {
		for j := 0; j < len(matrix[0]); j++ {
			matrix[0][j] = 0
		}
	}
	if col {
		for i := 0; i < len(matrix); i++ {
			matrix[i][0] = 0
		}
	}
}
/* 
func main() {
	matrix := [][]int {{0,1,2,0},{3,4,5,2},{1,3,1,5}}
	setZeros(matrix)
	fmt.Print(matrix)
} */
