package com.rl.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtil {
        /**
         * 上传文件工具
         * @return
         * @throws IOException
         * @throws IllegalStateException
         */
        public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
            targetFile.mkdirs();
         }
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filePath+"/"+fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("文件找不到！");
            }
            out.write(file);
            out.flush();
            out.close();
    }

    /**
     * 文件下载工具
     * @param url
     * @return
     * @throws IOException
     */
    public static ResponseEntity<InputStreamResource> downloadFile(String url) throws IOException {
        FileSystemResource file = new FileSystemResource(url);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //设置文件名并设置文件名编码，解决文件名异常问题
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", new
                String(file.getFilename().getBytes("GBK"),"ISO8859-1")));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    /**
     * @param file     文件
     * @param path     文件存放路径
     * @param fileName 保存的文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName) {
        //确定上传的文件名
        String realPath = path + "/" + fileName;
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
