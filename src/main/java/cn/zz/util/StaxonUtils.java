package cn.zz.util;


import cn.zz.domain.User;
import com.alibaba.fastjson.JSONObject;
import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.json.JsonXMLOutputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019/4/24 08:59
 * @Description: JSON与XML互转
 */
public class StaxonUtils {

    /**
     * json字符串转为xml字符串(去头,前后补充<xml></xml>
     *
     * @param json
     * @return
     */
    public static String jsonConvertXml(String json) {
        StringReader input = new StringReader(json);
        StringWriter output = new StringWriter();
        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).repairingNamespaces(false).build();
        try {
            XMLEventReader reader = new JsonXMLInputFactory(config).createXMLEventReader(input);
            XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(output);
            writer = new PrettyXMLEventWriter(writer);
            writer.add(reader);
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (output.toString().length() >= 38) {
            // remove <?xml version="1.0" encoding="UTF-8"?>
            return "<xml>" + output.toString().substring(39) + "</xml>";
        }
        return output.toString();
    }

    /**
     * xml字符串转为json字符串
     *
     * @param xml
     * @return
     */
    public static String xmlConvertJson(String xml) {
        StringReader input = new StringReader(xml);
        StringWriter output = new StringWriter();
        JsonXMLConfig config = new JsonXMLConfigBuilder().autoArray(true).autoPrimitive(true).prettyPrint(true).build();
        try {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(input);
            XMLEventWriter writer = new JsonXMLOutputFactory(config).createXMLEventWriter(output);
            writer.add(reader);
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return output.toString();
    }

    /**
     * json字符串转换xml字符串 包含[<?xml version="1.0" encoding="UTF-8"?>]
     *
     * @param json
     * @return
     */
    public static String json2xml(String json) {
        StringReader input = new StringReader(json);
        StringWriter output = new StringWriter();
        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).repairingNamespaces(false).build();
        try {
            XMLEventReader reader = new JsonXMLInputFactory(config).createXMLEventReader(input);
            XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(output);
            writer = new PrettyXMLEventWriter(writer);
            writer.add(reader);
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return output.toString();
    }


    /**
     * 去掉转换xml之后的换行和空格
     * @param json
     * @return
     */
    public static String json2xmlReplaceBlank(String json) {
        String str = StaxonUtils.json2xml(json);
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        Map<String, User> map = new HashMap<String, User>();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(20);

        json.put("user", user);
        json.put("name", "lisi");
        json.put("age", 40);
        String jsonString = json.toJSONString();
        System.out.println("JSON:" + jsonString);
        System.out.println("------------------------------------------------");
        String xml = StaxonUtils.jsonConvertXml(jsonString);
        System.out.println("JSON转XML去头前后添加<xml> \n" + xml);
        System.out.println("------------------------------------------------");
        System.out.println("JSON转XML携带头文件 \n" + StaxonUtils.json2xml(jsonString));
        System.out.println("------------------------------------------------");
        System.out.println("XML转JSON \n" + StaxonUtils.xmlConvertJson(xml));
        System.out.println("------------------------------------------------");
        System.out.println("JSON转XML去掉前后空格 \n" + StaxonUtils.json2xmlReplaceBlank(jsonString));
    }
}
