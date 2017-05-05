/*
 * 版权所有 (C) 2015 知启蒙(WWW.ZHIQIM.COM) 保留所有权利。
 *
 * Download http://www.zhiqim.com/fadfox/ 欢迎加盟[凡狐]兴趣小组。
 *
 * 由数据库字典自动生成的类文件，修改请使用数据库字典编辑器修改。
 */
package net.likeqin.bandwagon.dbo;

import java.io.Serializable;

import com.zhiqim.fadfox.annotation.AnAlias;
import com.zhiqim.fadfox.json.Jsons;
import com.zhiqim.fadfox.orm.annotation.*;

/**
 * 服务对应的所有命令 对应视图《SERVICE_COMMANDS》
 */
@AnAlias("ServiceCommands")
@AnView("SERVICE,COMMAND")
@AnViewJoin({@AnViewJoinValue(type="EQUAL", lTable="SERVICE", lColumn="SERVICE_ID", rTable="COMMAND", rColumn="SERVICE_ID")})
public class ServiceCommands implements Serializable
{
    private static final long serialVersionUID = 1L;

    @AnViewField(table="SERVICE", column="SERVICE_ID")    private long serviceId;    //1.服务对应的所有命令
    @AnViewField(table="SERVICE", column="SERVICE_NAME")    private String serviceName;    //2.服务对应的所有命令
    @AnViewField(table="COMMAND", column="COMMAND_ID")    private long commandId;    //3.服务对应的所有命令
    @AnViewField(table="COMMAND", column="COMMAND_SHELL")    private String commandShell;    //4.服务对应的所有命令
    @AnViewField(table="COMMAND", column="COMMAND_COMMENT")    private String commandComment;    //5.服务对应的所有命令

    public String toString()
    {
        return Jsons.toString(this);
    }

    public long getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(long serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public long getCommandId()
    {
        return commandId;
    }

    public void setCommandId(long commandId)
    {
        this.commandId = commandId;
    }

    public String getCommandShell()
    {
        return commandShell;
    }

    public void setCommandShell(String commandShell)
    {
        this.commandShell = commandShell;
    }

    public String getCommandComment()
    {
        return commandComment;
    }

    public void setCommandComment(String commandComment)
    {
        this.commandComment = commandComment;
    }

}
