# 静态资源处理：
```
"classpath:/META-INF/resources/"
"classpath:/resources/"
"classpath:/static/"
"classpath:/public/"
```
优先级：resources>static>public

我们也可以自己通过配置文件来指定一下，哪些文件夹是需要我们放静态资源文件的，在application.properties中配置；
```
spring.resources.static-locations=classpath:/coding/,classpath:/ming/
```

springboot 中有许多xxx Configuration 帮助我们进行扩展配置，需要注意！

# 页面配置
1.所有页面的配置都要由模板引擎的接管
2.url: @{}
# 页面国际化：
1.配置i18n文件
2.如果需要在项目中进行按钮自动切换，需要自定义一个组件LocaleResolver
3.记得将组件装配到spring容器中
4.#{}