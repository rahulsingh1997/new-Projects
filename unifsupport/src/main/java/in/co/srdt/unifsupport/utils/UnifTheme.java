package in.co.srdt.unifsupport.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UnifTheme {

    @Value("${in.co.srdt.unifsupport.theme}")
    private String appTheme;

    public String getAppTheme() {
        return appTheme;
    }

    public void setAppTheme(String appTheme) {
        this.appTheme = appTheme;
    }
}
