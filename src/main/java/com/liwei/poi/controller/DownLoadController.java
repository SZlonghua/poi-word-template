package com.liwei.poi.controller;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Liwei on 2015/11/17.
 */
@Controller
@RequestMapping("/word")
public class DownLoadController {

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(HttpServletRequest request,HttpServletResponse response){
        /**
         * 获取请求参数
         */
        /*String pzjg =  request.getParameter("pzjg"); // 篇章结构
        String gdnr =  request.getParameter("gdnr"); // 观点内容
        String jsyy =  request.getParameter("jsyy"); // 句式运用
        String chyf =  request.getParameter("chyf"); // 词汇语法
        String xzgf =  request.getParameter("xzgf"); // 写作规范*/

        String pzjg =  "篇章结构"; // 篇章结构
        String gdnr =  "观点内容"; // 观点内容
        String jsyy =  "句式运用"; // 句式运用
        String chyf =  "词汇语法"; // 词汇语法
        String xzgf =  "写作规范"; // 写作规范

        // 获取应用的根路径
        String servletContextRealPath = request.getServletContext().getRealPath("");
        // 获取模板文件
        File templateFile = new File(servletContextRealPath + "/template/template1.doc");


        ByteArrayOutputStream ostream = null;
        try {
            FileInputStream in = new FileInputStream(templateFile);
            HWPFDocument hwpfDocument = new HWPFDocument(in);
            // 替换读取到的 word 模板内容的指定字段
            Map<String,String> params = new HashMap<>();
            params.put("se",pzjg);
            params.put("q",gdnr);
            params.put("w",jsyy);
            params.put("e",chyf);
            params.put("r",xzgf);
            Range range = hwpfDocument.getRange();
            for(Map.Entry<String,String> entry:params.entrySet()){
                range.replaceText(entry.getKey(),entry.getValue());
            }
            // 输出 word 内容文件流，提供下载
            response.reset();
            response.setContentType("application/x-msdownload");

            // 随机生成一个文件名
            UUID randomUUID = UUID.randomUUID();
            String attachmentName = randomUUID.toString();
            response.addHeader("Content-Disposition", "attachment; filename=\""+ attachmentName + ".doc\"");
            ostream = new ByteArrayOutputStream();
            ServletOutputStream servletOS = response.getOutputStream();
            hwpfDocument.write(ostream);
            servletOS.write(ostream.toByteArray());
            servletOS.flush();
            servletOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
