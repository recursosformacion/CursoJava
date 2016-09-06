package es.rf.gwtrpcinicio.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import es.rf.gwtrpcinicio.shared.RandomNumber;

public interface DataServiceAsync {

	void getButton1Data(AsyncCallback<String> callback);

	void getButton2Data(AsyncCallback<String[]> callback);

	void getButton3Data(String range, AsyncCallback<RandomNumber> callback);

	void logClientRandom(RandomNumber clientRandom, AsyncCallback<Void> callback);

}
