package dege.papernews;

public class DateInfo {
	
	private final int startMonth, startYear;
	private final int endMonth, endYear;
	
	public DateInfo(int startMonth, int startYear) {
		// Months are between 1-12
		this.startMonth = startMonth;
		this.startYear = startYear;
		
		if (startMonth == 1) {
			this.endMonth = 12;
			this.endYear = startYear;
		}
		else {
			this.endMonth = startMonth - 1;
			this.endYear = startYear + 1;
		}
	}
	
	public String getStartDate() {
		return String.format("%d/%d", startMonth, startYear);
	}
	
	public String getEndDate() {
		return String.format("%d/%d", endMonth, startYear + 1);
	}

	public int getStartMonth() {
		return startMonth;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public int getEndYear() {
		return endYear;
	}

	@Override
	public String toString() {
		return "DateInfo [startMonth=" + startMonth + ", startYear=" + startYear + ", endMonth=" + endMonth + "]";
	}
}
