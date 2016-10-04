package bank.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class BankDao extends NamedParameterJdbcDaoSupport implements BankDaoInter {
	private static final String SQL_DEPOSIT = "UPDATE account SET balance = balance + :money WHERE account_no = :account_no";
	private static final String SQL_WITHDRAW = "UPDATE account SET balance = balance - :money WHERE account_no = :account_no";
	private static final String SQL_INSERT_ACCOUNT = "INSERT INTO account(account_no,name,balance) VALUES(:account_no,:name,:balance)";
	private static final String SQL_FIND_ACCOUNT_BY_NO = "SELECT account_no,name,balance FROM account WHERE account_no = :account_no";
	private static final String SQL_FIND_ACCOUNT_BY_NAME = "SELECT account_no,name,balance FROM account WHERE name = :name";
	private static final String SQL_ALL_ACCOUNT = "SELECT account_no,name,balance FROM account ORDER BY account_no DESC";

	@Override
	public void addAccount(Account account) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account_no", account.getAccount_no());
		params.put("name", account.getName());
		params.put("balance", account.getBalance());
		
		getNamedParameterJdbcTemplate().update(SQL_INSERT_ACCOUNT, params);
	}
	
	@Override
	public Account findAccount(String account_no) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account_no", account_no);
		
		try {
			
			return getNamedParameterJdbcTemplate().queryForObject(
					SQL_FIND_ACCOUNT_BY_NO, params, 
					new ParameterizedRowMapper<Account>() {
						@Override
						public Account mapRow(ResultSet rs, int arg1)
								throws SQLException {
							Account account = new Account();
							account.setAccount_no(rs.getString("account_no"));
							account.setName(rs.getString("name"));
							account.setBalance(rs.getInt("balance"));
							return account;
						}
					});
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Account> findAccountByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		RowMapper<Account> rowMapper = new AccountRowMapper();
		return getNamedParameterJdbcTemplate().query(SQL_FIND_ACCOUNT_BY_NAME,
				params, rowMapper);
	}

	//내부 클래스
	class AccountRowMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			String account_no = rs.getString("account_no");
			String name = rs.getString("name");
			int balance = rs.getInt("balance");

			Account account = new Account();
			account.setAccount_no(account_no);
			account.setName(name);
			account.setBalance(balance);

			return account;
		}
	}
	
	@Override
	public List<Account> getAccounts() {
		RowMapper<Account> rowMapper = new AccountRowMapper();
		return getJdbcTemplate().query(SQL_ALL_ACCOUNT, rowMapper);
	}

	@Override
	public void deposit(Account account, int money) {
		if (money <= 0) {
			throw new SibalException("금액이 마이너스입니다.");
		}
		 Map<String, Object> params = new HashMap<String, Object>();
		params.put("money", money);
		params.put("account_no", account.getAccount_no());
		getNamedParameterJdbcTemplate().update(SQL_DEPOSIT, params);
	}
  
	@Override
	public void withdraw(Account account, int money){
		if (money > account.getBalance()) {
			throw new SibalException("잔고가 부족합니다.");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("money", money);
		params.put("account_no", account.getAccount_no());
		getNamedParameterJdbcTemplate().update(SQL_WITHDRAW, params);
	}

	@Override
	public void transfer(Account from, Account to, int money){
		withdraw(from, money);
		deposit(to, money);
	}
}
