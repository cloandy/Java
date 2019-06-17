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
		/*[1]. ͨ��DocumentHelper ����һ��Document����*/
		Document doc = DocumentHelper.createDocument();
		
		/*[2]. ��Ӳ��ҵõ���Ԫ��*/
		Element root = doc.addElement("scores");
		
		/*[3]. Ϊ��Ԫ�������Ԫ��*/
		Element student = root.addElement("student");
		
		/*[4]. ΪstudentԪ���������id*/
		student.addAttribute("ID", "1");
		
		/*[5]. ΪstudentԪ�����������Ԫ��*/
		Element name = student.addElement("name");
		Element course = student.addElement("course");
		Element score = student.addElement("score");
		
		/*[6]. Ϊ��Ԫ������ı�*/
		name.addText("ss");
		course.addText("JAVA");
		score.addText("99");
		
//		/*[7]. ����ļ���xml�ļ�,��ʽ����*/
//		Writer  writer = new FileWriter(new File("src/test/test2.xml"));
//		doc.write(writer);
		
		/*[7]. �����ʽ���õ�xml�ļ�*/
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer =  new XMLWriter(new FileWriter(new File("src/test/test2.xml")),format);
		writer.write(doc);
		
		/*[8]. �ر���Դ*/
		writer.close();
	}
}
