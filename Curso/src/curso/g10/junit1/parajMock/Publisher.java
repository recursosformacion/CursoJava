package parajMock;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
	 private List<Suscriber> suscriptors = new ArrayList<Suscriber>();
     
     void add(Suscriber suscriptor) {
         suscriptors.add(suscriptor);
     }

     void publish(String message) {
         for (Suscriber suscriptor : suscriptors) {
             suscriptor.receive(message);
         }
     }
}
