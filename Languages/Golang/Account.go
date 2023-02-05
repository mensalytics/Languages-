package main

type Account struct {
	accountNumber    int
	pin              int
	avaliableBalance float64
	totalBalance     float64
}

func NewAccount(theAccountNumber int, thePin int, theAvailableBalance float64, theTotalBalance float64) *Account {
	return &Account{accountNumber: theAccountNumber, pin: thePin, avaliableBalance: theAvailableBalance, totalBalance: theTotalBalance}
}

// validate user pin
func (a *Account) validatePin(userPin int) bool {
	if userPin == a.pin {
		return true
	} else {
		return false
	}
}

// get the available balance
func (a *Account) getAvailableBalance() float64 {
	return a.avaliableBalance
}

// get the total balance
func (a *Account) getTotalBalance() float64 {
	return a.totalBalance
}

// credit an amount to the account
func (a *Account) credit(amount float64) {
	a.totalBalance += amount
}

// debit an amount from the account
func (a *Account) debit(amount float64) {
	a.avaliableBalance -= amount
	a.totalBalance -= amount
}

// get account number
func (a *Account) getAccountNumber() int {
	return a.accountNumber
}
