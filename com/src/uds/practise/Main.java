package uds.practise;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uds.filterimp.MyFilter;
import uds.servletimp.HelloServlet;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        log.info("hello,everybody!");

        Server server = new Server();
        // 创建一个HTTP的连接，配置监听主机，端口，以及超时时间
        ServerConnector http = new ServerConnector(server);
        http.setHost("localhost");
        http.setPort(8080);
        http.setIdleTimeout(30000);

        // 将此连接添加到Server
        server.addConnector(http);
        //ServletHandler通过一个servlet创建了一个非常简单的context处理器
        //这个处理器需要在Server上注册
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        //传入能匹配到这个servlet的路径
        //提示：这是一个未经处理的servlet，没有通过web.xml或@WebServlet注解或其他方式配置
        handler.addServletWithMapping(HelloServlet.class, "/v1");
        //增加过滤器filter
        handler.addFilterWithMapping(MyFilter.class,"/*", EnumSet.of(DispatcherType.REQUEST));
        //启动应用服务并等待请求
        server.start();
        server.join();
    }
}
