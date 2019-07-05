package app.future.commons.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分页返回数据
 * @version: 1.0
 * @modify:
 */
public class PageData<T> implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 总行数
     */
    private long total;

    /**
     * 数据集合
     */
    private List<T> rows;

    /**
     * 当前页
     */
    private int currPage = 0;

    /**
     * 每页显示记录数
     */
    private int pageSize = 10;

    /**
     * 总页数
     */
    private int totalPages = 0;

    /** 页面显示页标签数 */
    private List<Integer> pageNumList;

    public List<Integer> getPageNumList() {
        return pageNumList;
    }

    public void setPageNumList(List<Integer> pageNumList) {
        this.pageNumList = pageNumList;
    }

    public PageData() {
    }

    public PageData(Long total, List<T> rows) {
        super();
        if (total == null) {
            total = 0L;
        }
        this.total = total;
        this.rows = rows;
    }

    /**
     * 将列表数据和统计数据放入map中返回
     * @param total2
     * @param list
     * @return
     */
    public static <T> PageData<T> setData(Long total, List<T> list) {
        PageData<T> data = new PageData<T>();
        if (total == null) {
            total = 0L;
        }
        data.setTotal(total);
        data.setRows(list);
        return data;
    }

    /**
     * @param pageNum 当前页
     * @param totalPage 总页数
     * @return
     */
    public static List<Integer> getPageNumList(int pageNum, int totalPage) {
        // 页面显示页标签数
        int size = 5;
        List<Integer> pageNumList = null;
        if (pageNum > 0 && pageNum <= totalPage && size > 0) {
            int startNum = 1;
            if (pageNum > size / 2) {
                startNum = pageNum - size / 2;
            }
            int endNum = startNum + size - 1;
            if (endNum > totalPage) {
                endNum = totalPage;
                startNum = totalPage - size + 1;
                if (startNum < 1) {
                    startNum = 1;
                }
            }
            pageNumList = new ArrayList<Integer>();
            for (int i = startNum; i <= endNum; i++) {
                pageNumList.add(i);
            }
        }
        return pageNumList;
    }

    /**
     * 根据分页条件截取集合数据
     * @param model
     * @param resultList
     * @return
     */
    public static <T> PageData<T> setDataByPageCutList(PageModel model, List<T> resultList) {
        PageData<T> result = null;
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
            result = setData((long) totalRows, resultList);
        }
        return result;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> list) {
        this.rows = list;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        if (currPage > 0) {
            // 绝对值
            totalPages = Math.round(total % pageSize == 0 ? total / pageSize : total / pageSize);
            setTotalPages(currPage);
        }
        this.currPage = currPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
