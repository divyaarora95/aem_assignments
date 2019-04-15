package com.ttn.core;

import com.adobe.cq.sightly.WCMUsePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import java.util.ArrayList;
import java.util.List;

public class ProductComponent extends WCMUsePojo {
    final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    List<ProductBean> desendantProductList = new ArrayList<>();
    
    @Override
    public void activate() throws Exception {
        Node myNode = getResource().getChild("field").adaptTo(Node.class);
        NodeIterator nodeIterator3 = myNode.getNodes();
        while (nodeIterator3.hasNext()) {
            Node child = (Node)nodeIterator3.nextNode();
            setFieldItems(child);
        }
    }
    
    public List<ProductBean> setFieldItems(Node child) {
        try {
            String reviewerName;
            String productImage;
            String reviewerImage;
            String testimonialHeading;
            String testimonialDescription;
            String productLogo;
    
            reviewerImage=child.getProperty("reviewerImage").getString();
            reviewerName=child.getProperty("reviewerName").getString();
            testimonialHeading= child.getProperty("testimonialHeading").getString();
            testimonialDescription = child.getProperty("testimonialDescription").getString();
            productImage= child.getProperty("productImage").getString();
            productLogo = child.getProperty("productLogo").getString();
            
            ProductBean productBean = new ProductBean();
            
            productBean.setReviewerName(reviewerName);
            productBean.setReviewerImage(reviewerImage);
            productBean.setTestimonialHeading(testimonialHeading);
            productBean.setTestimonialDescription(testimonialDescription);
            productBean.setProductImage(productImage);
            productBean.setProductLogo(productLogo);
            
            desendantProductList.add(productBean);

        } catch (Exception e) {
            logger.error("Exception in multifield: ", e.getMessage(), e);
        }
        return desendantProductList;
    }
    
    public List<ProductBean> getFieldItems() {
        return desendantProductList;
    }
}
