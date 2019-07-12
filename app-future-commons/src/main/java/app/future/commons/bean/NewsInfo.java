package app.future.commons.bean;

import app.future.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 新闻表
 */
public class NewsInfo implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 新闻类型集合
	 */
	private List<Long> newsTypeList;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 频道ID
	 */
	private Long channelsId;
	
    private PageModel model;//分页用
	private Long newsId; // 新闻ID 
	private String newsTitle; // 新闻标题 
	private Long newsType; // 新闻类别 
	private Long newsResourceId; // 新闻来源 
	private String newsLink; // 新闻链接 
	private String resourceType; // 资源类型(纯文本、视频、图片) 
	private String recStatus; // 状态(1:有效 2:无效) 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间 
	private Date modifyTime; // 修改时间 
	/**
     * 新闻ID 
     */
    public Long getNewsId() {
        return newsId;
    }
    /**
     * 新闻ID 
     */
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
	/**
     * 新闻标题 
     */
    public String getNewsTitle() {
        return newsTitle;
    }
    /**
     * 新闻标题 
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
	/**
     * 新闻类别 
     */
    public Long getNewsType() {
        return newsType;
    }
    /**
     * 新闻类别 
     */
    public void setNewsType(Long newsType) {
        this.newsType = newsType;
    }
	/**
     * 新闻来源 
     */
    public Long getNewsResourceId() {
        return newsResourceId;
    }
    /**
     * 新闻来源 
     */
    public void setNewsResourceId(Long newsResourceId) {
        this.newsResourceId = newsResourceId;
    }
	/**
     * 新闻链接 
     */
    public String getNewsLink() {
        return newsLink;
    }
    /**
     * 新闻链接 
     */
    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }
	/**
     * 资源类型(纯文本、视频、图片) 
     */
    public String getResourceType() {
        return resourceType;
    }
    /**
     * 资源类型(纯文本、视频、图片) 
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getChannelsId() {
		return channelsId;
	}
	public void setChannelsId(Long channelsId) {
		this.channelsId = channelsId;
	}
	public List<Long> getNewsTypeList() {
		return newsTypeList;
	}
	public void setNewsTypeList(List<Long> newsTypeList) {
		this.newsTypeList = newsTypeList;
	}


}