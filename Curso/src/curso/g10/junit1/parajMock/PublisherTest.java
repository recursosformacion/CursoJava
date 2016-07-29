package parajMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.Expectations;

public class PublisherTest {

	Mockery context = new JUnit4Mockery();

	
	
	@Test
	public void testOneSubscriberReceivesAMessage() {
        // set up
        final Suscriber suscriptor = context.mock(Suscriber.class);
 
        Publisher publisher = new Publisher();
        publisher.add(suscriptor);
         
        final String message = "message";
         
        // expectations
        context.checking(new Expectations() {{
            oneOf (suscriptor).receive(message);
        }});
 
        // execute
        publisher.publish(message);
         
        // verify
        context.assertIsSatisfied();
    }
	
	/**
	 * A Publisher sends a message to a single registered Subscriber.
	 * 
	 */
	@Test
	public void oneSubscriberReceivesAMessage() {

		/*
		 * We first set up the context in which our test will execute. We create
		 * a Publisher to test. We create a mock Subscriber that should receive
		 * the message. We then register the Subscriber with the Publisher.
		 * Finally we create a message object to publish.
		 */

		// set up
		final Suscriber suscriptor = context.mock(Suscriber.class);

		Publisher publisher = new Publisher();
		publisher.add(suscriptor);

		final String message = "message";

		/*
		 * Next we define expectations on the mock Subscriber that specify the
		 * methods that we expect to be called upon it during the test run. We
		 * expect the receive method to be called once with a single argument,
		 * the message that will be sent.
		 */

		// expectations
		context.checking(new Expectations() {
			{
				one(suscriptor).receive(message);
			}
		});

		/*
		 * We then execute the code that we want to test.
		 */
		
		// execute
		publisher.publish(message);
		
		/*
		 * After the code under test has finished our test must verify that the
		 * mock Subscriber was called as expected. If the expected calls were
		 * not made, the test will fail. The MockObjectTestCase does this
		 * automatically. You don't have to explicitly verify the mock objects
		 * in your tests. The JMock test runner does this automatically. You
		 * don't have to explicitly verify the mock objects in your tests.
		 */
		// mockery.assertIsSatisfied();

	}
}