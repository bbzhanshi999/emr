package com.neusoft.emr.modules.test.web;

import com.neusoft.emr.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试session替换
 * Created by Administrator on 2016/5/3 0003.
 */
@Controller
@RequestMapping(value = "session")
public class redisSessionTestController extends BaseController {



    @RequestMapping(value = "setSession")
    public String setSession(HttpServletRequest request) {

        request.getSession().setAttribute("id", "nima");
        System.out.println(request.getCookies());
        System.out.println(request.getSession().getId());

        logger.info("测试" + request.getSession().getId());
        return "sessionSucess";
    }

    @RequestMapping(value = "getSession")
    public void getSession(HttpServletRequest request, String id) {
        System.out.println(request.getCookies());

        System.out.println(request.getSession().getAttribute("id"));
        System.out.println(request.getSession().getId());

    }

}
