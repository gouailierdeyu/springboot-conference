/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 *
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package conference.Utils.wechat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * XMLParse class
 *
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
public class XMLParse {

	 static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	static  DocumentBuilder db;

	static {
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public XMLParse() throws ParserConfigurationException {
	}

	/**
	 * 提取出xml数据包中的加密消息
	 * @param xmltext 待提取的xml字符串
	 * @return 提取出的加密消息字符串
	 * @throws AesException
	 */
	public static Object[] extract(String xmltext) throws AesException     {
		Object[] result = new Object[3];
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xmltext);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			NodeList nodelist2 = root.getElementsByTagName("ToUserName");
			result[0] = 0;
			result[1] = nodelist1.item(0).getTextContent();
			result[2] = nodelist2.item(0).getTextContent();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ParseXmlError);
		}
	}

	/**
	 * 提取发送人的id
	 * @param xmltext 消息内容
	 * @return 回复人id
	 * @throws IOException
	 * @throws SAXException
	 */
	public static String extractFromUserName(String xmltext) throws IOException, SAXException {
		StringReader sr = new StringReader(xmltext);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		NodeList nodelist = root.getElementsByTagName("ToUserName");
		String FromUserName= nodelist.item(0).getTextContent();
		return FromUserName;
	}

	/**
	 * 提取收信人id
	 * @param xmltext 消息内容
	 * @return 收信人id
	 * @throws IOException
	 * @throws SAXException
	 */
	public static String extractToUserName(String xmltext) throws IOException, SAXException {
		StringReader sr = new StringReader(xmltext);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		NodeList nodelist = root.getElementsByTagName("FromUserName");
		String ToUserName= nodelist.item(0).getTextContent();
		return ToUserName;
	}


	public static String generateText(String toUserName, String fromUserName, long createTime, String content) {
		String textFormat="<xml>\n" +
				"  <ToUserName><![CDATA[%1$s]]></ToUserName>\n" +
				"  <FromUserName><![CDATA[%2$s]]></FromUserName>\n" +
				"  <CreateTime>%3$d</CreateTime>\n" +
				"  <MsgType><![CDATA[text]]></MsgType>\n" +
				"  <Content><![CDATA[%4$s]]></Content>\n" +
				"</xml>";
		return String.format(textFormat, toUserName, fromUserName, createTime, content);

	}
	/**
	 * 生成xml消息
	 * @param encrypt 加密后的消息密文
	 * @param signature 安全签名
	 * @param timestamp 时间戳
	 * @param nonce 随机字符串
	 * @return 生成的xml字符串
	 */
	public static String generate(String encrypt, String signature, String timestamp, String nonce) {

		String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
				+ "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
				+ "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
		return String.format(format, encrypt, signature, timestamp, nonce);

	}

	/**
	 * 从xml中获取标签中的文本
	 * @param xml
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String getValueFromXml(String xml, String key) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xml);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName(key);
			if(nodelist1==null||nodelist1.getLength()==0){
				return null;
			}
			return nodelist1.item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
