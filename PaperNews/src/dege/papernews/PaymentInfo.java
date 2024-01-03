package dege.papernews;

public class PaymentInfo {

	private final double discountRatio;
	private double receivedPayment;

	public PaymentInfo(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	public double getDiscountRatio() {
		return discountRatio;
	}
	
	public void increasePayment(double amount) {
		receivedPayment += amount;
	}
	
	public double getReceivedPayment() {
		return receivedPayment;
	}

	@Override
	public String toString() {
		return "PaymentInfo [discountRatio=" + discountRatio + ", receivedPayment=" + receivedPayment + "]";
	}
}
