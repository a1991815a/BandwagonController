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
 * 命令对应的所有参数 对应视图《COMMAND_PARAMETERS》
 */
@AnAlias("CommandParameters")
@AnView("COMMAND,PARAMETER")
@AnViewJoin({@AnViewJoinValue(type="EQUAL", lTable="COMMAND", lColumn="COMMAND_ID", rTable="PARAMETER", rColumn="COMMAND_ID")})
public class CommandParameters implements Serializable
{
    private static final long serialVersionUID = 1L;

    @AnViewField(table="COMMAND", column="COMMAND_ID")    private long commandId;    //1.命令对应的所有参数
    @AnViewField(table="COMMAND", column="COMMAND_SHELL")    private String commandShell;    //2.命令对应的所有参数
    @AnViewField(table="PARAMETER", column="PARAMETER_ID")    private long parameterId;    //3.命令对应的所有参数
    @AnViewField(table="PARAMETER", column="PARAMETER_SHELL")    private String parameterShell;    //4.命令对应的所有参数
    @AnViewField(table="PARAMETER", column="PARAMETER_COMMENT")    private String parameterComment;    //5.命令对应的所有参数

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

    public long getParameterId()
    {
        return parameterId;
    }

    public void setParameterId(long parameterId)
    {
        this.parameterId = parameterId;
    }

    public String getParameterShell()
    {
        return parameterShell;
    }

    public void setParameterShell(String parameterShell)
    {
        this.parameterShell = parameterShell;
    }

    public String getParameterComment()
    {
        return parameterComment;
    }

    public void setParameterComment(String parameterComment)
    {
        this.parameterComment = parameterComment;
    }

}
