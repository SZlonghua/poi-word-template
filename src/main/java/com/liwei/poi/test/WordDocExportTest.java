package com.liwei.poi.test;

import com.liwei.poi.model.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDocExportTest {
    public static void main(String[] args) throws Exception{
        /** 初始化配置文件 **/
        Configuration configuration = new Configuration();
        /** 设置编码 **/
        configuration.setDefaultEncoding("utf-8");
        /** 我的ftl文件是放在D盘的**/
        //String fileDirectory = "D:\\";
        String fileDirectory = "F:\\IDEA\\test\\poi-word-template\\src\\main\\webapp\\template";
        /** 加载文件 **/
        configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
        /** 加载模板 **/
        Template template = configuration.getTemplate("首件1.ftl");
        /** 准备数据 **/
        Map<String,List<Student>> dataMap = new HashMap<>();

        /** 表格数据初始化 **/
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1","小毅","男","25"));
        studentList.add(new Student("2","小兰","女","25"));
        studentList.add(new Student("3","","",""));
        studentList.add(new Student("4","","",""));
        studentList.add(new Student("5","","",""));

        /** 表格数据 studentList和freemarker标签要对应**/
        dataMap.put("studentList",studentList);

        /** 指定输出word文件的路径 **/
        String outFilePath = "F:\\myFreeMarker.doc";
        File docFile = new File(outFilePath);
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);

        if(out != null){
            out.close();
        }
    }
}
