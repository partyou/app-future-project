package app.future.commons.bean;


import app.future.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻类别表
 */
public class NewsType implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1L;
	
    private PageModel model;//分页用
	private Long newsTypeId; // 新闻类别ID 
	private String newsTypeName; // 新闻类别名称 
	private String newsTypeDesc; // 新闻类别说明 
	private String recStatus; // 状态(1:有效 2:无效) 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间 
	private Date modifyTime; // 修改时间 
	/**
     * 新闻类别ID 
     */
    public Long getNewsTypeId() {
        return newsTypeId;
    }
    /**
     * 新闻类别ID 
     */
    public void setNewsTypeId(Long newsTypeId) {
        this.newsTypeId = newsTypeId;
    }
	/**
     * 新闻类别名称 
     */
    public String getNewsTypeName() {
        return newsTypeName;
    }
    /**
     * 新闻类别名称 
     */
    public void setNewsTypeName(String newsTypeName) {
        this.newsTypeName = newsTypeName;
    }
	/**
     * 新闻类别说明 
     */
    public String getNewsTypeDesc() {
        return newsTypeDesc;
    }
    /**
     * 新闻类别说明 
     */
    public void setNewsTypeDesc(String newsTypeDesc) {
        this.newsTypeDesc = newsTypeDesc;
    }
	/**
     * 状态(1:有效 2:无效) 
     */
    public String getRecStatus() {
        return recStatus;
    }
    /**
     * 状态(1:有效 2:无效) 
     */
    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }
	/**
     * 备注 
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 备注 
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
	/**
     * 保留字段 
     */
    public String getRes1() {
        return res1;
    }
    /**
     * 保留字段 
     */
    public void setRes1(String res1) {
        this.res1 = res1;
    }
	/**
     * 创建时间 
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 创建时间 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	/**
     * 修改时间 
     */
    public Date getModifyTime() {
        return modifyTime;
    }
    /**
     * 修改时间 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    public PageModel getModel() {
        return model;
    }
    public void setModel(PageModel model) {
        this.model = model;
    }


}