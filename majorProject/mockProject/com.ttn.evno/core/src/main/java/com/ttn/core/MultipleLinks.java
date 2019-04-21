//package com.ttn.core;
//
//import com.adobe.cq.sightly.WCMUsePojo;
//import org.apache.sling.api.resource.Resource;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MultipleLinks extends WCMUsePojo {
//    List<MultiLinksBean> linlkstab2 = new ArrayList();
//    List<MultiLinksBean> linlkstab3 = new ArrayList();
//    List<MultiLinksBean> linlkstab4 = new ArrayList();
//    String validatedlink,result1,result2,result3;
//    @Override
//    public void activate() throws Exception {
//        for (Resource resource : getResource().getChild("linkstab2").getChildren()) {
//
//            result1=validate(resource.getValueMap().get("linkaction",String.class));
//            linlkstab2.add(new MultiLinksBean(resource.getValueMap().get("linkname", String.class), result1));
//        }
//        for (Resource resource : getResource().getChild("linkstab3").getChildren()) {
//            result2=validate(resource.getValueMap().get("linkaction",String.class));
//
//            linlkstab3.add(new MultiLinksBean(resource.getValueMap().get("linkname", String.class), result2));
//        }
//        for (Resource resource : getResource().getChild("linkstab4").getChildren()) {
//            result3=validate(resource.getValueMap().get("linkaction",String.class));
//
//            linlkstab4.add(new MultiLinksBean(resource.getValueMap().get("linkname", String.class),result3));
//        }
//    }
//    public String validate(String link){
//        if(link.startsWith("/content")){
//            if(!(link.endsWith(".html"))){
//                validatedlink=link+".html";
//            }
//            else{
//                validatedlink=link;
//            }
//        }
//        else if(!(link.startsWith("https://")||link.startsWith("http://"))){
//            validatedlink="https://"+link;
//        }
//        else {
//            validatedlink=link;
//        }
//        return validatedlink;
//    }
//
//    public List<MultiLinksBean> getLinlkstab2() {
//        return linlkstab2;
//    }
//
//    public List<MultiLinksBean> getLinlkstab3() {
//        return linlkstab3;
//    }
//
//    public List<MultiLinksBean> getLinlkstab4() {
//        return linlkstab4;
//    }
//
//
//}