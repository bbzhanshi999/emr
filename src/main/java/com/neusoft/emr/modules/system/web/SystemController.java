package com.neusoft.emr.modules.system.web;

import com.neusoft.emr.common.utils.Exceptions;
import com.neusoft.emr.common.utils.SessionCacheUtils;
import com.neusoft.emr.common.utils.UserUtils;
import com.neusoft.emr.common.utils.ValidateCode;
import com.neusoft.emr.common.web.BaseController;
import com.neusoft.emr.modules.system.entity.User;
import com.neusoft.emr.modules.system.service.SystemService;
import com.neusoft.emr.modules.system.viewEntity.RoleQueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统功能处理
 * Created by 赵千里 on 2016/5/13 0013.
 */
@Controller
@RequestMapping(value = "/sys")
public class SystemController extends BaseController {


    @Resource
    private SystemService systemService;

    /**
     * 用户登录
     * @param session
     * @param username
     * @param password
     * @param code
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpSession session, String username, String password, String code) {

        Map<String, Object> map = systemService.toLogin(session, username, password, code);

        return map;
    }


    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {

        if(UserUtils.getUser()!=null){
            UserUtils.logoutUser();
        }
        session.invalidate();
        return "redirect:/login.jsp";
    }

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getvcode", method = RequestMethod.GET)
    public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {

        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(80, 36, 4, 20);
        session.setAttribute("validateCode", vCode.getCode());
        try {
            vCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(Exceptions.getStackTraceAsString(e));
        }
    }

    /**
     * 更新密码
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePassword(String username, String password) {
        Map<String, Object> map = systemService.updatePassword(username, password);
        return map;
    }

    /**
     * 修改密码
     *
     * @param request
     * @param password
     * @return
     */
    @RequestMapping(value = "/changepwd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> changepwd(HttpServletRequest request, String password) {
        User user = (User) request.getSession().getAttribute("user");
        Map<String, Object> map = systemService.changepwd(password, user.getGuid());
        return map;
    }

    /**
     * 将捕捉的异常显示至前台,状态码设置成500
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/error", produces = "application/json")
    @ResponseBody
    public Map<String, Object> handle(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 500);
        map.put("reason", request.getAttribute("javax.servlet.error.message"));

        return map;
    }

    /**
     * 返回当前用户角色清单
     *
     * @return
     */
    @RequestMapping(value = "/getRoles")
    @ResponseBody
    public Map<String, Object> getRoles(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RoleQueryVo.KEY_ROLES, SessionCacheUtils.getRoles());

        return map;
    }
}
