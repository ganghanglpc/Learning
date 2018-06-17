import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class demo1 {
    /**
       *sax 解析XML文档
       *
    */
    public static  void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
        //1.创建解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();

        //2.得到解析器
        SAXParser parser = factory.newSAXParser();

        //3.得到读取器
        XMLReader reader = parser.getXMLReader();

        //4.设置处理器内容
        ListHandler handler = new ListHandler();
        reader.setContentHandler(handler);

        //5.读取XML文档内容
        reader.parse("src/try.xml");

        List list = handler.getList();
        student s = (student) list.get(1);
        System.out.print(s.getName());
    }
}

/**读取XML文档中的每一个STUDENT信息，并且将其作为对象封装到LIST中去
 * @author lpc 2018.1.29
 */
class ListHandler extends DefaultHandler {
    List<student> list = new ArrayList();
    private student s;
    private String currentName;
    private int flag = 0;

    public List getList(){
        return list;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
       currentName = qName;

       if("student".equals(currentName)){
            s = new student();
       }
       if("name".equals(currentName)){
           flag = 1;
       }
       if("age".equals(currentName)){
           flag = 2;
       }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentName = qName;
        if("student".equals(currentName)){
           list.add(s);
           flag = 0;
           currentName = null;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value;
        if(flag == 1) {
            value =  new String(ch,start,length);
            s.setName(value);
        }else if (flag == 2){
            value =  new String(ch,start,length);
            s.setAge(value);
        }
        flag = 0;
    }

}

class student{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
