package dege.papernews;

import java.util.Hashtable;
import java.util.Vector;

public class Distributor {

	private final Hashtable<String, Journal> journals = new Hashtable<String, Journal>();
	private final Vector<Subscriber> subscribers = new Vector<Subscriber>();
	
	public boolean addJournal(Journal aJournal) {
		if (aJournal == null)
			return false;
		journals.put(aJournal.getIssn(), aJournal);
		return true;
	}
	
	public Journal searchJournal(String issn) {
		return journals.get(issn);
	}
	
	public boolean addSubscriber(Subscriber aSubscriber) {
		if (aSubscriber == null)
			return false;
		subscribers.add(aSubscriber);
		return true;
	}
	
	public Subscriber searchSubscriber(String name) {
		for (Subscriber aSubscriber : subscribers) {
			if (aSubscriber.getName() == name)
				return aSubscriber;
		}
		return null;
	}
	
	public boolean addSubscription(String issn, Subscriber aSubscriber, Subscription aSubscription) {
		return false;
	}
	
	public void listAllSendingOrders(int month, int year) {
		for (String issn : journals.keySet()) {
			listSendingOrders(issn, month, year);
		}
	}
	
	public void listSendingOrders(String issn, int month, int year) {
		Journal aJournal = searchJournal(issn);
		System.out.println(aJournal);
		
		for (Subscription aSubscription : aJournal.getSubscriptions()) {
			if (aSubscription.isSubscribed(month, year) && aSubscription.canSend(month)) {
				System.out.println(aSubscription.getSubscriber());
			}
		}
	}
	
	private Vector<Subscription> getAllSubscriptions() {
		Vector<Subscription> subscriptions = new Vector<Subscription>();
		for (String issn : journals.keySet()) {
			subscriptions.addAll(searchJournal(issn).getSubscriptions());
		}
		return subscriptions;
	}
	
	public void listIncompletePayments() {
		for (Subscription aSubscription : getAllSubscriptions()) {
			if (!aSubscription.isPaymentComplete()) {
				System.out.println(aSubscription);
			}
		}
	}
	
	public void listSubscriberSubscriptions(String SubscriberName) {
		Subscriber aSubscriber = searchSubscriber(SubscriberName);
		System.out.println(aSubscriber);
		
		for (Subscription aSubscription : getAllSubscriptions()) {
			if (aSubscriber == aSubscription.getSubscriber())
				System.out.println(aSubscription);
		}
	}
	
	public void listIssnSubscriptions(String issn) {
		Journal aJournal = searchJournal(issn);
		for (Subscription aSubscription : aJournal.getSubscriptions()) {
			System.out.println(aSubscription);
		}
	}
}
