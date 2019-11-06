package com.rl.utils;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName
 * @Description base64图片工具类
 * @Author
 * @Date 2019/9/4 10:58
 * @Version 1.0
 **/
public class ImageBase64Utils {
    private static SimpleDateFormat simpleDF = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static Random rand = new Random();

    /**
     * @Descriptionmap 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @author
     * @Date
     * @param path 图片路径
     * @return
     */
    public static String imageToBase64(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
    /**
     * @Descriptionmap 对字节数组字符串进行Base64解码并生成图片
     * @author
     * @Date
     * @param base64Img 图片Base64数据
     * @param path 图片路径
     * @return
     */
    public static String  base64ToImage(String base64Img, String path) {
        if (!StringUtils.isNotBlank(base64Img)) {
            return "";
        }
        // 随机生成图片名
        String random = simpleDF.format(new Date())+rand.nextInt(10000000);
        String suffix = base64Img.substring(base64Img.indexOf("/") + 1, base64Img.indexOf(";"));
        String imageUrl = path+random+"."+suffix;
        BASE64Decoder decoder = new BASE64Decoder();
        //获取解码数据源
        String base64img = base64Img.substring(base64Img.indexOf(",")+1);
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(base64img);
            // 处理数据
            for (int i = 0; i < b.length; i++) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            File dest = new File(imageUrl);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            FileOutputStream out = new FileOutputStream(imageUrl);
            out.write(b);
            out.flush();
            out.close();
            return random+"."+suffix;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 图片上传
     *
     * @param upload
     * @param uploadFileName
     * @param path
     * @return
     * @throws Exception
     */
    public void uploadImage(File upload, String uploadFileName, String path) throws Exception {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(upload);
            File f = new File(path);
            if (!f.exists()) f.mkdirs();
            os = new FileOutputStream(path + "/" + uploadFileName);
            byte buffer[] = new byte[1024];
            int count = 0;
            int flag = 0;
            while ((count = is.read(buffer)) > 0) {
                os.write(buffer, 0, count);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            File f = new File(path + "/" + uploadFileName);
            if (f.exists()) {
                f.delete();
            }
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException ioe) {
            }
        }
    }
}
