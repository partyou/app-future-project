package app.futrue.commons.bean;


import app.futrue.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典表
 */
public class DicItem implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1L;
	
    private PageModel model;//分页用
	private Long id; // 自增长id 
	private String dicItemId; // 字典项id 
	private String dicItemName; // 字典项名称 
	private String dicTypeId; // 字典类型 
	private String dicItemDesc; // 字典描述 
	private String recStatus; // 状态(1:有效 2:无效) 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间 
	private Date modifyTime; // 修改时间 
	/**
     * 自增长id 
     */
    public Long getId() {
        return id;
    }
    /**
     * 自增长id 
     */
    public void setId(Long id) {
        this.id = id;
    }
	/**
     * 字典项id 
     */
    public String getDicItemId() {
        return dicItemId;
    }
    /**
     * 字典项id 
     */
    public void setDicItemId(String dicItemId) {
        this.dicItemId = dicItemId;
    }
	/**
     * 字典项名称 
     */
    public String getDicItemName() {
        return dicItemName;
    }
    /**
     * 字典项名称 
     */
    public void setDicItemName(String dicItemName) {
        this.dicItemName = dicItemName;
    }
	/**
     * 字典类型 
     */
    public String getDicTypeId() {
        return dicTypeId;
    }
    /**
     * 字典类型 
     */
    public void setDicTypeId(String dicTypeId) {
        this.dicTypeId = dicTypeId;
    }
	/**
     * 字典描述 
     */
    public String getDicItemDesc() {
        return dicItemDesc;
    }
    /**
     * 字典描述 
     */
    public void setDicItemDesc(String dicItemDesc) {
        this.dicItemDesc = dicItemDesc;
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