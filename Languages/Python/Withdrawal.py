import Transaction
# Inheriting from Transaction class
class Withdrawal(Transaction): 
    def __init__(self, userAccountNumber, atmScreen, atmBankDatabase, atmKeypad, atmCashDispenser):
        super().__init__(userAccountNumber, atmScreen, atmBankDatabase)
        self.amount = 0
        self.keypad = atmKeypad
        self.cashDispenser = atmCashDispenser
        self.CANCELED = 6

    def execute(self):
        cashDispensed = False
        availableBalance = 0

        bankDatabase = self.getBankDatabase()
        screen = self.getScreen()

        while not cashDispensed:
            self.amount = self.display_menu_of_amounts()

            if self.amount != self.CANCELED:
                availableBalance = bankDatabase.get_available_balance(self.get_account_number())

                if self.amount <= availableBalance:
                    if self.cashDispenser.is_sufficient_cash_available(self.amount):
                        bankDatabase.debit(self.get_account_number(), self.amount)
                        self.cashDispenser.dispense_cash(self.amount)
                        cashDispensed = True
                        screen.display_message_line("\nYour cash has been dispensed. Please take your cash now.")
                    else:
                        screen.display_message_line("\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount.")
                else:
                    screen.display_message_line("\nInsufficient funds in your account." + "\n\nPlease choose a smaller amount.")
            else:
                screen.display_message_line("\nCanceling transaction...")
                return

    def display_menu_of_amounts(self):
        userChoice = 0
        screen = self.getScreen()

        amounts = [0, 20, 40, 60, 100, 200]

        while userChoice == 0:
            screen.display_message_line("\nWithdrawal Menu: ")
            screen.display_message_line("1 - $20")
            screen.display_message_line("2 - $40")
            screen.display_message_line("3 - $60")
            screen.display_message_line("4 - $100")
            screen.display_message_line("5 - $200")
            screen.display_message_line("6 - Cancel transaction")
            screen.display_message("\nChoose a withdrawal amount: ")

            input = self.keypad.get_input()

            if input in [1, 2, 3, 4, 5, 6]:
                userChoice = amounts[input]
            else:
                screen.display_message_line("\nInvalid selection. Try again.")

        return userChoice

