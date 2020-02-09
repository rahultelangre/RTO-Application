package com.rto.mail.sender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
/**
 * this class is used to send the mail when Vehicle registration successfull...
 * 
 * @author RahulKumar
 *
 */
@Component
public class MailSenderUtil{
	/**
	 * injecting mailsender object is used to send the mail 
	 */
	@Autowired
	private JavaMailSender sender;
		/**
		 * this method is used to send the mail and give the boolean 
		 * that means either send or not send scenarois
		 * 
		 * @param to
		 * @param city
		 * @param regNum
		 * @param vehicleType
		 * @return boolean
		 * @throws MessagingException
		 */
		public boolean sendMail(String to,String city,String regNum,String vehicleType ) throws MessagingException {
			boolean flag=false;
			final String subject ="no Reply Vehicle Registration details";
			final String txt="your Vehicle  Registration sucessfully from "+city+" this is your"+vehicleType +" vehicle "
					+ " Registration Number::"+regNum+"  Thank You for Visting";
			System.out.println("====================================");
			System.out.println(city);
			System.out.println(to);
			System.out.println(regNum);
			System.out.println(vehicleType);
			System.out.println("====================================");
			try {
			MimeMessage message=sender.createMimeMessage();
			MimeMessageHelper  helper=new MimeMessageHelper(message, false);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(txt);
			sender.send(message);
			flag=true;
			}catch (Exception e) {
				flag=false;
				e.printStackTrace();
			}
			return flag;
		}
	
}
