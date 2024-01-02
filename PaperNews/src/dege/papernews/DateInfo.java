package dege.papernews;

public class DateInfo {
	
	private final int startMonth, startYear;
	private final int endMonth;
	
	public DateInfo(int startMonth, int startYear) {
		// Months are between 0-11 (inclusive) 
		this.startMonth = startMonth;
		this.startYear = startYear;
		this.endMonth = (startMonth + 1) % 12;
	}
	
	public String getStartDate() {
		return String.format("%d/%d", startMonth, startYear);
	}
	
	public String getEndDate() {
		return String.format("%d/%d", endMonth, startYear + 1);
	}

	@Override
	public String toString() {
		return "DateInfo [startMonth=" + startMonth + ", startYear=" + startYear + ", endMonth=" + endMonth + "]";
	}
}
