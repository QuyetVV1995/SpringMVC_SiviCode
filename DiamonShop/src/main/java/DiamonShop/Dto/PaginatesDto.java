package DiamonShop.Dto;

public class PaginatesDto {
	private int currentPage;
	private int limit;
	private int start, end;
	private int totalPage;
	
	

	public int getCurrentPage() {
		return currentPage;
	}
	public PaginatesDto() {
		super();
		
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
