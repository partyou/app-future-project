package app.future.commons.bean;

import app.future.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻频道表
 */
public class NewsChannels implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1L;
	
    private PageModel model;//分页用
	private Long channelsId; // 频道ID 
	private String channelsName; // 频道名称 
	private String channelsDesc; // 频道说明 
	private Integer channelPriority; // 频道优先级 
	private String recStatus; // 状态(1:有效 2:无效) 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间 
	private Date modifyTime; // 修改时间 
	/**
     * 频道ID 
     */
    public Long getChannelsId() {
        return channelsId;
    }
    /**
     * 频道ID 
     */
    public void setChannelsId(Long channelsId) {
        this.channelsId = channelsId;
    }
	/**
     * 频道名称 
     */
    public String getChannelsName() {
        return channelsName;
    }
    /**
     * 频道名称 
     */
    public void setChannelsName(String channelsName) {
        this.channelsName = channelsName;
    }
	/**
     * 频道说明 
     */
    public String getChannelsDesc() {
        return channelsDesc;
    }
    /**
     * 频道说明 
     */
    public void setChannelsDesc(String channelsDesc) {
        this.channelsDesc = channelsDesc;
    }
	/**
     * 频道优先级 
     */
    public Integer getChannelPriority() {
        return channelPriority;
    }
    /**
     * 频道优先级 
     */
    public void setChannelPriority(Integer channelPriority) {
        this.channelPriority = channelPriority;
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
	@Override
	public String toString() {
		return "NewsChannels [model=" + model + ", channelsId=" + channelsId
				+ ", channelsName=" + channelsName + ", channelsDesc="
				+ channelsDesc + ", channelPriority=" + channelPriority
				+ ", recStatus=" + recStatus + ", remark=" + remark + ", res1="
				+ res1 + ", createTime=" + createTime + ", modifyTime="
				+ modifyTime + "]";
	}


}