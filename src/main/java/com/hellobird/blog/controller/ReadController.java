package com.hellobird.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HelloBird
 */
@Controller
@RequestMapping("/read")
public class ReadController {
    @RequestMapping
    public String article(Model model){
        model.addAttribute("articleContent","**这是我要显示的文章**\n" +
                "\n" +
                "- asdasdas\n" +
                "- asdasdas\n" +
                "- asdasda\n" +
                "\n" +
                "### 自动配置\n" +
                "\n" +
                "首先看一下pom.xml\n" +
                "\n" +
                "\n" +
                "```xml\n" +
                "    <parent>\n" +
                "        <groupId>org.springframework.boot</groupId>\n" +
                "        <artifactId>spring-boot-starter-parent</artifactId>\n" +
                "        <version>2.3.3.RELEASE</version>\n" +
                "        <relativePath/> <!-- lookup parent from repository -->\n" +
                "    </parent>\n" +
                "```\n" +
                "点击父工程spring-boot-starter-parent可见还有父工程\n" +
                "\n" +
                "```\n" +
                "  <parent>\n" +
                "    <groupId>org.springframework.boot</groupId>\n" +
                "    <artifactId>spring-boot-dependencies</artifactId>\n" +
                "    <version>2.3.3.RELEASE</version>\n" +
                "  </parent>\n" +
                "```\n" +
                "继续查看其父工程 spring-boot-dependencies\n" +
                "\n" +
                "\n" +
                "```\n" +
                " <properties>\n" +
                "    <activemq.version>5.15.13</activemq.version>\n" +
                "    <antlr2.version>2.7.7</antlr2.version>\n" +
                "    <appengine-sdk.version>1.9.81</appengine-sdk.version>\n" +
                "    <artemis.version>2.12.0</artemis.version>\n" +
                "    <aspectj.version>1.9.6</aspectj.version>\n" +
                "    <assertj.version>3.16.1</assertj.version>\n" +
                "    <atomikos.version>4.0.6</atomikos.version>\n" +
                "    <awaitility.version>4.0.3</awaitility.version>\n" +
                "    <bitronix.version>2.1.4</bitronix.version>\n" +
                "    ...\n" +
                "```\n" +
                "我们发现了很多的版本，这就是核心依赖，也就是为什么我们引入一些springboot依赖时可以不用写版本号\n" +
                "\n" +
                "### 启动器\n" +
                "\n" +
                "```xml\n" +
                " <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter</artifactId>\n" +
                " </dependency>\n" +
                "```\n" +
                "\n" +
                "\n" +
                "\n" +
                "- 启动器就是springboot的启动场景\n" +
                "- 比如spring-boot-starter-web就会帮我们自动导入web环境所有的依赖\n" +
                "- 我们要使用什么功能，就只需要找到对应的启动器就行了 starter\n" +
                "\n" +
                "```java\n" +
                "    @SpringBootApplication\n" +
                "    public class DemoApplication {\n" +
                "    \n" +
                "        public static void main(String[] args) {\n" +
                "            SpringApplication.run(DemoApplication.class, args);\n" +
                "        }\n" +
                "    \n" +
                "    }\n" +
                "```\n" +
                "点击@SpringBootApplication注解查看\n" +
                "\n" +
                "```java\n" +
                "    @Target(ElementType.TYPE)\n" +
                "    @Retention(RetentionPolicy.RUNTIME)\n" +
                "    @Documented\n" +
                "    @Inherited\n" +
                "    @SpringBootConfiguration\n" +
                "    @EnableAutoConfiguration\n" +
                "    @ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),\n" +
                "    \t\t@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })\n" +
                "    public @interface SpringBootApplication {\n" +
                "    ...}\n" +
                "```\n" +
                "主要分析    \n" +
                "\n" +
                "- @SpringBootConfiguration\n" +
                "\n" +
                "    点击注解查看发现@Configuration，可知启动类上的SpringBootConfiguration 注解就是标注当前类为配置类  \n" +
                "\n" +
                "- @EnableAutoConfiguration      \n" +
                "    字面意思：自动配置  \n" +
                "    点击注解查看可发现     \n" +
                "    ```java\n" +
                "        @AutoConfigurationPackage  //自动配置包 \n" +
                "        @Import(AutoConfigurationImportSelector.class)\n" +
                "    ```\n" +
                "    查看@AutoConfigurationPackage发现      \n" +
                "   \n" +
                "    ```java\n" +
                "        @Import(AutoConfigurationPackages.Registrar.class)  //自动配置 \"包注册\"\n" +
                "    ```\n" +
                "    \n" +
                "    查看@Import(AutoConfigurationImportSelector.class)\n" +
                "    点击AutoConfigurationImportSelector类\n" +
                "    ```java\n" +
                "    //查看获取自动导入类配置方法\n" +
                "        protected AutoConfigurationEntry getAutoConfigurationEntry(AnnotationMetadata annotationMetadata) {\n" +
                "\t\tif (!isEnabled(annotationMetadata)) {\n" +
                "\t\t\treturn EMPTY_ENTRY;\n" +
                "\t\t}\n" +
                "\t\tAnnotationAttributes attributes = getAttributes(annotationMetadata);\n" +
                "\t\tList<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);\n" +
                "\t\tconfigurations = removeDuplicates(configurations);\n" +
                "\t\tSet<String> exclusions = getExclusions(annotationMetadata, attributes);\n" +
                "\t\tcheckExcludedClasses(configurations, exclusions);\n" +
                "\t\tconfigurations.removeAll(exclusions);\n" +
                "\t\tconfigurations = getConfigurationClassFilter().filter(configurations);\n" +
                "\t\tfireAutoConfigurationImportEvents(configurations, exclusions);\n" +
                "\t\treturn new AutoConfigurationEntry(configurations, exclusions);\n" +
                "\t    }\n" +
                "    ```\n" +
                "    点击\n" +
                "    ```java\n" +
                "    List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);\n" +
                "    ```\n" +
                "    查看获取候选配置方法 getCandidateConfigurations\n" +
                "    ```java\n" +
                "    \tprotected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {\n" +
                "\t\tList<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),\n" +
                "\t\t\t\tgetBeanClassLoader());\n" +
                "\t\tAssert.notEmpty(configurations, \"No auto configuration classes found in META-INF/spring.factories. If you \"\n" +
                "\t\t\t\t+ \"are using a custom packaging, make sure that file is correct.\");\n" +
                "\t\treturn configurations;\n" +
                "\t    }\n" +
                "\t```\n" +
                "    并且getSpringFactoriesLoaderFactoryClass方法是返回EnableAutoConfiguration.class\n" +
                "    ```java\n" +
                "    protected Class<?> getSpringFactoriesLoaderFactoryClass() {\n" +
                "\t\treturn EnableAutoConfiguration.class;\n" +
                "\t}\n" +
                "\t```\n" +
                "    则SpringFactoriesLoader.loadFactoryNames意为查看 哪些类标注了EnableAutoConfiguration注解 \n" +
                "    \n" +
                "    SpringFactoriesLoader是Spring的一个内部加载工厂类，我们自定义的一些ApplicationListener、ApplicationContextInitializer可以通过它加载到内存中，同时starter也必须通过SpringFactoriesLoader把Configuration类加载到内存中，从而被spring解析\n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "\n" +
                "header 1 | header 2\n" +
                "---|---\n" +
                "row 1 col 1 | row 1 col 2\n" +
                "row 2 col 1 | row 2 col 2\n");
        return "read";
    }
}
