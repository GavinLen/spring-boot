package xyz.ieden.base;

/**
 * @author lianghongwei01
 * @date 2019/1/18 16:06
 */
public class StringTest {



    public static void main(String[] args) {

        /**
         * CDN 显示 URL
         */
        String CDN_URL = "http://pic3.58cdn.com.cn";
        /**
         * CDN 内网 URL
         */
        String CDN_INTRANET_URL = "http://pic1.web.58dns.org";

        String certificate = "http://pic3.58cdn.com.cn/crmfang/n_v283a17f9b5411423f9077d4dcf406786b.jpg";

        certificate = certificate.replaceAll(CDN_URL, CDN_INTRANET_URL);
        System.out.println(certificate);
    }
}
