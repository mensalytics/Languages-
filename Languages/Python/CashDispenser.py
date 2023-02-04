class CashDispenser: 
    INITIAL_COUNT = 2000 


    def __init__(self): 
        self.count = self.INITIAL_COUNT 

    def dispenseCash(self, amount): 
        billsRequired = amount // 20 
        self.count -= billsRequired 

    def isSufficientCashAvailable(self, amount):
        billsRequired = amount // 20 
        if self.count >= billsRequired: 
            return True 
        else: 
            return False 