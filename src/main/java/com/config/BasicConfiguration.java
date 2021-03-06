//package com.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class BasicConfiguration extends WebSecurityConfigurerAdapter {
//	/**
//	 * Security 配置多個使用者
//	 * */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication() // 项目启动 账户-密码-角色 信息保存进内存中
//		.withUser("alex").password("alex").roles("VIP1")
//		.and().withUser("alex2").password("alex2").roles("VIP1, VIP2")
//		.and().withUser("alex3").password("alex3").roles("VIP1", "VIP2", "VIP3");
////		 new BCryptPasswordEncoder().encode("DDD");
//	}
//
//	/**
//	 * 授權
//	 * */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// 禁止隧道 // 禁止跨域 // 禁止头部 
//		http.csrf().disable().cors().disable().headers().disable();
//		
//		// 所有的人都可以访问的路径
//        http.authorizeRequests().antMatchers("/", "/webjars/**", "/static/**").permitAll()
//                // VIP1的用户可以访问level1下的所有路径
//                .antMatchers("/level1/**").hasRole("VIP1")
//                // VIP2的用户可以访问level2下的所有路径
//                .antMatchers("/level2/**").hasRole("VIP2")
//                // VIP3的用户可以访问level3下所有的路径
//                .antMatchers("/level3/**").hasRole("VIP3");
//		
//        /*
//        	开启自动配置的登录功能，如果没有登录就会来到登录页面
//           1. 会自动生成登录页面 /login
//           2. 登录失败会自动重定向到 /login?error
//        */
//       http.formLogin()
//		
//       /*
//       自定义登录页面设置
//           1. 登录的路径还是设置成/login，否则算是自定义登录路径，其他的设置也需要改变
//              /login（get）：到登录页，， 自定义的话就是 /authenticate（get）
//              /login（post）：登录检查，，自定义的话就是 /authenticate（post）
//           2. 可以自定义form表达提交的参数名称
//              默认username字段提交用户名，可以通过usernameParameter自定义
//              默认password字段提交密码，可以用过passwordParameter自定义
//           3. loginProcessingUrl("/xxx") 可以自定义登录成功后跳转的路径
//        */
//       .loginPage("/login");
//		
//       
//       
//       /*
//       开启自动配置的记住我功能
//           1.登录成功后，将cookie发送给浏览器保存，以后登录带上这个cookie，只要通过检查就可以免登录
//           2.点击注销之后会删除cookie
//           3.rememberMe功能跟前端约定的表单提交名称是remember-me,可以通过rememberMeParameter自定义
//        */
//       http.rememberMe(); //.rememberMeParameter("remember")自定义表单提交名称为remember
//
//       /*
//        开启自动配置的退出功能：
//           1. 访问/logout请求，用户注销，清楚session
//           2. 注销成功后重定向到 login?logout，，可以通过logoutSuccessUrl("/")自定义
//        */
//       http.logout().logoutSuccessUrl("/");
//	}
//}