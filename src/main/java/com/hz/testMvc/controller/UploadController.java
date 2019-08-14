package com.hz.testMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * 图片上传
 */
@Controller
public class UploadController {

    /**
     * 加载页面
     * @return
     */
    @RequestMapping("/imgUp")
    public String init(){

        return "imgUp";
    }

    @RequestMapping("/image/upload")
    public String imageUpload(@RequestParam CommonsMultipartFile file, ModelMap map)  {

        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();

        String filePath = "D:\\develop\\";
        OutputStream os = null;
        InputStream is = null;

        try {
            //保存的路径
           System.out.println("fileName："+file.getOriginalFilename());
            System.out.println("getOriginalFilename，文件名："+ file.getOriginalFilename());

            os = new FileOutputStream(filePath+file.getOriginalFilename());
//            if(os == null){
//                map.addAttribute("errMsg","请选文件");
//                return "errMsg";
//            }

            //获取上传图片的输入流
             is= file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            return "errMsg";
        } finally {
            try {
                if(os !=null){
                    os.flush();
                    os.close();
                }
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");

        return "/success";
    }
}
