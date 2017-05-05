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
 * 命令参数表 对应表《PARAMETER》
 */
@AnAlias("Parameter")
@AnTable(table="PARAMETER", key="PARAMETER_ID", type="InnoDB")
public class Parameter implements Serializable
{
    private static final long serialVersionUID = 1L;

    @AnTableField(column="PARAMETER_ID", type="long", notNull=true)    private long parameterId;    //1.参数ID
    @AnTableField(column="PARAMETER_SHELL", type="string,128", notNull=true)    private String parameterShell;    //2.参数shell
    @AnTableField(column="PARAMETER_COMMENT", type="string,128", notNull=false)    private String parameterComment;    //3.参数说明
    @AnTableField(column="COMMAND_ID", type="long", notNull=true)    private long commandId;    //4.所属命令ID

    public String toString()
    {
        return Jsons.toString(this);
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

    public long getCommandId()
    {
        return commandId;
    }

    public void setCommandId(long commandId)
    {
        this.commandId = commandId;
    }

}
