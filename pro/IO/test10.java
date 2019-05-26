
import java.io.*;

public class test10{
    public static void main(String[] args){
        /**变量引用 */
        FileOutputStream fos = null;
        FileInputStream fis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream  ois = null;

        try{
            /**定义对象实体 */
            Person person = new Person(24, true, "王永坤");
            System.out.println(person);

            fos = new FileOutputStream("D:/a.txt");
            fis = new FileInputStream("D:/a.txt");
            oos = new ObjectOutputStream(fos);
            ois = new ObjectInputStream(fis);

            oos.writeObject(person);
            oos.flush();

            Person p = (Person)ois.readObject();
            System.out.println(p);


        /**这个catch必须添加，若不添加则会出现错误：未报告的异常错误ClassNotFoundException; 必须对其进行捕获或声明以便抛出 */
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{

                if(ois != null){
                    ois.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            try{

                if(oos != null){
                    oos.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            try{

                if(fis != null){
                    fis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            try{

                if(fos != null){
                    fos.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}

/**Person 类的实现Serializable接口后，Person对象才能被序列化 */
class Person implements Serializable{
    /**添加序列ID后，他决定着是否能够反序列化 */
    private static final long serialVersionUID = 1L;
    /**属性 */
    int age;
    boolean isMan;
    String name;
    /**构造函数 */
    public Person(int age, boolean isMan, String name){
        super();
        this.age = age;
        this.isMan = isMan;
        this.name = name;
    }
    /**toString函数重写 */
    @Override
    public String toString(){
        return "Person: [ age = " + age + ", isMan = " + isMan + ", name = " + name + " ]";
    }
}