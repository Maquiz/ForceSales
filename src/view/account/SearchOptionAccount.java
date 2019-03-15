package view.account;


import consoleKit.Holder;
import consoleKit.MenuItem;
import data.account.Account;
import data.account.AccountArray;

abstract class SearchOptionAccount implements MenuItem {
	
	private Holder<AccountArray> holder;
	private AccountArray account_array;
	private String name;
	
	public SearchOptionAccount(String name, Holder<AccountArray> holder, AccountArray account_array) {
		this.holder = holder;
		this.account_array = account_array;
		this.name = name;
	}
	
	@Override
	abstract public void execute();
	
	@Override
	public String toString() {
		return name;
	}

	protected Holder<AccountArray> getHolder() {
		return holder;
	}
	
	protected AccountArray getAccountArray() {
		return account_array;
	}
	
	protected void printResult() {
		if (holder.get() != null) {
			System.out.println("Here are the results:");
			
			for (Account i: holder.get()) {
				System.out.println(i);
			}
		}
		
		else {
			System.out.println("I didn't get anything");
		}
	}
}
