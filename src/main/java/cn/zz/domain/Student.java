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
     * 兴趣
     */
    private String hobbies;

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
