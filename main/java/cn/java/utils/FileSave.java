package cn.java.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * description: 将Web上传文件Hash不同名存储,并返回存储路径列表
 * author: YeShenRen
 * date: 2022/3/9
 */
public class FileSave {

    public static List<String> getFilePath(MultipartRequest files, HttpServletRequest request) throws Exception{
        //获取传过来的文件集合
        Map<String, MultipartFile> filesMap = files.getFileMap();
        Set<String> keySet = filesMap.keySet();
        List<String> pathList = new ArrayList<>();
        for (String key : keySet) {
            String fileName = "";
            MultipartFile singleFile = filesMap.get(key);
            //文件名
            String originalFile = singleFile.getOriginalFilename();
            //扩展名
            String extendName = originalFile.substring(originalFile.lastIndexOf(".") + 1, originalFile.length());
            if (!extendName.equals("")) {
                //把文件加上随机数，防止文件重复，并去掉“-”
                String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                fileName = uuid + "_" + "." + extendName;
                String basePath = request.getServletContext().getRealPath("/uploads");
                //3.解决同一文件夹中文件过多问题，每一天建立一个文件夹
                String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                //4.判断路径是否存在
                File file = new File(basePath + "/" + datePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File f = new File(file, fileName);
                //上传
                singleFile.transferTo(f);
                String absolutePath = f.getAbsolutePath();
                String relativePath = "..\\"+absolutePath.substring(absolutePath.indexOf("uploads"), absolutePath.length());
                pathList.add(relativePath);
                System.out.println("文件上传成功:" + f.getAbsolutePath());
            } else {
                pathList.add("");
            }
        }
        return pathList;
    }
}
