package coreservlets.client;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = -7897351931538888170L;

	private int id;
	private String firstName;
	private String lastName;
	private double balance;

	/**
	 * Required for serialization.
	 */
	public Customer() {
	}

	public Customer(int id, String firstName, String lastName, double balance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder customer = new StringBuilder();
		customer.append(firstName).append(" ").append(lastName);
		customer.append(" has ").append((int) balance)
				.append(" bucks in the bank.");
		return customer.toString();
	}
}
