package javaweb.model;

import java.util.ArrayList;
import java.util.List;

public class News {
	private int id;
	private String title;
	private String code;
	private List<News> listResult = new ArrayList<News>();
	private Integer page;
	private Integer maxPageItem;
	private int totalpage;
	private Integer totalItem;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<News> getListResult() {
		return listResult;
	}
	public void setListResult(List<News> listResult) {
		this.listResult = listResult;
	}
}
