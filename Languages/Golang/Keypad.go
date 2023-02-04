package main

import (
	"bufio"
	"os"
	"strconv"
)

type Keypad struct{}

func (k *Keypad) GetInput() int {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	input = input[:len(input)-1]
	value, _ := strconv.Atoi(input)
	return value

}

func main() {}
