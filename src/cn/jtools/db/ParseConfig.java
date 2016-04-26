package cn.jtools.db;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;



public class ParseConfig {
	public ArrayList<ConnectionParam> readConfig(){
		ArrayList<ConnectionParam> param = new ArrayList<>();
		
		//得到解析器
		SAXReader saxReader = new SAXReader();
		
		//设置ErrorHandler
		saxReader.setErrorHandler(new DefaultHandler(){
			@Override
			public void error(SAXParseException e) throws SAXException {
				System.out.println(
						e.getSystemId()+"Document error occurred"
						+"column: "+e.getLineNumber()
						+"row:" + e.getColumnNumber());
			}
			
		});
		
		//创建属性结构开始解析
		try {
			Document document = saxReader.read("DBConfig.xml");
			Element root = document.getRootElement();//得到节点
			List<Node> nodes = document.selectNodes("DB-Config/Pool");
			
			for (Node node : nodes) {
				ConnectionParam cp = new ConnectionParam();
				Node driver = node.selectSingleNode("Driver");
				Node user = node.selectSingleNode("User");
				Node password = node.selectSingleNode("PassWord");
				Node url = node.selectSingleNode("Url");
				Node maxConnection = node.selectSingleNode("MaxConnection");
				Node minConnection = node.selectSingleNode("MinConnection");
				Node timeout = node.selectSingleNode("TimeOut");
				Node waittime = node.selectSingleNode("WaitTime");
				Node increamtalConnections = node.selectSingleNode("IncreamtalConnections");
				Node testTable = node.selectSingleNode("TestTable");
				Node type = node.selectSingleNode("Type");
				
				
				cp.setDriver(driver.getStringValue());
				cp.setUser(user.getStringValue());
				cp.setPassword(password.getStringValue());
				cp.setUrl(url.getStringValue());
				cp.setMaxConnection(Integer.valueOf(maxConnection.getStringValue()));
				cp.setMinConnection(Integer.valueOf(minConnection.getStringValue()));
				cp.setTimeout(Long.valueOf(timeout.getStringValue()));
				cp.setWaitTime(Long.valueOf(waittime.getStringValue()));
				cp.setIncreamtalConnections(Integer.valueOf(increamtalConnections.getStringValue()));
				cp.setTestTable(testTable.getStringValue());
				cp.setType(type.getStringValue());
				param.add(cp);
			}
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		
		return param;
	}
}
