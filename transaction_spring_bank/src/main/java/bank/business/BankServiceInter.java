package bank.business;
import java.util.List;
import bank.model.Account;

public interface BankServiceInter {
	void addAccount(Account account);
    Account findAccount(String account_no);
    List<Account> findAccountByName(String name);
    List<Account> getAccounts();
    void deposit(Account account, int money);
    void withdraw(Account account, int money);
    void transfer(Account from, Account to, int money);
}