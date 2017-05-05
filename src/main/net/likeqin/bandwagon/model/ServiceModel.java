/*
 * 版权所有 (C) 2015 知启蒙(WWW.ZHIQIM.COM) 保留所有权利。 
 * 
 * Download http://www.zhiqim.com/fadfox/ 欢迎加盟[凡狐]兴趣小组。
 *
 * 本文采用《知启蒙许可证》，除非符合许可证，否则不可使该文件！
 * 1、您可以免费使用、修改、合并、出版发行和分发，再授权软件、软件副本及衍生软件；
 * 2、您用于商业用途时，必须在原作者指定的发行站点进行登记；
 * 3、您在使用、修改、合并、出版发行和分发时，必须包含版权声明、许可声明，及保留原作者的著作权、商标等知识产权；
 * 4、您在互联网等大众网络下发行和分发再授权软件、软件副本及衍生软件时，必须在原作者指定的发行站点进行发行和分发；
 * 5、您可以在以下链接获取一个完整的许可证副本。
 * 
 * 许可证链接：http://www.zhiqim.com/licenses/LICENSE
 * 发行站点：http://www.zhiqim.com
 *
 * 除非法律需要或书面同意，软件由原始码方式提供，无任何明示或暗示的保证和条件。详见完整许可证的权限和限制。
 */
package net.likeqin.bandwagon.model;

import java.util.List;

import net.likeqin.bandwagon.dbo.Command;
import net.likeqin.bandwagon.dbo.Parameter;
import net.likeqin.bandwagon.dbo.Service;

import com.zhiqim.fadfox.annotation.AnAlias;
import com.zhiqim.fadfox.bootstrap.Global;
import com.zhiqim.fadfox.httpd.HttpRequest;
import com.zhiqim.fadfox.json.Jsons;
import com.zhiqim.fadfox.orm.FTable;
import com.zhiqim.fadfox.orm.fdbo.Selector;
import com.zhiqim.fadfox.util.Ids;
import com.zhiqim.fadfox.util.Linux;
import com.zhiqim.fadfox.util.Validates;

/**
 * Linux服务相关
 *
 * @version v1.0.0 @author likeqin 2017-4-19 新建与整理
 */
@AnAlias("ServicerModel")
public class ServiceModel
{
    public static final String CENTOS6 = "CentOS6";
    public static final String CENTOS7 = "CentOS7";
    public static final String CENTOS6_SERVICE = "service";
    public static final String CENTOS7_SERVICE = "systemctl";

    public static final String SERVICE_START = "start";
    public static final String SERVICE_STOP = "stop";
    public static final String SERVICE_RESTART = "restart";
    public static final String SERVICE_STATUS = "status";
    public static final String SERVICE_LOAD = "load";
    public static final String SERVICE_UNLOAD = "unload";
    
    public static String getCentOS6Shell(String service, String cmd)
    {
        return CENTOS6_SERVICE + " " + service + " " + cmd;
    }
    
    public static String getCentOS7Shell(String service, String cmd)
    {
        return CENTOS7_SERVICE + " " + cmd + " " + service;
    }
    
    public static String getServiceShell(String service, String cmd) throws Exception
    {
        if(getCentOSVersion().equals(CENTOS6))
            return getCentOS6Shell(service, cmd);
        else if(getCentOSVersion().equals(CENTOS7))
            return getCentOS7Shell(service, cmd);
        
        throw new Exception("不支持的Linux版本：" + getCentOSVersion());
    }
    
    public static String getCentOSVersion()
    {
        return CENTOS7;
    }
    
    public static String startService(String service) throws Exception
    {
        Linux.shell(getServiceShell(service, SERVICE_START));
        return SERVICE_START;
    }
    
    public static String stopService(String service) throws Exception
    {
        Linux.shell(getServiceShell(service, SERVICE_STOP));
        return SERVICE_STOP;
    }
    
    public static String restartService(String service) throws Exception
    {
        Linux.shell(getServiceShell(service, SERVICE_RESTART));
        return SERVICE_RESTART;
    }
    
    public static String loadService(String service) throws Exception
    {
        Linux.shell(getServiceShell(service, SERVICE_LOAD));
        return SERVICE_LOAD;
    }
    
    public static String unloadService(String service) throws Exception
    {
        Linux.shell(getServiceShell(service, SERVICE_UNLOAD));
        return SERVICE_UNLOAD;
    }
    
    public static String statusService(String service) throws Exception
    {
        Linux.shell(getServiceShell(service, SERVICE_STATUS));
        return SERVICE_STATUS;
    }
    
    /**
     * 增加服务设置
     * @param request
     * @throws Exception
     */
    public static void addService(HttpRequest request, String serviceName, String serviceComment) throws Exception
    {
        Service service = new Service();
        service.setServiceId(Ids.longId());
        service.setServiceName(serviceName);
        service.setServiceComment(serviceComment);
        Global.get(FTable.class).insert(service);
    }

    /**
     * 删除服务设置
     * @param request
     * @throws Exception
     */
    public static void deleteService(HttpRequest request, long serviceId) throws Exception
    {
        Global.get(FTable.class).delete(Service.class, serviceId);
        List<Command> commandList = Global.get(FTable.class).list(Command.class, new Selector().addMust("serviceId", serviceId));
        for(Command cmd : commandList)
            Global.get(FTable.class).delete(Parameter.class, new Selector().addMust("commandId", cmd.getCommandId()));
        Global.get(FTable.class).delete(Command.class, new Selector().addMust("serviceId", serviceId));
    }

    /**
     * 查询服务信息
     * @param request
     * @throws Exception
     */
    public static void queryService(HttpRequest request, String serviceId) throws Exception
    {
        String result = "";
        if(Validates.isEmpty(serviceId))
            result = Jsons.toString(Global.get(FTable.class).list(Service.class));
        else
            result = Jsons.toString(Global.get(FTable.class).item(Service.class, serviceId));
        
        if(Validates.isNotEmpty(result))
            request.setResponseResult(result);
        else
            request.setResponseError("没有任何数据！");
    }

    /**
     * 更新服务设置
     * @param request
     * @throws Exception
     */
    public static void updateService(HttpRequest request, String json) throws Exception
    {
        Service service = Jsons.toObject(json, Service.class);
        Global.get(FTable.class).insert(service);
        request.setResponseResult("update");
    }
    
    
}
