# Servlet
自定义的 servlet 继承自 `HttpServlet`，分别重写 `doGet()` 等。

自定义完成的 `servlet` 可以通过 Bean 注入的方式，也可以通过`@WebServlet(urlPatterns = "/my", description = "自定义的 Servlet")`注解，然后通过`@ServletComponentScan`扫描。

# Filter
自定义的 Filter 实现 `Filter`，分别实现`init()`、`doFilter()`、`destroy()` 等。

自定义完成的 `Filter` 可以通过 Bean 注入的方式，也可以通过`@WebFilter(filterName = "myFilter", urlPatterns = "/*", description = "自定义的过滤器")`注解，然后通过`@ServletComponentScan`扫描。


# Listener
Listener可以监听容器中某一执行动作，并根据其要求做出相应的响应。   

常用的Web事件的监听接口如下：
- ServletContextListener：用于监听Web的启动及关闭
- ServletContextAttributeListener：用于监听ServletContext范围内属性的改变
- ServletRequestListener：用于监听用户请求
- ServletRequestAttributeListener：用于监听ServletRequest范围属性的改变
- HttpSessionListener：用于监听用户session的开始及结束
- HttpSessionAttributeListener：用于监听HttpSession范围内的属性改变

# interceptor
WebMvcConfigurerAdapter已过时
Spring Boot2.0的版本（创建的时候自动选择的这个版本），然后编译器告诉我WebMvcConfigurerAdapter已过时了
```java_holder_method_tree
@Deprecated
public abstract class WebMvcConfigurerAdapter implements WebMvcConfigurer {

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    }
}
```
新的实现是： 
```java_holder_method_tree
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {
  //省略
}
/**
* 推荐
*/
@Configuration
public class WebMvcConfg extends WebMvcConfigurationSupport {
  //省略
}

```
 