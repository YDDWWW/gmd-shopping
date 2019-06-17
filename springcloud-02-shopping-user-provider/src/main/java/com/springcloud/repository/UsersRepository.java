package com.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * 持久化层：定义对USERS表进行操作的方法
 * 
 * @author 17384
 *
 */

public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
	/**
	 * 判断用户时否登陆成功
	 * 
	 * @param userId       用户编号
	 * @param userPassword 用户密码
	 * @param jdictionId   权限编号
	 * @return 成功返回登陆用户的完整信息，失败返回null
	 */
	@Query("select new com.springcloud.entity.Users(u.userId,u.userName,u.userNumber,"
			+ "u.userPassword,u.userSex,u.userPhone,u.userSite,u.userBirthday,u.userEmail,"
			+ "u.userPhoto,u.jdictionId,u.userStatus) from com.springcloud.entity.Users u where u.userId=:userId and"
			+ " u.userPassword=:userPassword and u.jdictionId=:jdictionId and u.userStatus=0")
	public abstract Users login(@Param("userId") Integer userId, @Param("userPassword") String userPassword,
			@Param("jdictionId") Integer jdictionId);

	/**
	 * 
	 * 修改Users表中指定编号的用户状态
	 * 
	 * @param userId     用户编号
	 * @param userStatus 用户状态
	 * @return 修改成功返回大于0 的整数，否则返回0
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

	/**
	 * 修改USERS表中指定USER_ID的用户信息
	 * 
	 * @param users 修改的用户信息
	 * @return 修改成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userNumber=:#{#users.userNumber},u.userSex=:#{#users.userSex},u.userPhone=:#{#users.userPhone},u.userBirthday=:#{#users.userBirthday},"
			+ "u.userEmail=:#{#users.userEmail},u.userSite=:#{#users.userSite} where u.userId=:#{#users.userId}")
	public abstract Integer update(@Param("users") Users users);

	/**
	 * 修改USERS表中指定USER_ID的用户头像
	 * 
	 * @param users 修改的用户信息
	 * @return 修改成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userPhoto=:#{#users.userPhoto} where u.userId=:#{#users.userId}")
	public abstract Integer updatePhoto(@Param("users") Users users);

	/**
	 * 修改USERS表中指定USER_ID的用户密码
	 * 
	 * @param users 修改的用户信息
	 * @return 修改成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userPassword=:#{#users.userPassword} where u.userId=:#{#users.userId}")
	public abstract Integer updatePassword(@Param("users") Users users);

	/**
	 * 修改USERS表中指定USER_ID的用户昵称
	 * 
	 * @param users 修改的用户信息
	 * @return 修改成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userName=:#{#users.userName} where u.userId=:#{#users.userId}")
	public abstract Integer updateName(@Param("users") Users users);
}
