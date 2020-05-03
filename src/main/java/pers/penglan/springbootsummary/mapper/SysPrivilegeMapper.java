package pers.penglan.springbootsummary.mapper;

import org.apache.ibatis.annotations.Param;
import pers.penglan.springbootsummary.model.SysPrivilege;

import java.util.List;
import java.util.Map;

/**
 * @Author PENGL
 * 2020-04-21
 */
public interface SysPrivilegeMapper {
    public List<SysPrivilege> selectByObject(SysPrivilege sysPrivilege);

    public int updateById(SysPrivilege sysPrivilege);

    public int insertOne(SysPrivilege sysPrivilege);

    public List<SysPrivilege> selectByIdOrName(SysPrivilege sysPrivilege);

    public List<SysPrivilege> selectByList(@Param("idList") List<SysPrivilege> sysPrivilegeList);

    public int insertList(@Param("sysPrivilegeList") List<SysPrivilege> sysPrivilegeList);

    public int updateByMap(@Param("sysPrivilegeMap") Map<String, Object> map);

}
