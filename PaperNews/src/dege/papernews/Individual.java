package dege.papernews;

public class Individual extends Subscriber {

	private String creditCardNr;
	private int expireMonth, expireYear;
	private int CCV;
	
	public Individual(String name, String address) {
		super(name, address);
	}

	public String getCreditCardNr() {
		return creditCardNr;
	}

	public void setCreditCardNr(String creditCardNr) {
		this.creditCardNr = creditCardNr;
	}

	public int getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(int expireMonth) {
		this.expireMonth = expireMonth;
	}

	public int getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(int expireYear) {
		this.expireYear = expireYear;
	}

	public int getCCV() {
		return CCV;
	}

	public void setCCV(int cCV) {
		CCV = cCV;
	}

	@Override
	public String getBillingInformation() {
		String billingInfo = "Induvidual\n";
		billingInfo += creditCardNr;
		
	}
	
	
	
}
