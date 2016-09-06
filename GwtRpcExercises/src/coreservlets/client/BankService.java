package coreservlets.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("bank-service")
public interface BankService extends RemoteService {
  public String flipCoin();
  public String[] flipCoins(int n);
	public Customer getRichestCustomer();
	public Customer getPoorestCustomer();
	public List<Customer> redistribute(int custId1, int custId2);
}
