package com.ttn.core;

import com.adobe.cq.sightly.WCMUsePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import java.util.ArrayList;
import java.util.List;

public class Header extends WCMUsePojo {
    protected final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private List<HeaderBean> desendantList = new ArrayList<>();
    
    @Override
    public void activate() throws Exception {
        Node currentNode = getResource().adaptTo(Node.class);
        NodeIterator nodeIterator = currentNode.getNodes();
        
        while (nodeIterator.hasNext()){
            Node child = nodeIterator.nextNode();
            
            NodeIterator nodeIterator2 = child.getNodes();
            setMultifieldItems(nodeIterator2);
        }
    }
    
    private List<HeaderBean> setMultifieldItems(NodeIterator nodeIterator2) {
        try{
            String navTitle;
            String navLink;
            
            while (nodeIterator2.hasNext()){
                HeaderBean headerBean = new HeaderBean();
                Node desendant = (Node)nodeIterator2.nextNode();
                
                logger.info("desendant's path is: "+desendant.getPath());
                navTitle = desendant.getProperty("menuText").getString();
                navLink = desendant.getProperty("menuLink").getString();
                logger.info("path is : "+navLink);
                
                headerBean.setNavTitle(navTitle);
                headerBean.setNavLink(navLink);
                desendantList.add(headerBean);
            }
        } catch (Exception e) {
            logger.error("Exception in multifield: ", e.getMessage(), e);
        }
        return desendantList;
    }
    
    public List<HeaderBean> getMultifieldItems(){
        return desendantList;
    }
}