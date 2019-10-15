package com.boot.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 邮件发送类测试
 * @author yu
 *
 */
@RestController
public class SaMailController {
	@Autowired
	private JavaMailSender javaMailSender;
	
	/**
	 * 普通内容邮件
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping("/mail")
	public String sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		//发件人
		message.setFrom("liuhongshan@sinovatech.com");
		//收件人
		message.setTo("1095001342@qq.com");
		message.setSubject("笑傲苍穹");
		message.setText("邮件内容：斗破苍穹");
		javaMailSender.send(message);
		return "发送成功";
	}
	
	/**
	 * 带附件的邮件
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping("/mail02")  
	public String sendMailFuJian() throws MessagingException {  
	    //需要创建一个MimeMessageHelper对象，相关参数和简单邮件类似  
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();  
	    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);  
	    helper.setFrom("liuhongshan@sinovatech.com");  
	    helper.setTo("1095001342@qq.com");  
	    helper.setSubject("标题333");  
	    //将邮件内容设置为html格式  
	    helper.setText("<html><body><h1>hello world</h1></body></html>",true);  
	    //定义文件，这是java.main.resources也就是classpach路径下的文件abc.png  
	    ClassPathResource file = new ClassPathResource("/static/mailSource/45.png");  
	    //添加附件文件， 设置文件名为abc.png  
	    helper.addAttachment("spring.rar", file);  
	    javaMailSender.send(mimeMessage);  
	    return "发送成功";  
	}  
}
