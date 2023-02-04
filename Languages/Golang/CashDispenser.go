package main

const initialCount = 2000

type CashDispenser struct {
	count int
}

func NewCashDispenser() *CashDispenser {
	return &CashDispenser{
		count: initialCount,
	}

}

func (c *CashDispenser) DispenseCash(amount int) {
	billsRequired := amount / 20
	c.count -= billsRequired
}

func (c *CashDispenser) IsSufficientCashAvailable(amount int) bool {
	billsRequired := amount / 20
	if c.count >= billsRequired {
		return true
	}
	return false
}
