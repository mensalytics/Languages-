from abc import ABC, abstractmethod # what are these ?? 


# EXPLAIN THIS CODE ?? 
class Transaction(ABC): 
    def __init__(self, user_account_number, screen, bank_database): 
        self.account_number = user_account_number 
        self.screen = screen 
        self.bank_database = bank_database

    @property 
    def account_number(self):
        return self.__account_number 
    
    @account_number.setter 
    def account_number(self, value):
        self.__account_number = value

    @property 
    def screen(self): 
        return self.__screen 
    
    @screen.setter 
    def screen(self, value):
        self.__screen = value

    @property 
    def bank_database(self):
        return self.__bank_database 
    
    @bank_database.setter
    def bank_database(self, value):
        self.__bank_database = value 
    
    @abstractmethod 
    def execute(self):
        pass 
    