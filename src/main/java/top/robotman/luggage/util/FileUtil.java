package top.robotman.luggage.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import top.robotman.luggage.properties.ImgUpdateProperties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class FileUtil {
    @Autowired
    private ImgUpdateProperties imgUpdateProperties;

    public Map<String, Object> uploadFile(MultipartFile file) {
        String[] IMAGE_TYPE = imgUpdateProperties.getImageType().split(",");
        Map<String, Object> resMap = new HashMap<>();

        boolean flag = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            // 获得文件类型
            String fileType = file.getContentType();
            String type = fileType.substring(fileType.indexOf("/") + 1);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");

            String oldname = file.getOriginalFilename();
            String newFileName = uuid + "." + type;
            // 年月日文件夹
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String basedir = sdf.format(new Date());

            String path = imgUpdateProperties.getUpPath() + "/" + basedir + "/" + newFileName;
            // 进行压缩(大于4M)
            File oldFile = new File(path);
            if (!oldFile.exists()) {
                oldFile.mkdirs();
            }
            if (file.getSize() > imgUpdateProperties.getFileSize()) {
                // 重新生成
//                String newUUID = UUID.randomUUID().toString().replaceAll("-", "");
//                newFileName = newUUID + "." + imageName;
                // 如果目录不存在则创建目录
                try {
                    file.transferTo(oldFile);
                    // 压缩图片
                    Thumbnails.of(oldFile).scale(imgUpdateProperties.getScaleRatio()).toFile(path);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    file.transferTo(oldFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 显示路径
            resMap.put("path", path);
            resMap.put("oldFileName", oldname);
            resMap.put("newFileName", newFileName);
            resMap.put("fileSize", file.getSize());
            System.out.println(">>>>>>>fileType>>>>>>>>>>" + fileType + ">>>>>>>>>>uuid>>>" + oldname);
        } else {
            resMap.put("result", "图片格式不正确，支持png|jpg|jpeg");
        }
        return resMap;
    }
}
