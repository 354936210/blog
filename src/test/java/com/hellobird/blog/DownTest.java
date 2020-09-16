package com.hellobird.blog;

import sun.net.www.content.image.gif;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author HelloBird
 */
public class DownTest {
//    http://www.lzqcode.com/plus/dedemao-comment/face/wx.gif
    public static void main(String[] args) {
//        String url = "http://www.lzqcode.com/plus/dedemao-comment/face/";
//        String[] alt = {"wx", "pz", "se", "fd", "ku", "ll", "hx", "bz", "dk", "gg", "fl", "tp", "cy", "jingkong", "ng", "lh", "zk", "tu", "tx", "ka", "by", "am", "je", "kun", "jk", "lh", "hanxiao", "db", "fd", "zm", "yw", "xu", "yun", "zm", "shuai",  "qd", "zj", "ch", "kb", "gz", "qdl", "hx", "zhh", "yhh", "hq", "bs", "wq", "kkl", "yx", "qq", "xia", "yb", "qiang", "ruo", "ws", "sl", "bq", "jl", "ybjc", "nj", "lbx", "qfwbs", "hlszj", "klbx", "bz2", "tx2", "lh2", "ka2", "gg2", "fd2", "luanqin", "mb", "xieshi", "cywx", "wxkbk", "huaixiao2"};
//        for (int i = 0; i < alt.length; i++) {
//            String downurl=url+alt[i]+".gif ";
//            downloadPicture(downurl,alt[i]);
//        }

        downloadPicture("http://www.lzqcode.com/plus/dedemao-comment/img/s.gif","s.gif");
    }
    //链接url下载图片
    private static void downloadPicture(String urlList,String name) {
        URL url = null;
        int imageNumber = 0;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName =  "D:/downtest/"+name;

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
