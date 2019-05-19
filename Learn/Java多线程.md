# 基本概念

- 多线程大量用于网络编程，服务器程序的开发
- 程序是一个静态的概念，一般对应与操作系统的一个可执行文件
- 进程：相当于QQ、AD等应用软件软件
  - 是一个动态的概念
  - 进程有3部分组成;`cpu,data,code`,每个进程都是独立的，享有自己的`cpu,data,code`
  - 多任务操作系统将CPU时间合理的划分给每一个进程，操作系统同时执行多个进程，每个进程独立运行，其实质也为时间片轮转
  - 由于一个进程独占`cpu,data,code`,所以无法直接通信
- 线程：称之为轻量级进程
  - 一个进程内部的一个执行单元
  - 一个进程可以拥有多个线程
  - 多线程共享相同的内存，可以访问相同的变量和对象，而且他们从同一个对中分配对象进行通信
  - 无需额外的通信机制
  - 线程的启动，中断，消亡，消耗的资源非常少
- 进程和线程的区别：
  - 进程独占3区，进程间切换会有较大的开销；同一进程的线程共享资源，为轻量级进程，线程的切换开销较小
  - 最根本区分：进程是资源分配的基本单位；线程是调度和执行的基本单位
  - 多进程:在多任务操作系统中，可以运行多个任务
  - 多线程：在同一个进程中有多个顺序流在运行
- 只有一个进程而没有线程，可被认为为单线程
- 操作系统会为每一个进程独立的分配空间资源，线程只能共享它所属进程的资源；
- 进程和程序的区别：
  - 程序时一组指令的集合，是静态的实体
  - 进程是动态的实体

# 通过继承实现多线程

- 通过继承`Thread`类实现多线程步骤：
  1. 在Java中负责线程的工具类为`java.lang.Thread`
  2. 可以通过创建`Thread`的实例来创建新的线程
  3. 每一个线程通过所创建的`Thread`的实例对象的`run()`方法来完成操作
  4. 线程的启动使用`Thread`的`start()`方法

```java
/**
 * TestThread
 */

public class TestThread extends Thread{
   
    public void run(){
        for(int i = 0; i < 10; i++)
        System.out.println(this.getName() + ": " + i);
    }
    public static void main(String[] args){

        TestThread th1 = new TestThread();
        th1.start();

        TestThread th2 = new TestThread();
        th2.start();
    }
}

/*
Thread-0: 2
Thread-0: 3
Thread-0: 4
Thread-1: 8
Thread-0: 5
Thread-1: 9
Thread-0: 6
Thread-0: 7
Thread-0: 8
Thread-0: 9
并不是说线程是按照创建顺序执行，其实也有线程的抢断操作
缺点：如果我们的类已经继承了一个类，就无法继承Thread类了
*/
```

# 改进：使用`Runnable`接口实现多线程

- 克服了无法继承类的缺点

  ```java
  /**
   * TestThread
   * 使用Runnable接口
   */
  
  public class TestThread2 implements Runnable{
     
      public void run(){
          for(int i = 0; i < 10; i++)
          System.out.println(this.getName() + ": " + i);
      }
      public static void main(String[] args){
  
          TestThread th1 = new TestThread();
          th1.start();
  
          TestThread th2 = new TestThread();
          th2.start();
      }
  }
  /*
  只是关键字的修改
  */
  ```

# 线程5态

- 新生态

  - `new`一个对象，处于新生态，调用`start()`方法之后为就绪态

- 就绪态

  - 就绪态有了运行条件，但是还没有被分配到CPU
  - 当系统选定一个线程进行执行时，线程才处于运行态
  - 4原因进入就绪态：
    - `new`线程：且调用`start()`方法
    - 堵塞线程：堵塞解除
    - 运行线程：调用`yield()`方法
    - 运行线程：JVM将CPU资源从本线程切换到别的线程        

- 运行态

  - 执行`run()`方法体中的代码

- 堵塞态

  - 暂停某一个线程的执行以等待某一个资源条件发生
  - 4原因导致堵塞：
    - 执行`sleep()`，使得线程休眠，进入堵塞态，当到达指定时间后，线程进入就绪态
    - 执行`wait()`方法，使得当前线程进入堵塞态，使用`nofity()`唤醒这个线程后，进入就绪态
    - 线程运行时，某个线程操作使得线程进入堵塞状态，当引起该堵塞的原因消失后，进入就绪态
    - `join()`线程联合方法：当某一个线程等待另一个线程执行结束后，才能继续执行

- 死亡态

  - 线程存在的最后一个状态
  - 死亡原因：
    - 正常运行线程工作，直至最后
    - 线程被强制终止
      - 基本不在使用`stop()`和`destory()`方法
      - 推荐方法：提供一个boolean的终止形式参数

  ```java
  /**
   * 测试线程的死亡
   */
  
   public class TestThreadStop implements Runnable{
      String name;
      boolean live = true;
      public TestThreadStop(String name){
          super();
          this.name = name;
      }
      public void run(){
          int i = 0;
          while(live){
              System.out.println(name + (++i));
          }
      }
  
      public void terminate(){
          live = false;
      }
  
      public static void main(String[] args){
          TestThreadStop ts1 = new TestThreadStop("线程A");
          Thread t1 = new Thread(ts1);
          t1.start();
  
          for(int i = 0; i < 10; i++){
              System.out.println("主线程" + i);
          }
  
          ts1.terminate();
          System.out.println("ts1 stop!");
          
      }
  
   }
  ```

# 关于`sleep()`方法和`yield()`方法

- `sleep()`方法，让直接运行的线程进入堵塞态，直到休眠时间到了，进入就绪态

- `yield()`方法，让正在运行的线程直接进入就绪态

  ```java
  /**
   * 测试线程的sleep()方法
   */
  
   class StateThread extends Thread{
       public void run(){
           for(int i = 0; i < 100; i ++){
               System.out.println(this.getName() + ": " + i);
               try{
                   Thread.sleep(2000);
               } catch(InterruptedException e){
                   e.printStackTrace();
               }
           }
       }
   }
   public class TestThreadSleep{
  
      public static void main(String[] args){
  
          StateThread thread1 = new StateThread();
          thread1.start();
          StateThread thread2 = new StateThread();
          thread2.start();
      }
   }
  
  ```

  ```java
  /**
   * 测试yield()方法
   */
  class StateThread extends Thread{
      public void run(){
          for(int i = 0; i < 100; i ++){
              System.out.println(this.getName() + ": " + i);
              Thread.yield();
          }
      }
  }
  
  
  public class TestThreadYield{
      
      public static void main(String[] args){
  
          StateThread thread1 = new StateThread();
          thread1.start();
          StateThread thread2 = new StateThread();
          thread2.start();
      }
  }
  ```

# 线程联合

```java
class FatherThread implements Runnable{
    public void run(){
        System.out.println("爸爸想抽烟，发现烟抽完了");
        System.out.println("爸爸让儿子去买包红塔山");
        Thread son = new Thread(new SonThread());
        son.start();
        System.out.println("爸爸等儿子买烟回来");
        try{
            son.join();
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.print("爸爸出门去找儿子，儿子去哪儿??\n");
            System.exit(1);
        }
        System.out.println("爸爸高兴的接过烟开始抽，并把零钱给了儿子");
    }
}
class SonThread implements Runnable{
    public void run() {
        System.out.println("儿子出门去买烟");
        System.out.println("儿子买烟需要10分钟");
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("第" + i + "分钟");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("儿子买烟回来了");
    }

}

public class TestThreadJoin {

    public static void main(String[] args){
        System.out.println("爸爸和儿子买烟的故事");
        Thread father = new Thread(new FatherThread());
        father.start();
    }

}

/*
爸爸和儿子买烟的故事
爸爸想抽烟，发现烟抽完了
爸爸让儿子去买包红塔山
爸爸等儿子买烟回来
儿子出门去买烟
儿子买烟需要10分钟
第1分钟
第2分钟
第3分钟
第4分钟
第5分钟
第6分钟
第7分钟
第8分钟
第9分钟
第10分钟
儿子买烟回来了
爸爸高兴的接过烟开始抽，并把零钱给了儿子
*/
```

# 获取线程的基本信息

```java
/**
 * 得到基本信息
 */
public class TestThreadResouce extends Thread{
    
    public void run(){
        for(int i = 0; i< 10; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args){

        TestThreadResouce t = new TestThreadResouce();
        t.start();

        System.out.println("线程名称叫做：" + t.getName());
        try{
            TestThreadResouce.currentThread().sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("ERROR!");
        }
        
        System.out.println(t.isAlive());
        System.out.println("Over!");

    }
}

/*
线程的默认名称为：Thread-0
*/
```

# 线程间同步

- 只要是这样一种场景：同一种资源，多个人使用

  - 比如生产者-消费者案例

- 多线程操作同一个对象

  ```java
  
  public class TestThreadBank{
  
      public static void main(String[] args){
          Account a = new Account(100, "wyk");
  
          Drawing draw1 = new Drawing(80,a);
          Drawing draw2 = new Drawing(80,a);
  
          draw1.start();
          draw2.start();
      }
  }
  
  class Account{
      int money;
      String name;
      public Account(int money,String name){
          super();
          this.money = money;
          this.name = name;
      }
  }
  
  class Drawing extends Thread{
      int drawingNumber;
      Account account;
      int expenseTotal;
  
      public Drawing(int drawingNumber,Account account){
          super();
          this.drawingNumber = drawingNumber;
          this.account = account;
      }
  
      @Override
      public void run(){
  
          if(account.money - drawingNumber < 0)
              return ;
          try{
              Thread.sleep(1000);
          }catch(InterruptedException e){
              e.printStackTrace();
          }
  
          account.money -= drawingNumber;
          expenseTotal += drawingNumber;
          System.out.println(this.getName() + "账户余额： " + account.money);
          System.out.println(this.getName() + "总共花费： " + expenseTotal);
      }
  }
  
  /*
  Thread-1账户余额： 20
  Thread-0账户余额： 20
  Thread-1总共花费： 80
  Thread-0总共花费： 80
  */
  ```

# 线程间同步（类似于原子操作，某些步骤必须要么一起，要么不执行）

- 我们可以通过使用`private`关键字保证数据对象只能被方法访问

- 所以我们只要怎么针对于方法提出一套线程间同步的方法

  - 使用`synchronized(syncObject)`

    ```
    synchronized(syncObject){
        
    }
    ```

    

  ```java
  
  public class TestThreadBank2{
  
      public static void main(String[] args){
          Account a = new Account(100, "wyk");
  
          Drawing draw1 = new Drawing(80,a);
          Drawing draw2 = new Drawing(80,a);
  
          draw1.start();
          draw2.start();
      }
  }
  
  class Account{
      int money;
      String name;
      public Account(int money,String name){
          super();
          this.money = money;
          this.name = name;
      }
  }
  
  class Drawing extends Thread{
      int drawingNumber;
      Account account;
      int expenseTotal;
  
      public Drawing(int drawingNumber,Account account){
          super();
          this.drawingNumber = drawingNumber;
          this.account = account;
      }
  
      @Override
      public void run(){
          synchronized(account){
              if(account.money - drawingNumber < 0){
                  System.out.println(this.getName() + "取款，余额不足！");
                  return ;
              }
              try{
                  Thread.sleep(1000);
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
  
              account.money -= drawingNumber;
              expenseTotal += drawingNumber;
          }
          System.out.println(this.getName() + "账户余额： " + account.money);
          System.out.println(this.getName() + "总共花费： " + expenseTotal);
      }
  }
  /*
  Thread-1取款，余额不足！
  Thread-0账户余额： 20
  Thread-0总共花费： 80
  */
  ```

# 死锁问题

- 两个线程以上都在等待对方释放资源，使得都停止执行

```java
/**
 * 测试死锁问题
 */
class Lipstick{

}
class Mirror{

}
class MakeUp extends Thread{
    int flag;
    String girl;
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    @Override
    public void run(){

        doMakeup();
    }

    void doMakeup(){
        if(flag == 0){
            synchronized(lipstick){
                System.out.println(girl + "拿着口红！");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                synchronized(mirror){
                    System.out.println(girl + "拿着镜子！");
                }
            }
        } else{
            synchronized (mirror) {
                System.out.println(girl + "拿着镜子！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(girl + "拿着口红！");
                }
            }

        }
    }
}

public class TestSisuo{

    public static void main(String[] args){

        MakeUp m1 = new MakeUp();
        m1.girl = "大丫";
        m1.flag = 0;

        MakeUp m2 = new MakeUp();
        m2.girl = "小丫";
        m2.flag = 1;

        m1.start();
        m2.start();

    }

}
```

## 死锁问题的解决

- 死锁是因为同步块需要同时持有多个对象锁造成的，要解决这个问题，思路就是：
  - 同一个代码块，不要同时持有两个对象锁

# 线程的并发协作（生产者消费者模型）

- 生产者是指：负责生产数据的模块

- 消费者是指：负责处理数据的模块

- 缓冲区是指：生产者将生产好的数据放在缓冲区中，消费者从缓冲区中拿要处理的数据

  - 缓冲区的三个好处：
    - 可以实现线程的并发协作
    - 解耦了生产者和消费者，无需直接打交道
    - 解决了忙闲不均

- 生产者和消费者模型：

  ```java
  /**
   * 测试生产者和消费者的线程并发协同
   */
  public class TestProduct{
  
      public static void main(String[] args){
  
          SyncStack sStack = new SyncStack(); //定义缓冲区
          Shengchan sc = new Shengchan(sStack);//定义生产者线程
          Xiaofei xf = new Xiaofei(sStack);//定义消费者线程
          sc.start();//启动生产者线程
          xf.start();//启动消费者线程
      }
  }
  /**
   * 定义馒头类
   */
  class Mantou{
      int id;
      public Mantou(int id){
          this.id = id;
      }
  }
  /**
   * 缓冲区类：
   *  属性：缓冲区索引
   *  方法：出缓冲区
   *       入缓冲区
   */
  class SyncStack{
      int index = 0;
      Mantou[] ms = new Mantou[10];
      /**生产者所采用的 */
      public synchronized void push(Mantou m){
          while(index == ms.length){
              try{
                  this.wait();
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
          }
          /**唤醒当前对象等待池中的第一个线程 */
          this.notify();
          ms[index] = m;
          index ++;
      }
      /**消费者所采用的 */
      public synchronized Mantou pop(){
          while(index == 0){
              try{
                  this.wait();
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
          }
  
          this.notify();
          index --;
          return ms[index];
      }
  }
  /**
   * 定义生产者
   */
  class Shengchan extends Thread{
      SyncStack ss = null;
  
      public Shengchan(SyncStack ss){
          this.ss = ss;
      }
  
      @Override
      public void run(){
  
          for(int i = 0; i< 10; i ++){
              System.out.println("生产馒头：" + i);
              Mantou m = new Mantou(i);
              ss.push(m);
          }
      }
  }
  /**
   * 定义消费者
   */
  class Xiaofei extends Thread{
      SyncStack ss = null;
  
      public Xiaofei(SyncStack ss){
          this.ss = ss;
      }
  
      @Override
      public void run(){
  
          for(int i = 0; i< 10; i ++){
              Mantou m = ss.pop();
              System.out.println("消费馒头：" + i);
          }
      }
  }
  /*
  生产馒头：0
  生产馒头：1
  消费馒头：0
  生产馒头：2
  消费馒头：1
  生产馒头：3
  消费馒头：2
  生产馒头：4
  消费馒头：3
  生产馒头：5
  消费馒头：4
  生产馒头：6
  消费馒头：5
  生产馒头：7
  消费馒头：6
  生产馒头：8
  消费馒头：7
  生产馒头：9
  消费馒头：8
  消费馒头：9
  */
  ```

## 总结

- 线程的并发协作，通常用于生产者和消费者模型
- 生产者和消费者共享一个内存资源，且互为条件
- 对于生产者，没有生产产品之前，消费者要进入等待状态；生产者生产了产品之后，有需要马上通知消费者消费

# 任务的定时调度

- 通过`Timer`和`Timertask`,我们可以实现定时启动某个线程
- `java.util.Timer`
  - 这种实现方式中，`Timer`类的作用是类似于闹钟的功能，也就是定时触发一次线程
  - 其实`Timer`本身也是一个线程，只是这个线程是用来调用其他线程的
- `java.util.TimerTask`
  - TimerTask类是一个抽象类，该类实现了`Runnable`接口
  - 通过继承`TimerTask`类使得该类获得多线程的能力，将需要执行的多线程代码书写在run方法内部，然后通过`Timer类`启动线程的执行	

# 总结

- 程序：Java源程序和字节码文件被称为“程序(Program)”，是一个静态的概念。 

- 进程：执行中的程序叫做进程(Process)，是一个动态的概念。每个进程由3部分组成：cpu、data、code。 

- 线程：是进程中一个“单一的连续控制流程 (a single sequential flow of control)”。 

- 在Java中实现多线程的方式： 

  - 继承Thread类实现多线程 
  - 实现Runnable接口实现多线程 

- 线程的状态： 

- 暂停线程执行的方法: 

  - `sleep() `
  - `yield()`
  - ` join()`

- 实现线程同步的两种方式： 

  - `public synchronized void accessVal(int newVal);` 

  - ```java
    synchronized(syncObject)
    { 
    //允许访问控制的代码 
    }
    ```

- 同步解决问题的另一种典型方式：生产者/消费者模式。 

- 线程通信的方法： 

  - `wait() `
  - `notify()` 
  - `notifyAll() `

