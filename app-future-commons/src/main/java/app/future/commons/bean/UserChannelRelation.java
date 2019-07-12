package app.future.commons.bean;

import app.future.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户频道关联表
 */
public class UserChannelRelation implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1L;
	
    private PageModel model;//分页用
	private Long userChannelId; // 用户频道关联ID 
	private Long userId; // 用户ID 
	private Long channelId; // 频道ID 
	private String priority; // 频道优先级 
	private String recStatus; // 状态(1:有效 2:无效) 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间 
	private Date modifyTime; // 修改时间 
	/**
     * 用户频道关联ID 
     */
    public Long getUserChannelId() {
        return userChannelId;
    }
    /**
     * 用户频道关联ID 
     */
    public void setUserChannelId(Long userChannelId) {
        this.userChannelId = userChannelId;
    }
	/**
     * 用户ID 
     */
    public Long getUserId() {
        return userId;
    }
    /**
     * 用户ID 
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
	/**
     * 频道ID 
     */
    public Long getChannelId() {
        return channelId;
    }
    /**
     * 频道ID 
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
	/**
     * 频道优先级 
     */
    public String getPriority() {
        return priority;
    }
    /**
     * 频道优先级 
     */
    public void setPriority(String priority) {
        this.priority = priority;
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