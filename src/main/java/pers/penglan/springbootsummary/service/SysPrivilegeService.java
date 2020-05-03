package pers.penglan.springbootsummary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pers.penglan.springbootsummary.mapper.SysPrivilegeMapper;
import pers.penglan.springbootsummary.model.SysPrivilege;

import java.util.List;

/**
 * @Author PENGL
 * 2020-03-22
 */
@Service
public class SysPrivilegeService {
    @Autowired
    private SysPrivilegeMapper sysPrivilegeMapper;

    private int flag = 0;


    public String getSysPrivilegeById(Long id, ModelMap modelMap) {
        modelMap.addAttribute("message", "这个照样运行的好好的啊");
        SysPrivilege sysPrivilege = new SysPrivilege();
        sysPrivilege.setId(id);
        List<SysPrivilege> sysPrivilegeList = sysPrivilegeMapper.selectByIdOrName(sysPrivilege);
        modelMap.addAttribute("message", sysPrivilegeList.toString());
        return "/jsp/notification.jsp";
    }



    public String insertSysPrivilege(ModelMap modelMap) {
        modelMap.addAttribute("message", "这个照样运行的好好的啊");
        SysPrivilege sysPrivilege = new SysPrivilege();
        sysPrivilege.setPrivilegeName("技术支持" + flag++);
        sysPrivilege.setPrivilegeUrl("/technologySupport");
        int account = sysPrivilegeMapper.insertOne(sysPrivilege);
        modelMap.addAttribute("message",
                modelMap.getAttribute("message") +
                        "<br/>" + sysPrivilege.toString() + "==========flag:" + flag);
        //int i = 1 / 0;
        sysPrivilege.setPrivilegeName("技术支持" + flag++);
        account = sysPrivilegeMapper.insertOne(sysPrivilege);
        modelMap.addAttribute("message",
                modelMap.getAttribute("message") +
                        "<br/>" + sysPrivilege.toString() + "==========flag:" + flag);

        return "/jsp/notification.jsp";
    }

    public String updateSysPrivilege(Long id, ModelMap modelMap) {
        modelMap.addAttribute("message", "这个照样运行的好好的啊");
        SysPrivilege sysPrivilege = new SysPrivilege();
        sysPrivilege.setId(id);
        sysPrivilege.setPrivilegeUrl("/flag");
        int account = sysPrivilegeMapper.updateById(sysPrivilege);


        return "/jsp/notification.jsp";
    }
}
