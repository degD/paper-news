package dege.papernews;

public class Subscription {

	private final DateInfo dates;
	private PaymentInfo payment;
	private int copies;
	private final Journal journal;
	private final Subscriber subscriber;

	public Subscription(DateInfo dates, int copies, Journal journal, Subscriber subscriber) {
		this.dates = dates;
		this.copies = copies;
		this.journal = journal;
		this.subscriber = subscriber;
		
		double discount = calculateDiscountRatio();
		this.payment = new PaymentInfo(discount);
	}
	
	public Subscriber getSubscriber() {
		return subscriber;
	}
	
	private double calculateDiscountRatio() {
		if (copies > 20)
			return 20.0;
		else if (20 >= copies && copies > 10)
			return 10.0;
		else if (10 >= copies && copies > 5)
			return 5.0;
		return 0.0;
	}
	
	public void acceptPayment(double amount) {
		payment.increasePayment(amount);
	}
	
	public boolean canSend(int issueMonth) {
		double monthlyPrice = (journal.getIssuePrice() * journal.getFrequency()) / 12;
		if (payment.getReceivedPayment() >= (issueMonth * monthlyPrice))
			return true;
		return false;
	}
	
	public boolean isSubscribed(int month, int year) {
		int endDateNr = dates.getEndMonth() + (dates.getEndYear() - dates.getStartYear()) * 12;
		int currentDateNr = month + (year - dates.getStartYear()) * 12;
		if (endDateNr >= currentDateNr)
			return true;
		return false;
	}
}
