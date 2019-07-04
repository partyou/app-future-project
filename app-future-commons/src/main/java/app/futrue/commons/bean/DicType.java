package app.futrue.commons.bean;

import app.futrue.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型表
 */
public class DicType implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1L;
	
    private PageModel model;//分页用
	private String dicTypeId; // 字典类型id 
	private String dicTypeName; // 字典类型名称 
	private String dicTypeDesc; // 字典类型描述 
	private String parentTypeId; // 字典所属父类型 
	private String recStatus; // 状态(1:有效 2:无效) 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间 
	private Date modifyTime; // 修改时间 
	/**
     * 字典类型id 
     */
    public String getDicTypeId() {
        return dicTypeId;
    }
    /**
     * 字典类型id 
     */
    public void setDicTypeId(String dicTypeId) {
        this.dicTypeId = dicTypeId;
    }
	/**
     * 字典类型名称 
     */
    public String getDicTypeName() {
        return dicTypeName;
    }
    /**
     * 字典类型名称 
     */
    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName;
    }
	/**
     * 字典类型描述 
     */
    public String getDicTypeDesc() {
        return dicTypeDesc;
    }
    /**
     * 字典类型描述 
     */
    public void setDicTypeDesc(String dicTypeDesc) {
        this.dicTypeDesc = dicTypeDesc;
    }
	/**
     * 字典所属父类型 
     */
    public String getParentTypeId() {
        return parentTypeId;
    }
    /**
     * 字典所属父类型 
     */
    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
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