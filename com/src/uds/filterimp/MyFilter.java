package uds.filterimp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filters) throws IOException, ServletException {
        log.info("request:[{}],res:[{}],filter:[{}]", servletRequest,servletResponse,filters);
        filters.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
