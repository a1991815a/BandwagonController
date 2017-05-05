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

import net.likeqin.bandwagon.dbo.Parameter;

import com.zhiqim.fadfox.bootstrap.Global;
import com.zhiqim.fadfox.httpd.HttpRequest;
import com.zhiqim.fadfox.json.Jsons;
import com.zhiqim.fadfox.orm.FTable;
import com.zhiqim.fadfox.orm.fdbo.Selector;
import com.zhiqim.fadfox.util.Ids;
import com.zhiqim.fadfox.util.Validates;

/**
 * 参数相关操作
 *
 * @version v1.0.0 @author likeqin 2017-4-21 新建与整理
 */
public class ParameterModel
{
    
    /**
     * 增加参数设置
     * @param request
     * @throws Exception
     */
    public static void addParameter(HttpRequest request, String parameterShell, String parameterComment, long parameterId) throws Exception
    {
        Parameter parameter = new Parameter();
        parameter.setParameterId(Ids.longId());
        parameter.setParameterShell(parameterShell);
        parameter.setParameterComment(parameterComment);
        parameter.setCommandId(parameterId);
        Global.get(FTable.class).insert(parameter);
    }

    /**
     * 删除参数设置
     * @param request
     * @throws Exception
     */
    public static void deleteParameter(HttpRequest request, long parameterId) throws Exception
    {
        Global.get(FTable.class).delete(Parameter.class, new Selector().addMust("parameterId", parameterId));
    }

    /**
     * 查询参数信息
     * @param request
     * @throws Exception
     */
    public static void queryParameter(HttpRequest request, long parameterId) throws Exception
    {
        Parameter parameter = Global.get(FTable.class).item(Parameter.class, parameterId);
        if(Validates.isEmpty(parameter))
        {
           request.setResponseError("找不到参数:[" + parameterId + "]");
            return;
        }
        request.setResponseResult(Jsons.toString(parameter));
    }

    /**
     * 更新参数设置
     * @param request
     * @throws Exception
     */
    public static void updateParameter(HttpRequest request, String json) throws Exception
    {
        Parameter parameter = Jsons.toObject(json, Parameter.class);
        Global.get(FTable.class).update(parameter);
    }
}
