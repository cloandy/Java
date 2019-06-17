# XML

>参考：
>
>- W3Shool
>- 尚学堂XML教程

## 认识XML

`XML（eXtensiable Markup Language）` 可拓展标记语言

- 是一种标记语言
- 无固定标签
- 所有标签均可以自定义
- 通常，XML被用于信息的记录和传递
- XML经常被用来做配置文件

## XML格式

编辑器：

- 记事本
- Dreamweaver
- XMLSpy
- eclipse

格式如下：

- 声明信息：定义xml的版本号和编码信息

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
```

- xml有且只有一个根元素
- XML大小写敏感
- XML标签成对且正确嵌套

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<!--上一行为声明信息：定义xml版本号和编码信息，要定在首行，注释都不可以-->
<!--根元素-->
<books>
<!--图书信息-->
    <!--属性-->
	<book id = "bk101">
        <!--元素：开始标签 元素内容 结束标签组成-->
		<author>王珊</author>
		<title>.NET高级编程</title>
		<description>包含C#框架和网络编程灯</description>
	</book>
</books>
```

- 可以用浏览器打开，没什么效果，可以使用别的语言来读取XML，得到其配置信息

## 有效的XML文档

格式良好

有特定的格式，对格式进行约束

文件后缀名：`xxx.xml`

# DTD 解决格式约束问题

>后缀名`xxx.dtd`

`DTD(Document Type Definition)`	 文档类型定义

- 用于约束XML的文档格式，保证XML为一个有效的XML

DTD可以分为两种：

- 内部DTD
- 外部DTD

### 内部DTD的定义

`<!DOCTYPE 根元素[元素声明]>`

元素声明语法：

`<!ELEMENT 上层元素(上层元素所属子元素)>`

数量词：

>`+` 表示出现1次或者多次
>
>`?`表示出现0次或者一次
>
>`*`表示出现任意次

属性声明语法：

`<!ATTLIST 元素名 属性名 属性类型 属性修饰符>`

属性修饰符：

- `#REQUIRED`
- `#IMPLIED`
- `FIXED value`

实例：

```xml-dtd
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE scores[
	<!ELEMENT scores (student +)>
	<!ELEMENT student (name, course, socre)>
	<!ATTLIST student id CDATA #REQUIRED>
	<!ELEMENT name (#PCDATA)>
	<!ELEMENT course (#PCDATA)>
	<!ELEMENT score (#PCDATA)>
]>
<!--空格必须加上-->
<scores>
	<student id="1">
		<name>王彤</name>
		<course>Java</course>
		<score>98</score>
	</student>
	
	<student id="2">
		<name>文档</name>
		<course>Java</course>
		<score>98</score>
	</student>
	
	<student id="3">
		<name>天天</name>
		<course>Java</course>
		<score>85</score>
	</student>
	
</scores>

<!-- 如果基本元素不加星号，则基本元素只能出现一次 -->
<!-- 出现零次或者多次，添加星号 -->
<!-- 出现零次或者一次，添加问号 -->
```

### 外部文件

```xml-dtd
<?xml version="1.0" encoding="UTF-8"?>
<!ELEMENT scores (student +)>
<!ELEMENT student (name, course, socre)>
<!ATTLIST student id CDATA #REQUIRED>
<!ELEMENT name (#PCDATA)>
<!ELEMENT course (#PCDATA)>
<!ELEMENT score (#PCDATA)>
```

怎么引入`dtd`文件到`xml`文件？

`<!DOCTYPE 根属性名称 SYSTEM 文件路径>`

```xml-dtd
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE scores SYSTEM "SCORES.dtd">
<scores>
	<student id="1">
		<name>王彤</name>
		<course>Java</course>
		<score>98</score>
	</student>
	
	<student id="2">
		<name>文档</name>
		<course>Java</course>
		<score>98</score>
	</student>
	
	<student id="3">
		<name>天天</name>
		<course>Java</course>
		<score>85</score>
	</student>
	
</scores>

<!-- 如果基本元素不加星号，则基本元素只能出现一次 -->
<!-- 出现零次或者多次，添加星号 -->
<!-- 出现零次或者一次，添加问号 -->
```

## XML文件解析

对XML文件操作：创建操作， 增删改查操作

### 常见的XML解析技术

#### DOM解析

官方提供的解析方式，基于XML树

#### SAX解析

民间解析，数据量大

#### JDOM解析

开放源代码，比DOM解析快

#### DOM4J解析 

第三方提供，开源免费，是JDOM的升级版

## 待续。。。。

