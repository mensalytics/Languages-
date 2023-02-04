package main

import (
	"fmt"
)

// Golang uses structure instead of class
// What is the difference between structure and class?

type Screen struct{}

func (s *Screen) DisplayMessage(message string) {
	fmt.Println(message)
}

func (s *Screen) DisplayMessageWithNewLine(message string) {
	fmt.Println(message)
}

func (s *Screen) DisplayDollarAmount(amount float64) {
	fmt.Printf("$%.2f", amount)
}
