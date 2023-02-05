class Account: 
    # WHAT IS THE DIFFERENCE BETWEEN THIS INIT & __INIT__ ? 
    # WHAT DOES SELF MEAN IN PYTHON ?? 
    def init(self, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance): 
        self.accountNumber = theAccountNumber 
        self.pin = thePIN 
        self.availableBalance = theAvailableBalance 
        self.totalBalance = theTotalBalance

    def validatePIN(self, userPIN):
        if userPIN == self.pin:
            return True 
        else: 
            return False 
        
    # get available balance 
    def getAvailableBalance(self):
        return self.availableBalance
    
    # get total balance
    def getTotalBalance(self):
        return self.totalBalance
    
    # credit an amount to the account 
    def credit(self, amount): 
        self.totalBalance += amount 

    # debit an amount from the account
    def debit(self, amount):
        self.availableBalance -= amount 
        self.totalBalance -= amount 

    def get_account_number(self):
        return self.accountNumber 

    