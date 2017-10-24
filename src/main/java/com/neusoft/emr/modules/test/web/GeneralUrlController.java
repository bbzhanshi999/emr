package com.neusoft.emr.modules.test.web;

import com.neusoft.emr.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用url请求处理controller
 * Created by 赵千里 on 2016/5/3 0003.
 */
@RequestMapping(value = "/url")
@Controller
public class GeneralUrlController extends BaseController {


    /**
     * url规则(主tab)
     *
     * @param guid1
     * @return
     */
    @RequestMapping(value = "/{type}/{guid1}")
    public String tab(@PathVariable("guid1") String guid1, Model model, @PathVariable("type") String type) {

        if ("br".equals(type)) {
            model.addAttribute("name", guid1);
            return "gurl/blTabView";
        } else if ("kzt".equals(type)) {

            //todo 控制台页面地址
        }
        addMessage(model, "未找到指定内容，请求错误");

        return "error/500";
    }

    /**
     * 通用url规则(子tab)
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/{type}/{name}/{subtype}/{blid}")
    public String subTab(@PathVariable("name") String name, @PathVariable("blid") String blid,
                         Model model, @PathVariable("type") String type, @PathVariable("subtype") String subtype) {
        //todo 通用url子tab的view方法

        return null;
    }


}
