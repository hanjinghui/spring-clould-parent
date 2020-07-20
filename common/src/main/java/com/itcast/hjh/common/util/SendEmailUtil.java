package com.itcast.hjh.common.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 发送邮件
 */
public class SendEmailUtil{


    /**
     * 可以一次发多个
     * @param emails
     */
    public static String sentEmail(List<String> emails){
        try {
            MailAccount account = getMailAccount();
            MailUtil.send(account,emails,"审核通知","您有新的审核待办，请及时处理！【来源：综合信息化系统】",false);
            return "发送成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败！";
        }
    }
    /**
     * 驳回发送邮件
     * @param emails
     */
    public static String sentRejectEmail(List<String> emails){
        try {
            MailAccount account = getMailAccount();
            MailUtil.send(account,emails,"驳回通知","您发送的审批被驳回，请及时查收！【来源：综合信息化系统】",false);
            return "发送成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败！";
        }
    }
    /**
     * 可以一次发多个
     * @param emails
     */
    public static String sentEmailAndFile(List<String> emails,String headline,String data){
        try {
            MailAccount account = getMailAccount();
            MailUtil.send(account,emails,headline,data,false);
            return "发送成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败！";
        }
    }


    public static Properties loadPropertyFromClasspath(String config) {
        Properties p = new Properties();
        InputStream is = null;
        try {
            is = SendEmailUtil.class.getClassLoader().getResourceAsStream(config);
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return p;
    }

    private static MailAccount getMailAccount (){
        Properties p = SendEmailUtil.loadPropertyFromClasspath("email.properties");
        MailAccount account = new MailAccount();
        account.setHost(p.getProperty("host"));
        account.setPort(Integer.parseInt(p.getProperty("port")));
        account.setAuth(true);
        account.setFrom(p.getProperty("from"));
        account.setUser(p.getProperty("user"));
        account.setPass(p.getProperty("pass"));
        return account;
    }
}
