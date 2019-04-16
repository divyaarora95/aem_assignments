package com.ttn.blogs.core.servlets;

import com.day.cq.commons.JSONItem;
        import com.day.cq.wcm.api.Page;
        import com.day.cq.wcm.api.PageManager;
        import jdk.nashorn.internal.ir.debug.JSONWriter;
        import org.apache.jackrabbit.oak.commons.json.JsonObject;
        import org.apache.jackrabbit.oak.jcr.Jcr;
        import org.apache.jackrabbit.vault.util.JcrConstants;
        import org.apache.sling.api.SlingHttpServletRequest;
        import org.apache.sling.api.SlingHttpServletResponse;
        import org.apache.sling.api.resource.Resource;
        import org.apache.sling.api.servlets.HttpConstants;
        import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
        import org.apache.sling.commons.json.JSONArray;
        import org.osgi.framework.Constants;
        import org.osgi.service.component.annotations.Component;

        import javax.jcr.Node;
        import javax.jcr.NodeIterator;
        import javax.servlet.Servlet;
        import javax.servlet.ServletException;
        import javax.xml.ws.http.HTTPException;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.*;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Blog Servlet Processor",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//                "sling.servlet.resourceTypes=" + "/apps/ttn_blogs/components/structure/blog",
 //               "sling.servlet.selectors=" + "display",
                "sling.servlet.extensions=" + "html"
        })
public class ServletAssignment1 extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();
        List<Blogs> list=new ArrayList<>();

        //Displaying Basics Infomation
        printWriter.println("<br />Title of Page: " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
        printWriter.println("<br />Has Child Node: "+resource.hasChildren());

        //Displaying Listing Blogs
        printWriter.print("<br /><br />Displaying All Blogs<br /><br />");
        for(Resource resource1:resource.getChildren()) {
            printWriter.println("<br />---------------------------------------------<br />");
            printWriter.println("<br />Title: "+resource1.getValueMap().get("jcr:title",resource1.getResourceType()));
            printWriter.println("<br />Name: "+resource1.getName());
            printWriter.println("<br />Publish Date: "+resource1.getValueMap().get("blog-date",resource1.getResourceType()));
            printWriter.println("<br />Blog Title: "+resource1.getValueMap().get("blog-title",resource1.getResourceType()));
            printWriter.println("<br />Blog Data: "+resource1.getValueMap().get("blog-data",resource1.getResourceType()));
            printWriter.println("<br />---------------------------------------------<br />");

            list.add(new Blogs(resource1.getValueMap().get("blog-date",resource1.getResourceType()),resource1.getValueMap().get("blog-title",resource1.getResourceType()),resource1.getValueMap().get("blog-title",resource1.getResourceType()),resource1.getValueMap().get("blog-title",resource1.getResourceType())));
        }




        /* **********Getting Sorted Blogs******** */

        String sorting_mode = req.getParameter("sort");

        if (sorting_mode.equals("asc") || sorting_mode.equals("ASC")) {
            printWriter.println("<br />------Displaying blogs in ascending order!------<br />");

            list.sort((Blogs b1, Blogs b2)-> b1.getPublishDate().compareTo(b2.getPublishDate()));

            for(Blogs blogs : list) {
                printWriter.println("<br />"+blogs.toString());
            }

        } else {
            printWriter.println("<br />------Displaying blogs in descending order!------<br />");

            list.sort((Blogs b1, Blogs b2)-> b2.getPublishDate().compareTo(b1.getPublishDate()));

            for(Blogs blogs : list) {
                printWriter.println("<br />"+blogs.toString());
            }

        }

        /***************************************/

    }
}