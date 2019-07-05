package app.future.commons.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 页面对象，用于处理分页、日期区间查询、特殊查询条件等
 * @version: 1.0
 * @modify:
 */
public class PageModel implements java.io.Serializable {

    private static final long serialVersionUID = 7232798260610351343L;

    private static Logger logger = LoggerFactory.getLogger(PageModel.class);

    /**
     * 当前页,名字必须为page
     */
    private int page;

    /**
     * 每页大小,名字必须为rows
     */
    private int rows = 10;

    /** 是否分页,true表示分页 */
    public boolean isPagination = true;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 开始行
     */
    private int startRow;

    /**
     * 总行数
     */
    private int total;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 截止时间
     */
    private Date endDate;

    private Object data;

    /**排序字段集合 */
    private Map<String, Object> orderBy;

    // 排序字段 单列排序
    private String order;
    
	/**
	 * 页面列表标识
	 */
	public static final String PAGE_ROWS = "rows";

	/**
	 * 页面记录总数标识
	 */
	public static final String PAGE_TOTAL = "total";
	/**
	 * 表格页角标识
	 */
	public static final String PAGE_FOOTER = "footer";

    public PageModel() {

    }

    /**
     * 构造函数
     * @param page 当前页
     * @param rows 每页大小
     */
    public PageModel(int page, int rows) {
        super();
        this.page = page;
        setRows(rows);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartRow() {
        // 从1页开始
        startRow = page <= 0 ? 0 : (page - 1) * rows;
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    @Override
    public String toString() {
        return "PageModel [page=" + page + ", rows=" + rows + ", sort=" + sort + ", startRow=" + startRow
                + ", total=" + total + ", startDate=" + startDate + ", endDate=" + endDate + ", data=" + data
                + ", orderBy=" + orderBy + ", order=" + order + "]";
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    /**
     * 将列表数据和统计数据放入map中返回
     * @param total
     * @param list
     * @return
     */
    public static Map<String, Object> putGridMap(Long total, List<?>... list) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(PAGE_TOTAL, total);
        int len = 0;
        if (list != null) {
            len = list.length;
        }
        map.put(PAGE_ROWS, len > 0 ? list[0] : null);
        map.put(PAGE_FOOTER, len > 1 ? list[1] : null);
        return map;
    }

    /**
     * 根据分页条件截取集合数据
     * @param model
     * @param resultList
     * @return
     */
    public static Map<String, Object> putGridByPageCutList(PageModel model, List<?> resultList) {
        Map<String, Object> result = null;
        if (model != null && resultList != null && !resultList.isEmpty()) {
            int totalRows = resultList.size();
            int startRow = model.getStartRow();
            int endRow = model.getRows() + startRow;
            if (startRow > totalRows) {
                startRow = 0;
                endRow = 0;
            } else if (startRow < totalRows && endRow > totalRows) {
                endRow = totalRows;
            }
            resultList = resultList.subList(startRow, endRow);
            result = PageModel.putGridMap((long) totalRows, resultList);
        }
        return result;
    }

    public <T> PageData<T> setPageData(Long total, List<T> list) {
        PageData<T> pageData = new PageData<T>(total, list);
        pageData.setCurrPage(page);
        pageData.setPageSize(rows);
        return pageData;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setQueryEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Map<String, Object> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Map<String, Object> orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows > 1000) {
            logger.error("每页查询记录不能大于1000!");
            rows = 1 / 0;
        }
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isPagination() {
        return isPagination;
    }

    public void setPagination(boolean isPagination) {
        this.isPagination = isPagination;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new PageModel(5, 101));
    }
}
