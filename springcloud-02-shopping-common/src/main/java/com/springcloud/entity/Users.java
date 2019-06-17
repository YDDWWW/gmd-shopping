package com.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * users表对应的实体类：用于分装users表中的一行用户信�?
 * @author window
 *
 */
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2954651976780431548L;
	
	/**
	 * 用户编号
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键
	private Integer userId;//用户编号
	
	/**
	 * 用户姓名
	 */
	@Column(name = "user_name")
	private String userName;//用户姓名
	
	/**
	 * 身份证号
	 */
	@Column(name = "user_number")
	private String userNumber;//身份证号
	
	/**
	 * 用户密码
	 */
	@Column(name = "user_password")
	private String userPassword;//用户密码
	
	/**
	 * 用户性别�?0为男�?1为女�?
	 */
	@Column(name = "user_sex")
	private Integer userSex;//用户性别�?0为男�?1为女�?
	
	/**
	 * //联系电话
	 */
	@Column(name = "user_phone")
	private String userPhone;//联系电话
	
	/**
	 * 收货地址
	 */
	@Column(name = "user_site")
	private String userSite;//收货地址
	
	/**
	 * 出生日期
	 */
	@Column(name = "user_birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;//出生日期
	
	/**
	 * 电子邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;//电子邮箱
	
	/**
	 * 头像
	 */
	@Column(name = "user_photo")
	private String userPhoto;//头像
	
	/**
	 * 权限编号（0为卖家，1为买家）
	 */
	@Column(name = "jdiction_id")
	private Integer jdictionId;//权限编号（0为卖家，1为买家）
	
	/**
	 * 用户状状态（0为可用，1为禁用）
	 */
	@Column(name = "user_status")
	private Integer userStatus;//用户状（0为可用，1为禁用）
	
/**
 * user_id用户编号
user_name用户姓名
user_number身份证号
user_password用户密码
user_sex用户性别�?0为男�?1为女�?
user_phone联系电话
user_site收货地址
user_birthday出生日期
user_email电子邮箱
user_photo头像
jdiction_id权限编号�?0为卖家，1为买家）
user_status用户状�?�（0为可用，1为禁用）
 */
}
