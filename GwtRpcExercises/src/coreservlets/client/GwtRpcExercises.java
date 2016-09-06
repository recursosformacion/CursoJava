package coreservlets.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class GwtRpcExercises implements EntryPoint {
	private Customer richest;
	private Customer poorest;
	private BankServiceAsync bankServiceProxy;
	private HTML coinResult, multipleCoinResult;

	@Override
  public void onModuleLoad() {
		bankServiceProxy = GWT.create(BankService.class);
		
		FlowPanel coinPanel = new FlowPanel();
		Button getCoinButton = new Button("Flip Coin");
		getCoinButton.addClickHandler(new CoinButtonHandler());
		coinResult = new HTML("");
		coinPanel.add(getCoinButton);
		coinPanel.add(coinResult);
		RootPanel.get("get-coin").add(coinPanel);
		
		FlowPanel multipleCoinPanel = new FlowPanel();
    Button getMultipleCoinsButton = new Button("Flip Multiple Coins");
    getMultipleCoinsButton.addClickHandler(new MultipleCoinButtonHandler());
    multipleCoinResult = new HTML("");
    multipleCoinPanel.add(getMultipleCoinsButton);
    multipleCoinPanel.add(multipleCoinResult);
    RootPanel.get("get-multiple-coins").add(multipleCoinPanel);
		
		FlowPanel richestPanel = new FlowPanel();
		Button getRichestButton = new Button("Display Richest Customer");
		final HTML richCustomerInfo = new HTML("");
		richestPanel.add(getRichestButton);
		richestPanel.add(richCustomerInfo);

		getRichestButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				bankServiceProxy.getRichestCustomer(new AsyncCallback<Customer>() {
					@Override
					public void onSuccess(Customer result) {
						richest = result;
						richCustomerInfo.setHTML("<b>" + result.toString() + "</b>");
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Failed to retrieve richest customer!");
					}
				});
			}
		});

		RootPanel.get("get-richest").add(richestPanel);

		FlowPanel poorestPanel = new FlowPanel();
		Button getPoorestButton = new Button("Display Poorest Customer");
		final HTML poorCustomerInfo = new HTML("");
		poorestPanel.add(getPoorestButton);
		poorestPanel.add(poorCustomerInfo);

		getPoorestButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				bankServiceProxy.getPoorestCustomer(new AsyncCallback<Customer>() {
					@Override
					public void onSuccess(Customer result) {
						poorest = result;
						poorCustomerInfo.setHTML("<b>" + result.toString() + "</b>");
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Failed to retrieve poorest customer!");
					}
				});
			}
		});

		RootPanel.get("get-poorest").add(poorestPanel);

		FlowPanel redistributePanel = new FlowPanel();
		Button redistributeButton = new Button("Redistribute!");
		final HTML redistributeInfo = new HTML("");
		redistributePanel.add(redistributeButton);
		redistributePanel.add(redistributeInfo);

		redistributeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (richest == null || poorest == null) {
					Window.alert("First get richest and poorest!");
					return;
				}
				bankServiceProxy.redistribute(richest.getId(), poorest.getId(),
						new AsyncCallback<List<Customer>>() {
							@Override
							public void onSuccess(List<Customer> result) {
								StringBuilder info = new StringBuilder();
								info.append("The LUCKY guys are: ").append(result.get(0).toString());
								info.append(" and ").append(result.get(1).toString());
								redistributeInfo.setHTML("<b>" + info.toString() + "</b>");
							}
							
	            @Override
	            public void onFailure(Throwable caught) {
	               Window.alert("Ahhh! Couldn't redistribute!");
	            }
						});
			}
		});

		RootPanel.get("redistribute").add(redistributePanel);
	}
	
	private class CoinButtonHandler implements ClickHandler {
    @Override
    public void onClick(ClickEvent event) {
      bankServiceProxy.flipCoin(new CoinCallbackHandler());
    }
	}
	
	private class CoinCallbackHandler implements AsyncCallback<String> {
    @Override
    public void onSuccess(String result) {
      coinResult.setHTML("Result is <b>" + result + "</b>!");
    }
    
    @Override
    public void onFailure(Throwable caught) {
      Window.alert("Unable to get coin flip from server");
    }
	}
	
  private class MultipleCoinButtonHandler implements ClickHandler {
    @Override
    public void onClick(ClickEvent event) {
      bankServiceProxy.flipCoins(5, new MultipleCoinCallbackHandler());
    }
  }
  
  private class MultipleCoinCallbackHandler implements AsyncCallback<String[]> {
    @Override
    public void onSuccess(String[] result) {
      multipleCoinResult.setHTML(buildUlList(result));
    }
    
    @Override
    public void onFailure(Throwable caught) {
      Window.alert("Unable to get coin flips from server");
    }
  }
  
  private String buildUlList(String[] items) {
    String result = "<ul>";
    for(String item: items) {
      result += "<li>" + item + "</li>";
    }
    result += "</ul>";
    return(result);
  }
  
}
