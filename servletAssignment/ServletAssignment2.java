package com.ttn.blogs.core.servlets;
import org.apache.jackrabbit.vault.util.JcrConstants;
        import org.apache.sling.api.SlingHttpServletRequest;
        import org.apache.sling.api.SlingHttpServletResponse;
        import org.apache.sling.api.resource.Resource;
        import org.apache.sling.api.resource.ResourceResolver;
        import org.apache.sling.api.servlets.HttpConstants;
        import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
        import org.osgi.framework.Constants;
        import org.osgi.service.component.annotations.Component;
        import javax.servlet.Servlet;
        import javax.servlet.ServletException;
        import java.io.*;

@Component(service=Servlet.class,
        property={
                Constants.SERVICE_DESCRIPTION + "=Print Blog in PDF",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths="+ "/content/ttn_blogs/blogtrial/jcr:content",
                "sling.servlet.selectors=" + "print",
                "sling.servlet.extensions=" + "html"
        })
public class ServletAssignment2 extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter=resp.getWriter();

        String resourcePath=req.getRequestPathInfo().getResourcePath();
        ResourceResolver resourceResolver = req.getResourceResolver();
        Resource resource = resourceResolver.getResource(resourcePath);

        //Displaying Blogs
        printWriter.print("<br /><br />Displaying All Blogs<br /><br />");
        for(Resource resource1:resource.getChildren()) {
            printWriter.println("<br />---------------------------------------------<br />");
            printWriter.println("<br />Title: "+resource1.getValueMap().get("jcr:title",resource1.getResourceType()));
            printWriter.println("<br />Name: "+resource1.getName());
            printWriter.println("<br />Publish Date: "+resource1.getValueMap().get("blog-date",resource1.getResourceType()));
            printWriter.println("<br />Blog Title: "+resource1.getValueMap().get("blog-title",resource1.getResourceType()));
            printWriter.println("<br />Blog Data: "+resource1.getValueMap().get("blog-data",resource1.getResourceType()));
            printWriter.println("<br />---------------------------------------------<br />");
        }

    }
}
