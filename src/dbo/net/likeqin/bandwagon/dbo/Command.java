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
 * 命令表 对应表《COMMAND》
 */
@AnAlias("Command")
@AnTable(table="COMMAND", key="COMMAND_ID", type="InnoDB")
public class Command implements Serializable
{
    private static final long serialVersionUID = 1L;

    @AnTableField(column="COMMAND_ID", type="long", notNull=true)    private long commandId;    //1.命令ID
    @AnTableField(column="COMMAND_SHELL", type="string,32", notNull=true)    private String commandShell;    //2.命令Shell
    @AnTableField(column="COMMAND_COMMENT", type="string,64", notNull=false)    private String commandComment;    //3.命令说明
    @AnTableField(column="SERVICE_ID", type="long", notNull=true)    private long serviceId;    //4.所属服务ID

    public String toString()
    {
        return Jsons.toString(this);
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

    public long getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(long serviceId)
    {
        this.serviceId = serviceId;
    }

}
