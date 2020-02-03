package cn.kgc.ssm.controller;

import cn.kgc.ssm.entity.Rooms;
import cn.kgc.ssm.utils.QiNiuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 *   房屋的控制器层
 */
@Controller
@RequestMapping("/rooms")
public class RoomController extends BaseController<Rooms> {
    //上传房屋的封面图片
    @RequestMapping("/uploadRoomPic")
    public @ResponseBody
    Map<String,Object> uploadRoomPic(MultipartFile myFile){
         //return FileUploadUtil.upload(myFile,path);
        return QiNiuUtils.upload(myFile);
    }
}
