package main

// is there no abstract in GOLANG??
type Transaction struct {
	accountNumber int
	screen        *Screen
	bankDatabase  *BankDatabase
}

func NewTransaction(userAccountNumber int, atmScreen *Screen, atmBankDatabase *BankDatabase) *Transaction {
	return &Transaction{
		accountNumber: userAccountNumber,
		screen:        atmScreen,
		bankDatabase:  atmBankDatabase,
	}
}

func (t *Transaction) getAccountNumber() int {
	return t.accountNumber
}

func (t *Transaction) getScreen() *Screen {
	return t.screen
}

func (t *Transaction) getBankDatabase() *BankDatabase {
	return t.bankDatabase
}

func (t *Transaction) Execute() {
	// implementation here
}
