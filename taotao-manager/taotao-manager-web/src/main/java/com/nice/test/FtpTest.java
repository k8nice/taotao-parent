package com.nice.test;

import com.nice.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FtpTest {

    @Test
    public void testFtpClient() throws IOException {
        //创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        FileInputStream inputStream = null;
        try {
            //创建ftp连接,默认是21端口
            ftpClient.connect("192.168.174.135",21);
            //登录ftp服务器，使用用户名和密码
            ftpClient.login("ftpuser","nice");
            //上传文件
            //读取本地文件
            inputStream = new FileInputStream(new File("C:\\Users\\ningh\\Pictures\\111.png"));
            //设置上传的路径
            ftpClient.changeWorkingDirectory("/home/ftpuser/images");
            //修改上传文件的格式
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //第一个参数，服务器端文档名
            //第二个参数，上传文档的inputStream
            ftpClient.storeFile("nice.png",inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
            ftpClient.logout();
            //ftpClient.
        }
    }
    @Test
    public void testFtpUtil(){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("C:\\Users\\ningh\\Pictures\\111.png"));
            FtpUtil.uploadFile("192.168.174.135",21,"ftpuser","nice","/home/ftpuser/images","/2019/05/28","nice.png",inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
