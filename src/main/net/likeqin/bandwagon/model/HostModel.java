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

import java.io.IOException;

import com.zhiqim.fadfox.annotation.AnAlias;
import com.zhiqim.fadfox.httpd.HttpRequest;
import com.zhiqim.fadfox.util.Linux;

/**
 * 主机操作相关
 *
 * @version v1.0.0 @author likeqin 2017-4-19 新建与整理
 */
@AnAlias("HostModel")
public class HostModel
{
    private static final String HOST_REBOOT = "reboot";
    private static final String HOST_POWEROFF = "poweroff";
    
    /**
     * 重启
     * @param request
     * @return
     * @throws IOException
     */
    public static String reboot(HttpRequest request) throws IOException
    {
        Linux.shell(HOST_REBOOT);
        return HOST_REBOOT;
    }
    
    /**
     * 关机
     * @return
     * @throws IOException
     */
    public static String powerOff() throws IOException
    {
        Linux.shell(HOST_POWEROFF);
        return HOST_POWEROFF;
    }
}
