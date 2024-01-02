package dege.papernews;

import java.util.Vector;

public class Journal {
	
	private final String name, issn;
	private final int frequency;
	private final double issuePrice;
	private Vector<Subscription> subscriptions; 
	
	public Journal(String name, String issn, int frequency, double issuePrice) {
		this.name = name;
		this.issn = issn;
		this.frequency = frequency;
		this.issuePrice = issuePrice;
	}
	
	public void addSubscription(Subscription aSubscriber) {
		subscriptions.add(aSubscriber);
	}

	public String getName() {
		return name;
	}

	public String getIssn() {
		return issn;
	}

	public int getFrequency() {
		return frequency;
	}

	public double getIssuePrice() {
		return issuePrice;
	}

	public Vector<Subscription> getSubscriptions() {
		return subscriptions;
	}
}
