package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class testxml2 {

	public static void main(String[] args) throws IOException {
		/*[1]. 通过DocumentHelper 生成一个Document对象*/
		Document doc = DocumentHelper.createDocument();
		
		/*[2]. 添加并且得到根元素*/
		Element root = doc.addElement("scores");
		
		/*[3]. 为根元素添加子元素*/
		Element student = root.addElement("student");
		
		/*[4]. 为student元素添加属性id*/
		student.addAttribute("ID", "1");
		
		/*[5]. 为student元素添加三个子元素*/
		Element name = student.addElement("name");
		Element course = student.addElement("course");
		Element score = student.addElement("score");
		
		/*[6]. 为子元素添加文本*/
		name.addText("ss");
		course.addText("JAVA");
		score.addText("99");
		
//		/*[7]. 输出文件到xml文件,格式不好*/
//		Writer  writer = new FileWriter(new File("src/test/test2.xml"));
//		doc.write(writer);
		
		/*[7]. 输出格式良好的xml文件*/
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer =  new XMLWriter(new FileWriter(new File("src/test/test2.xml")),format);
		writer.write(doc);
		
		/*[8]. 关闭资源*/
		writer.close();
	}
}
