package main

// go mod init Foldername

type BankDatabase struct {
	Accounts []Account
}

// function object from BankDatabase structure that authenticatesUser with useraccountnumber and pin and returns boolean
// useraccount is set to function obect calls getaccount method with argument useraccountnumber
// if useraccount is not null
// return useraccount calls validatepin method with argument pin
// else returns false
func (b *BankDatabase) authenticateUser(userAccountNumber int, userPin int) bool {
	userAccount := b.getAccount(userAccountNumber)
	if userAccount != nil {
		return userAccount.validatePin(userPin)
	} else {
		return false
	}

}

func (b *BankDatabase) getAvailableBalance(userAccountNumber int) float64 {
	return b.getAccount(userAccountNumber).getAvailableBalance()
}

func (b *BankDatabase) getTotalBalance(userAccountNumber int) float64 {
	return b.getAccount(userAccountNumber).getTotalBalance()
}

func (b *BankDatabase) credit(userAccountNumber int, amount float64) {
	b.getAccount(userAccountNumber).credit(amount)
}

func (b *BankDatabase) debit(userAccountNumber int, amount float64) {
	b.getAccount(userAccountNumber).debit(amount)
}

func (b *BankDatabase) getAccount(userAccountNumber int) *Account {
	for i := 0; i < len(b.Accounts); i++ {
		if b.Accounts[i].getAccountNumber() == userAccountNumber {
			return &b.Accounts[i]
		}
	}
	return nil
}

func NewBankDatabase() *BankDatabase {
	return &BankDatabase{
		Accounts: []Account{
			{accountNumber: 12345, pin: 54321, avaliableBalance: 1000.0, totalBalance: 1200.0},
			{accountNumber: 98765, pin: 56789, avaliableBalance: 200.0, totalBalance: 200.0},
		},
	}
}
