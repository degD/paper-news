package dege.papernews;

public class Corporation extends Subscriber {

	public String bankName;
	public int bankCode;
	public int issueDay, issueMonth, issueYear;
	public int accountNumber;

	public Corporation(String name, String address) {
		super(name, address);
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}

	public void setIssueDate(int issueDay, int issueMonth, int issueYear) {
		this.issueDay = issueDay;
		this.issueMonth = issueMonth;
		this.issueYear = issueYear;
	}

	public String getIssueDate() {
		return String.format("%d/%d/%d", issueDay, issueMonth, issueYear);
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String getBillingInformation() {
		return "Bank Name: " + bankName + "\nBank Code: " + bankCode + "\nIssue Date: " + getIssueDate()
				+ "\nAccount Number: " + accountNumber;
	}
}
