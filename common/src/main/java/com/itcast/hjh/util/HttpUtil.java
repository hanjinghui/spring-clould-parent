
package com.itcast.hjh.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpUtil {

    public static String post(String url,Map<String, Object> params) throws Exception {

        //原始写法
        String returnValue = "";
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(3000); // 连接主机超时毫秒数
        client.getHttpConnectionManager().getParams().setSoTimeout(50000); // 从主机读取数据超时毫秒数
        PostMethod post = new PostMethod(url);
        // 设置参数格式，防止中文乱码
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

        for (Entry<String, Object> set :params.entrySet()) {
            post.setParameter(set.getKey(),set.getValue()+"");
        }
        try {
            client.executeMethod(post);
            returnValue = post.getResponseBodyAsString();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return returnValue;


    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        /*jsonObject.put("adminid","222222222222");
        jsonObject.put("adminname","222222222222");
        jsonObject.put("roleid","1");
        jsonObject.put("password","222222222222");*/

       // jsonObject.put("username","admin");
       // jsonObject.put("password","192023a7bbd73250516f069df18b500");
       /* jsonObject.put("pageCur","1");
        jsonObject.put("pageNum","20");
        jsonObject.put("pageSort","0");
        jsonObject.put("name","");*/
        //String json = "{\"username\":\"admin\",\"password\":\"192023a7bbd73250516f069df18b500\"}";
        String json = "{pageCur:'1',pageNum:'20',pageSort:'0',name:''}";

        // String json = "{\"adminid\":\"admin1008622223333\",\"adminname\":\"cesssss33333\",\"roleid\":\"1\",\"password\":\"2222\"}";

        map.put("data",json);
        String json2 = HttpUtil.post("http://192.168.1.108/post/admin/adminGetByPage",map);
        System.out.println(json2);
    }

}

