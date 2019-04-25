/**
 * 
 */
package cn.zz.domain;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019年4月25日
 * @Description:
 */
public class Student extends User {

	/**
	 * 身高
	 */
	private Long height;

	/**
	 * 获取: height
	 */
	public Long getHeight() {
		return height;
	}

	/**
	 * 设置 : height
	 */
	public void setHeight(Long height) {
		this.height = height;
	}

}
