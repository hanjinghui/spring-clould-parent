package com.itcast.hjh.util;

import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import java.io.*;
import java.util.Map;


public class ExcelUtil {


    /**
     * 根据模板创建excel文件
     * @param inputStream excel模板路径
     * @param fileName 导出的文件名称
     * @param data  excel中填充的数据
     * @return
     */
    public static String createExcel( String fileName, Map<String, Object> data,InputStream inputStream ,String excelPath,String path){
        FileOutputStream outputStream = null;

        File file = new File(excelPath);
        try {

            // 定义输出类型
            outputStream =new FileOutputStream(file);

            //FileInputStream inputStream = new FileInputStream(templateFile);
            //获取模板 对象
            InputStream is = new BufferedInputStream(inputStream);

            JxlsHelper jxlsHelper = JxlsHelper.getInstance();
            //Transformer transformer = TransformerFactory.createTransformer(is, outputStream);
            Transformer transformer = jxlsHelper.createTransformer(is, outputStream);

            Context context = new Context();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                context.putVar(entry.getKey(), entry.getValue());
            }

            jxlsHelper.processTemplate(context, transformer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return  path +"excel/"+ fileName;
    }
}
