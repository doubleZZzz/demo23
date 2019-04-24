package cn.zz.domain;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019/4/23 23:34
 * @Description:
 */
public class User {
    /**
     * 姓名.
     */
    private String name;

    /**
     * 年龄.
     */
    private Integer age;

    /**
     * 获取: name.
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置: name.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取: age.
     *
     * @return the value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置: age.
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
