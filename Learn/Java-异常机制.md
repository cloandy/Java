# 异常机制

- `exception`:本质就是语句的执行有出错的可能，使用异常机制来捕捉语句执行是否出错以及出错后的处理

- 常规语言的出错处理：

  ```
  如果 文件存在：
  	如果 硬盘长度 > 文件长度
  		如果 文件复制一半
  		否则 停止复制文件
  	否则 硬盘空间不够
  否则 文件不存在
  ```

  - 缺点：
    - 逻辑代码和错误代码放在了一块
    - 程序员本省需要考虑许多例外情况

- Java的异常机制

  ```
  try{
      复制文件
  }catch(Exception e){
      e.printStackTrace();
  }
  ```

  - 本质：当程序出现错误时，程序打印错误类型和程序安全退出的机制

## 概念

```java
public class Test2{
    public static void main(String[] args){
        try{
        	int a = 1/0;
        	System.out.println(a);
        } catch(Exception e){
            e.printStackTrace();
        }
   }
}
/*会产生错误*/
```

- Java的异常处理过程如下：
  - 抛出异常：在执行一条语句时，如果发生异常，则这条语句将生成代表该异常的一个对象,并且停止当前路径执行，并把异常对象提交给JRE
  - 捕获异常：JRE得到该异常后，寻找相应的代码来处理异常，JRE在方法的调用栈中查找，从生成异常的方法开始回溯，直到找到相应的异常处理代码为止

## 异常分类

- 所有到的对象都是派生于`Theowable`类的一个实例
- 如果内置类不满足要求，还可以创建自己的异常类	
- `Theowable`主要派生出了2类：`Error` 和`Exception`

## 关于`Error` 和`Exception`

- `Error`
  - `Error `表示程序无法处理的错误，表示应用程序中较严重的问题。
  - 表示代码运行时`JVM`出现了问题
  - `Error`表示系统JVM已经处于不可恢复的崩溃状态中
- `Exception`
  - `Exception`是程序本身可以自行处理的异常
  - 异常可分为两类：
    - 运行时异常
    - 已检查异常
- 区别：
  - 开车上路，有人通过，刹车，叫做异常
  - 开车上路，发动机快乐，这叫错误

## `RuntimeException`运行时异常

- 这类异常通常是由编程错误导致的
- 所以在编程时，并不要求必须使用异常处理机制
- 也可以使用通过增加逻辑处理程序来避免这些异常

## CheckException已检查异常

-  除了`RUNtimeException`，其他统称之为`Cheacked Exception `
- 这种异常必须在编译时就做出处理，否则无法通过编译
- 可以使用`try...catch()`或者和使用`throws`声明异常

## 异常处理方式之一：`try{}catch(){}finally{}`语句块

- 基本流程

  ```mermaid
  graph LR
  
  start[try] --> conditiontry{是否异常}
  conditiontry -- YES --> catch[catch1/catch2...]
  conditiontry -- NO -->  finally[finally可选择]
  catch --> finally
  
  
  
  ```

  - 注意事项：
    - 即使`try和catch`块中含有return语句，`finally`语句也会执行，当执行完`finally`后，再通过`return `返回
    - `finally`只有在一种情况下不会执行，那就是在执行`finally`之前遇到了`System.exit(0)`

## 异常处理方式之二：声明异常（throws子句）

- 当`ChickedException`产生是，不一定立刻处理它，可以再把异常`throws`出去

- 方法重写声明异常原则;

  - 子类重写父类方法是，如果父类有声明异常，子类声明的异常范围不可以超过父类声明的异常范围

  ```java
  import java.io.*;
  
  public class test{
      public static void main(String[] args){
          try{
              readFile("a.txt");
          }catch(FileNotFoundException  e){
              System.out.println("所需文件不存在！");
          } catch(IOException e){
              System.out.println("文件读写错误！");
          }
      }
      
      public static void readFile(String FileName) throws FileNotFoundException,IOException{
          FileReader in = new FileReader(fileName);
          int tem = 0;
          try{
              tem = in.read();
              while(tem != -1){
                  System.out.println((cahr)tem);
                  tem = in.read();
              }finally{
                  in.close();
              }
          }
      }
      
  }
  ```

  

## 自定义异常

- 自定义异常类只要从`Exception`类或者它的子类派生出一个子类即可
- 自定义异常类如果继承`Exception`类，则为受检查异常，必须进行处理
- 如果不想处理可以让自定义类继承运行时异常`RuntimeExpection`类
- 习惯上，自定义异常类应该包括2构造器：
  - 默认构造器
  - 带有详细参数的构造器

```java
class IllegaAgeException extends Exception{
    public IllegaAgeException(){
        
    }
    public IllegaAgeException(String message){
        super(message);
    }
}

calss Person{
    private String name;
    private age;
    
     public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) throws IllegaAgeException{
        if(age < 0){
            throw new IllegaAgeException("人的年龄不应该为负数");
        }
        this.age = age;
    }
    public String toString() {
        return "name is " + name + " and age is " + age;
    }
}

public class test{
    
    public static void main(String[] args){
        Person p = new Person();
        try{
            p.setName("wyk");
            p.serAge(-1);
        }catch(IllegaAgeException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
```

