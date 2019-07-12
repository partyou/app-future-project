package app.future.commons.bean;

import app.future.commons.base.PageModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
public class UsersAccount implements Serializable {
    /**
	 */
	private static final long serialVersionUID = 1L;
	
    private PageModel model;//分页用
	private Long userId; // 用户ID 
	private String userAccount; // 账号 
	private String userPasswd; // 密码 
	private String userAccountType; // 账号类型 
	private String userName; // 姓名 
	private String userNickname; // 昵称 
	private Integer userAge; // 年龄 
	private String idcardNo; // 身份证号 
	private String userEmail; // 邮箱 
	private String userPhone; // 手机号 
	private String accountStatus; // 账号状态 
	private String userHeadImg; // 用户头像链接 
	private String education; // 学历 
	private String profession; // 职业 
	private String province; // 省份 
	private String city; // 城市 
	private String area; // 地区 
	private String addr; // 地址 
	private String registerResource; // 注册来源 
	private String remark; // 备注 
	private String res1; // 保留字段 
	private Date createTime; // 创建时间
	private Date modifyTime; // 修改时间 
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
     * 账号 
     */
    public String getUserAccount() {
        return userAccount;
    }
    /**
     * 账号 
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
	/**
     * 密码 
     */
    public String getUserPasswd() {
        return userPasswd;
    }
    /**
     * 密码 
     */
    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
	/**
     * 账号类型 
     */
    public String getUserAccountType() {
        return userAccountType;
    }
    /**
     * 账号类型 
     */
    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }
	/**
     * 姓名 
     */
    public String getUserName() {
        return userName;
    }
    /**
     * 姓名 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
	/**
     * 昵称 
     */
    public String getUserNickname() {
        return userNickname;
    }
    /**
     * 昵称 
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
	/**
     * 年龄 
     */
    public Integer getUserAge() {
        return userAge;
    }
    /**
     * 年龄 
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
	/**
     * 身份证号 
     */
    public String getIdcardNo() {
        return idcardNo;
    }
    /**
     * 身份证号 
     */
    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }
	/**
     * 邮箱 
     */
    public String getUserEmail() {
        return userEmail;
    }
    /**
     * 邮箱 
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
	/**
     * 手机号 
     */
    public String getUserPhone() {
        return userPhone;
    }
    /**
     * 手机号 
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
	/**
     * 账号状态 
     */
    public String getAccountStatus() {
        return accountStatus;
    }
    /**
     * 账号状态 
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
	/**
     * 用户头像链接 
     */
    public String getUserHeadImg() {
        return userHeadImg;
    }
    /**
     * 用户头像链接 
     */
    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }
	/**
     * 学历 
     */
    public String getEducation() {
        return education;
    }
    /**
     * 学历 
     */
    public void setEducation(String education) {
        this.education = education;
    }
	/**
     * 职业 
     */
    public String getProfession() {
        return profession;
    }
    /**
     * 职业 
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
	/**
     * 省份 
     */
    public String getProvince() {
        return province;
    }
    /**
     * 省份 
     */
    public void setProvince(String province) {
        this.province = province;
    }
	/**
     * 城市 
     */
    public String getCity() {
        return city;
    }
    /**
     * 城市 
     */
    public void setCity(String city) {
        this.city = city;
    }
	/**
     * 地区 
     */
    public String getArea() {
        return area;
    }
    /**
     * 地区 
     */
    public void setArea(String area) {
        this.area = area;
    }
	/**
     * 地址 
     */
    public String getAddr() {
        return addr;
    }
    /**
     * 地址 
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
	/**
     * 注册来源 
     */
    public String getRegisterResource() {
        return registerResource;
    }
    /**
     * 注册来源 
     */
    public void setRegisterResource(String registerResource) {
        this.registerResource = registerResource;
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