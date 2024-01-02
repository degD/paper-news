package dege.papernews;

public class Individual extends Subscriber {

	private String creditCardNr;
	private int expireMonth, expireYear;
	private int CVV;
	
	public Individual(String name, String address) {
		super(name, address);
	}

	public void setCreditCardNr(String creditCardNr) {
		this.creditCardNr = creditCardNr;
	}

	public void setExpireMonth(int expireMonth) {
		this.expireMonth = expireMonth;
	}
	
	public void setExpireDate(int expireMonth, int expireYear) {
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
	}

	public void setCVV(int CVV) {
		this.CVV = CVV;
	}

	@Override
	public String getBillingInformation() {
		return "Credit card number: " + creditCardNr + "\n" + "Expire date: " + expireMonth + "/" + expireYear + "\n" + "CVV: " + CVV;
	}

	@Override
	public String toString() {
		return "Individual [creditCardNr=" + creditCardNr + ", expireMonth=" + expireMonth + ", expireYear="
				+ expireYear + ", CVV=" + CVV + ", name=" + name + ", address=" + address + "]";
	}
}
