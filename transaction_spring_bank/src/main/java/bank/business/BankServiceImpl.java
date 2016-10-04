package bank.business;

import java.util.List;

import bank.model.Account;
import bank.model.BankDaoInter;

public class BankServiceImpl implements BankServiceInter{
	private BankDaoInter bankDaoInter;
	
	public void setBankDaoInter(BankDaoInter bankDaoInter) {
		this.bankDaoInter = bankDaoInter;
	}
	
	@Override
	public void addAccount(Account account) {
		bankDaoInter.addAccount(account);		
	}
	@Override
	public Account findAccount(String account_no) {
		return bankDaoInter.findAccount(account_no);
	}
	@Override
	public List<Account> findAccountByName(String name) {
		return bankDaoInter.findAccountByName(name);
	}
	@Override
	public List<Account> getAccounts() {
		return bankDaoInter.getAccounts();
	}
	@Override
	public void deposit(Account account, int money){
		bankDaoInter.deposit(account, money);		
	}
	@Override
	public void withdraw(Account account, int money){
		try {
			bankDaoInter.withdraw(account, money);
		} catch (Exception e) {
			System.out.println("withdraw err:" + e);
		}
	}
	@Override
	public void transfer(Account from, Account to, int money){
		try {
			bankDaoInter.transfer(from, to, money);	
		} catch (Exception e) {
			System.out.println("withdraw err:" + e);
		}
	}
}