package top.robotman.luggage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.robotman.luggage.bean.Result;
import top.robotman.luggage.bean.User;
import top.robotman.luggage.bean.UserVO;
import top.robotman.luggage.service.UserService;
import top.robotman.luggage.util.FileUtil;
import top.robotman.luggage.util.ResultUtil;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.Map;


@RestController
public class TestController {
    @Autowired
    private UserService userService;
//    @Value("${web.upload-path}")
//    private String path;
    @Autowired
    private FileUtil fileUtil;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<User> test(){
        //User user = userService.addUser();
        //userService.searchUser("");
        return userService.searchUser("");
    }

    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public String test_get(@RequestParam(value = "name",defaultValue = "sss")String name){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + name + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        //User user = userService.addUser();
        //userService.searchUser("");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>" + name + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        return name;
    }

    @RequestMapping(value = "/test02",method = RequestMethod.POST)
    public User test_post(@RequestBody User param){
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + name + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        //User user = userService.addUser();
        //userService.searchUser("");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>" + param.getUsername() + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>" + param.getUserpass() + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>" + param.getUserhimg() + ">>>>>>>>>>>>>>>>>>>>>>>>>");

        return param;
    }

    @RequestMapping(value = "/test03",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> test_post(@RequestParam(name = "file") MultipartFile file){
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + name + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        //User user = userService.addUser();
        //userService.searchUser("");
        Map<String,Object> result = fileUtil.uploadFile(file);

        return result;
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public Result test_regist(@RequestBody UserVO param){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + param.getPhonenum()+ ">>>>>>>>>>>>>>>>>>>>>>>>>");

        //User user = userService.addUser();
        //userService.searchUser("");
        String str = "程序猿最帅";
        return  ResultUtil.success(param);
    }



//    /**
//     * 保存图片
//     * @param image   上传的图片
//     * @return
//     */
//    public Object saveImage(MultipartFile image) {
//
//        if(null == image) {
//            return "上传图片不能为空";
//        }
//
//        //获取图片类型
//        String exName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
//        //使用工具类UUID给图片重命名
//        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + exName;
//        //为了便于我们查找图片，将保存路径以 年 / 月 / 日 / 的格式命名
//        StringBuilder realPath = new StringBuilder(path);
//        realPath.append(DateUtils.getYear() + File.separator + DateUtils.getMonth() + File.separator + DateUtils.getDay() + File.separator);
//        realPath.append(fileName);
//
//        File file = new File(realPath.toString());
//        if(!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//
//        try {
//            image.transferTo(file);
//        } catch (IllegalStateException | IOException e) {
//            e.printStackTrace();
//            return "请重新上传图片";
//        }
//
//        //将图片的保存路径realPath保存到数据库中
//        /* .............. */
//
//        return "图片保存成功";
//    }
//
//    @RequestMapping(value = "/setFileUpload", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseResult setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file) {
//        ResponseResult result = new ResponseResult();
//        try {
//            Map<String, Object> resultMap = upload(file);
//            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
//                result.setCode(IStatusMessage.SystemStatus.PARAM_ERROR.getCode());
//                result.setMessage((String) resultMap.get("msg"));
//                return result;
//            }
//            result.setData(resultMap);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
//            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
//            result.setMessage(IStatusMessage.FILE_UPLOAD_ERROR);
//        }
//        return result;
//    }
//
//    private Map<String, Object> upload(MultipartFile file) throws ServiceException {
//        Map<String, Object> returnMap = new HashMap<>();
//        try {
//            if (!file.isEmpty()) {
//                Map<String, Object> picMap = fileUpAndDownService.uploadPicture(file);
//                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
//                    return picMap;
//                } else {
//                    returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
//                    returnMap.put("msg", picMap.get("result"));
//                }
//            } else {
//                LOGGER.info(">>>>>>上传图片为空文件");
//                returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
//                returnMap.put("msg", IStatusMessage.FILE_UPLOAD_NULL);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ServiceException(IStatusMessage.FILE_UPLOAD_ERROR);
//        }
//        return returnMap;
//    }


}
