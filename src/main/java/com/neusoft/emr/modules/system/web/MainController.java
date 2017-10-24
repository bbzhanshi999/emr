package com.neusoft.emr.modules.system.web;

import com.google.common.collect.Maps;
import com.neusoft.emr.common.utils.SessionCacheUtils;
import com.neusoft.emr.common.utils.StringUtils;
import com.neusoft.emr.common.utils.UserUtils;
import com.neusoft.emr.common.web.BaseController;
import com.neusoft.emr.modules.basic.dao.OfficeDao;
import com.neusoft.emr.modules.system.entity.Role;
import com.neusoft.emr.modules.system.entity.User;
import com.neusoft.emr.modules.system.service.MenuService;
import com.neusoft.emr.modules.system.service.PermissionService;
import com.neusoft.emr.modules.system.service.SystemService;
import com.neusoft.emr.modules.system.viewEntity.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 主界面展示控制
 * Created by zql on 2016/5/16 0016.
 */
@RequestMapping("/main")
@Controller
public class MainController extends BaseController {


    @Autowired
    MenuService menuService;

    @Autowired
    SystemService systemService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    OfficeDao officeDao;


    /**
     * 生成主页
     *
     * @param model
     * @return
     */
    @RequestMapping("/mainView")
    public String mainView(HttpSession session, Model model, String glGuid) {

        RoleQueryVo role;
        if (StringUtils.isBlank(glGuid)) {
            role = (RoleQueryVo) session.getAttribute(Role.KEY_CURRROLE);
        } else {
            role = permissionService.getRoleView(glGuid);
        }
        if (role == null) {
            model.addAttribute("errorMsg", "无指定角色");
            model.addAttribute("success", false);
            return "/login.jsp";
        }

        Map<String, Object> activeUsers = UserUtils.getActiveUsers();

        User activeUser = UserUtils.getActiveUser("1");

        SessionCacheUtils.setCurrentRole(role);

        model.addAttribute(Role.KEY_CURRROLE, role);
        model.addAttribute("user", UserUtils.getUser());
        model.addAttribute("success", true);
        return "index";
    }


    /**
     * 返回当前角色拥有的患者清单
     *
     * @return
     */
    @RequestMapping("/patientList")
    public Map<String, Object> patientList() {
        Map<String, Object> map = Maps.newHashMap();
        RoleQueryVo role = SessionCacheUtils.getCurrentRole();


        return map;
    }

}
