package cn.kgc.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 控制页面跳转的控制器
* */
@Controller
@RequestMapping("/model")
public class ModelController {

    /*//去到平台首页
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }*/

    //去到入住信息显示页面
    @RequestMapping("/toShowInRoomInfo")
    public String toShowInRoomInfo(){
        return "inRoomInfo/showInRoomInfo";
    }

    //去到入住信息显示页面
    @RequestMapping("/toShowOrders")
    public String toShowOrders(){
        return "orders/showOrders";
    }

    //去到入住信息显示页面
    @RequestMapping("/toSaveInRoomInfo")
    public String toSaveInRoomInfo(){
        return "inRoomInfo/saveInRoomInfo";
    }

    //去到消费记录信息显示页面
    @RequestMapping("/toShowRoomSale")
    public String toShowRoomSale(){
        return "roomSale/showRoomSale";
    }

    //去到vip信息显示页面
    @RequestMapping("/toShowVip")
    public String toShowVip(){
        return "vip/showVip";
    }

    //去到添加vip信息显示页面
    @RequestMapping("/toSaveVip")
    public String toSaveVip(){
        return "vip/saveVip";
    }

    //去到房间信息显示页面
    @RequestMapping("/toShowRooms")
    public String toShowRooms(){
        return "rooms/showRooms";
    }

    //去到房间信息显示页面
    @RequestMapping("/loginUI")
    public String loginUI(){
        return "login/login";
    }

    //去到房间信息显示页面
    @RequestMapping("/toShowRole")
    public String toShowRole(){
        return "role/showRole";
    }

    //去到用户信息显示页面
    @RequestMapping("/toShowUser")
    public String toShowUser(){
        return "user/showUser";
    }


    //去到用户信息显示页面
    @RequestMapping("/toShowIdd")
    public String toShowIdd(){
        return "idd/showIdd";
    }
}
