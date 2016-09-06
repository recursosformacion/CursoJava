package coreservlets.server;

import java.util.*;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import coreservlets.client.BankService;
import coreservlets.client.Customer;

public class BankServiceImpl extends RemoteServiceServlet implements BankService {
  // The first two methods aren't really "Bank" service methods, but are
  // for warmup with the use of RPC.
  
  @Override
  public String flipCoin() {
    if (Math.random() < 0.5) {
      return("Heads");
    } else {
      return("Tails");
    }
  }
  
  @Override
  public String[] flipCoins(int  n) {
    String[] coins = new String[n];
    for(int i=0; i<coins.length; i++) {
      coins[i] = flipCoin();
    }
    return(coins);
  }
  
	private static List<Customer> customerList;
	
	static {
		customerList = new ArrayList<Customer>();
		customerList.add(new Customer(1, "Richey", "Rich", 1000000));
		customerList.add(new Customer(2, "Still", "Rich", 100000));
		customerList.add(new Customer(3, "Regular", "Joe", 10000));
		customerList.add(new Customer(4, "Just", "Makingit", 1000));
		customerList.add(new Customer(5, "Barely", "Makingit", 100));
		customerList.add(new Customer(6, "Dirt", "Poor", 10));
	}

	@Override
	public Customer getRichestCustomer() {
		Customer richest = customerList.get(0);
		for (int i = 1; i < customerList.size(); i++) {
			Customer current = customerList.get(i);
			if (richest.getBalance() < current.getBalance()) {
				richest = current;
			}
		}
		return(richest);
	}

	@Override
	public Customer getPoorestCustomer() {
		Customer poorest = customerList.get(0);
		for (int i = 1; i < customerList.size(); i++) {
			Customer current = customerList.get(i);
			if (poorest.getBalance() > current.getBalance()) {
				poorest = current;
			}
		}
		return(poorest);
	}

	@Override
	public List<Customer> redistribute(int custId1, int custId2) {
		Customer cust1 = getCustomerById(custId1);
		Customer cust2 = getCustomerById(custId2);

		// Find average balance
		double averageBal = (cust1.getBalance() + cust2.getBalance()) / 2;

		// Update happy customers!
		cust1.setBalance(averageBal);
		cust2.setBalance(averageBal);
		updateCustFirstName(cust1);
		updateCustFirstName(cust2);

		List<Customer> luckyGuys = new ArrayList<Customer>();
		luckyGuys.add(cust1);
		luckyGuys.add(cust2);

		return(luckyGuys);
	}

	private void updateCustFirstName(Customer customer) {
		String currentFirst = customer.getFirstName();
		if (currentFirst.indexOf("NOT") == -1) {
			customer.setFirstName("NOT " + currentFirst);
		}
	}

	private Customer getCustomerById(int id) {
		for (Customer customer : customerList) {
			if (customer.getId() == id) {
				return(customer);
			}
		}
		return(null);
	}
}
