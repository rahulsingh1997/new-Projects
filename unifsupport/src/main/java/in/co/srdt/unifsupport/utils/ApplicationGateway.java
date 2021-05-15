package in.co.srdt.unifsupport.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationGateway {

    @Value("${in.co.srdt.unifsupport.api-gateway}")
    private String appgateway;

    @Value("${in.co.srdt.unifsupport.zoolservernavbar}")
    private String appgatewaynbr;

    public String getAppgatewaynbr() {
        return appgatewaynbr;
    }

    public void setAppgatewaynbr(String appgatewaynbr) {
        this.appgatewaynbr = appgatewaynbr;
    }

    public String getAppgateway() {
        return appgateway;
    }

    public void setAppgateway(String appgateway) {
        this.appgateway = appgateway;
    }
}
