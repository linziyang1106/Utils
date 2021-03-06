/**
 * @Author ISheep
 * @Date 2020/9/29 20:38
 * @Version 1.0
 */

// 什么叫反射
public class Reflection extends Object {

    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("User");
        System.out.println(c1);

        Class c2 = Class.forName("Person");
        Class c3 = Class.forName("Person");
        Class c4 = Class.forName("Person");

        // 一个类在内存中只有一个Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

    }


}


// pojo
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
