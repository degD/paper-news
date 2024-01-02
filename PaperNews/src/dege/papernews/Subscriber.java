package dege.papernews;

public abstract class Subscriber {
	
	protected String name;
	protected String address;

	public Subscriber(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	// toString
	@Override
	public String toString() {
		return "Subscriber [name=" + name + ", address=" + address + "]";
	}

	public abstract String getBillingInformation();
}
