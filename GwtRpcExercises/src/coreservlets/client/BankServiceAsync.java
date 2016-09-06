package coreservlets.client;

import java.util.List;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BankServiceAsync {
  void flipCoin(AsyncCallback<String> callback);
  void flipCoins(int n, AsyncCallback<String[]> callback); 
  void getRichestCustomer(AsyncCallback<Customer> callback);
	void getPoorestCustomer(AsyncCallback<Customer> callback);
	void redistribute(int custId1, int custId2, AsyncCallback<List<Customer>> callback);
}
