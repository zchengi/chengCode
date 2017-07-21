package com.cheng.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheng.management.serviceImpl.OrderManageServiceImpl;
import com.cheng.order.povo.DingdanPovo;

@RequestMapping("/ordermanage")
@Controller
public class OrderManageController {
    @Autowired
    private OrderManageServiceImpl orderManageServiceImpl;

    /**
     * 前往订单管理页
     */
    @RequestMapping("/tolist")
    public String toList(Model model) {
        List<DingdanPovo> dingdans = orderManageServiceImpl.toList();
        model.addAttribute("dingdans", dingdans);
        return "/adminjsps/admin/order/list";
    }

    /**
     * 按状态查询
     */
    @RequestMapping("/findbystatus/{status}")
    public String findByStatus(Model model, @PathVariable int status) {
        List<DingdanPovo> dingdans = orderManageServiceImpl
                .findByStatus(status);
        model.addAttribute("dingdans", dingdans);
        return "/adminjsps/admin/order/list";
    }

    /**
     * 查看订单详细信息
     */
    @RequestMapping("/todesc/{oid}")
    public String toDesc(Model model, @PathVariable String oid) {
        DingdanPovo dingdan = orderManageServiceImpl.findByOid(oid);
        model.addAttribute("dingdan", dingdan);
        return "/adminjsps/admin/order/desc";
    }

    /**
     * 订单发货
     */
    @RequestMapping("/deliver/{oid}")
    public String Deliver(Model model, @PathVariable String oid) {
        String msg = orderManageServiceImpl.deliver(oid);
        model.addAttribute("msg", msg);
        model.addAttribute("link", "../tolist");
        return "/adminjsps/admin/msg";
    }

    /**
     * 取消订单
     */
    @RequestMapping("/cancel/{oid}")
    public String Cancel(Model model, @PathVariable String oid) {
        String msg = orderManageServiceImpl.cancel(oid);
        model.addAttribute("msg", msg);
        model.addAttribute("link", "../tolist");
        return "/adminjsps/admin/msg";
    }

}
