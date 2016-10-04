package bank.model;

public class Account {
	public static final String DEPOSIT = "입금";
	public static final String WITHDRAW = "출금";
	private String account_no;
	private String name;
	private int balance = 0;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String account_no,String name) {
		this.account_no = account_no;
		this.name = name;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int valance) {
		this.balance = valance;
	}

	public static String getDeposit() {
		return DEPOSIT;
	}

	public static String getWithdraw() {
		return WITHDRAW;
	}
	

}
