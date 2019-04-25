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
     * 兴趣
     */
    private String hobbies;

    /**
     * 班级
     */
    private String classNum;

    /**
     * 获取: classNum
     */
    public String getClassNum() {
        return classNum;
    }

    /**
     * 设置 : classNum
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

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

    /**
     * 获取: hobbies.
     *
     * @return the value of hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * 设置: hobbies.
     *
     * @param hobbies hobbies
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
