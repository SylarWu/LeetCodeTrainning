package tech.sylardaemon;

public class Solution2043 {
    class Bank {
        private long[] accountBalance;

        public Bank(long[] balance) {
            this.accountBalance = balance;
        }

        private boolean isAccount(int account){
            return account >= 1 && account <= this.accountBalance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!this.isAccount(account1) || !this.isAccount(account2)  || this.accountBalance[account1 - 1] < money){
                return false;
            }
            this.accountBalance[account1 - 1] -= money;
            this.accountBalance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (!this.isAccount(account)){
                return false;
            }
            this.accountBalance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (!this.isAccount(account) || this.accountBalance[account - 1] < money){
                return false;
            }
            this.accountBalance[account - 1] -= money;
            return true;
        }
    }
}
