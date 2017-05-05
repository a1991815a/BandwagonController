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

import net.likeqin.bandwagon.dbo.Command;
import net.likeqin.bandwagon.dbo.Parameter;

import com.zhiqim.fadfox.annotation.AnAlias;
import com.zhiqim.fadfox.bootstrap.Global;
import com.zhiqim.fadfox.httpd.HttpRequest;
import com.zhiqim.fadfox.json.Jsons;
import com.zhiqim.fadfox.orm.FTable;
import com.zhiqim.fadfox.orm.fdbo.Selector;
import com.zhiqim.fadfox.util.Ids;
import com.zhiqim.fadfox.util.Validates;

/**
 * 命令相关操作
 *
 * @version v1.0.0 @author likeqin 2017-4-19 新建与整理
 */
@AnAlias("CommandModel")
public class CommandModel
{
    
    
    /**
     * 增加命令设置
     * @param request
     * @throws Exception
     */
    public static void addCommand(HttpRequest request, String commandShell, String commandComment, long serviceId) throws Exception
    {
        Command command = new Command();
        command.setCommandId(Ids.longId());
        command.setCommandShell(commandShell);
        command.setCommandComment(commandComment);
        command.setServiceId(serviceId);
        Global.get(FTable.class).insert(command);
    }

    /**
     * 删除命令设置
     * @param request
     * @throws Exception
     */
    public static void deleteCommand(HttpRequest request, long commandId) throws Exception
    {
        Global.get(FTable.class).delete(Command.class, commandId);
        Global.get(FTable.class).delete(Parameter.class, new Selector().addMust("commandId", commandId));
    }

    /**
     * 查询命令信息
     * @param request
     * @throws Exception
     */
    public static void queryCommand(HttpRequest request, long commandId) throws Exception
    {
        Command command = Global.get(FTable.class).item(Command.class, commandId);
        if(Validates.isEmpty(command))
        {
           request.setResponseError("找不到命令:[" + commandId + "]");
            return;
        }
        request.setResponseResult(Jsons.toString(command));
    }

    /**
     * 更新命令设置
     * @param request
     * @throws Exception
     */
    public static void updateCommand(HttpRequest request, String json) throws Exception
    {
        Command command = Jsons.toObject(json, Command.class);
        Global.get(FTable.class).update(command);
    }
    
}
