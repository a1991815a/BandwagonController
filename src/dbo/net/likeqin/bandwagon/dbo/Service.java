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
 * 服务类 对应表《SERVICE》
 */
@AnAlias("Service")
@AnTable(table="SERVICE", key="SERVICE_ID", type="InnoDB")
public class Service implements Serializable
{
    private static final long serialVersionUID = 1L;

    @AnTableField(column="SERVICE_ID", type="long", notNull=true)    private long serviceId;    //1.服务ID(自动生成)
    @AnTableField(column="SERVICE_NAME", type="string,64", notNull=true)    private String serviceName;    //2.服务名
    @AnTableField(column="SERVICE_COMMENT", type="string,512", notNull=true)    private String serviceComment;    //3.服务说明

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

    public String getServiceComment()
    {
        return serviceComment;
    }

    public void setServiceComment(String serviceComment)
    {
        this.serviceComment = serviceComment;
    }

}
