from Languages.Python.Account import Account


class BankDatabase: 
    def __init__(self):
        self.accounts = [
            Account(12345, 54321, 1000.0, 1200.0),
            Account(98765, 56789, 200.0, 200.0)
        ]

    # method to get account object based on account number 
    # def method name with self and accountNumber as arguments 
    # for loop to iterate through accounts object 
    # if account object calls getaccountnumber method and matches with account number 
    # return account object, else return None 
    def getAccount(self, accountNumber):
        for account in self.accounts: 
            if account.get_account_number() == accountNumber: 
                return account 
        return None 
    
    # method to authenticate user with arguments self, user_account_number and user_pin 
    # self.call getAccount method with user_account_number as argument and assign to user_account object 
    # if user_account object 
    # return user_account object calling validatePin method with user_pin as argument 
    # else return false 
    def authenticateUser(self, user_account_number, user_pin): 
        user_account = self.getAccount(user_account_number) 
        if user_account:
            return user_account.validatePIN(user_pin)
        else: 
            return False 
        
    # method to get available balance 
    def get_available_balance(self, user_account_number):
        return self.getAccount(user_account_number).getAvailableBalance() 

    # method to get total balance 
    def get_total_balance(self, user_account_number):
        return self.getAccount(user_account_number).getTotalBalance()

    # method to credit an amoun to account 
    def credit(self, user_account_number, amount):
        self.getAccount(user_account_number).credit(amount) 

    # method to debit an amount from account 
    def debit(self, user_account_number, amount):
        self.getAccount(user_account_number).debit(amount) 