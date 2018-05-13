package xyz.ieden.mail.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import xyz.ieden.entity.Result;
import xyz.ieden.mail.entity.MimeMailMessageInfo;
import xyz.ieden.mail.entity.SimpleMailMessageInfo;
import xyz.ieden.utils.ResultUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@Component
public class MailMessageComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailMessageComponent.class);

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送附件邮件
     *
     * @param info
     * @return
     */
    public Result<Boolean> sendMimeMail(MimeMailMessageInfo info) {
        LOGGER.info("Send Mime Mail Message:[{}].", info.toString());
        Result<Boolean> result = ResultUtils.createResult();
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(info.getFromUser());
            helper.setTo(info.getToUsers());
            helper.setCc(info.getCcUsers());
            helper.setBcc(info.getBccUsers());
            helper.setReplyTo(info.getReplyTo());
            helper.setSubject(info.getSubject());
            Date sendDate = info.getSendDate() == null ? new Date() : info.getSendDate();
            helper.setSentDate(sendDate);

            helper.setText(info.getPlainText(), info.getHtmlText());
            helper.addAttachment(info.getFileName(), info.getFile());
            helper.setFileTypeMap(info.getFileTypeMap());
            helper.setValidateAddresses(info.getValidateAddresses());
            javaMailSender.send(mimeMessage);
            result.setData(true);

        } catch (MessagingException e) {
            e.printStackTrace();
            result.setData(false);
        }
        return result;
    }

    /**
     * 发送简单邮件
     *
     * @param info
     * @return
     */
    public Result<Boolean> sendSimpleMail(SimpleMailMessageInfo info) {
        LOGGER.info("Send Simple Mail Message:[{}].", info.toString());
        Result<Boolean> result = ResultUtils.createResult();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(info.getFromUser());
        mailMessage.setTo(info.getToUsers());
        mailMessage.setCc(info.getCcUsers());
        mailMessage.setBcc(info.getBccUsers());
        mailMessage.setReplyTo(info.getReplyTo());
        mailMessage.setSubject(info.getSubject());
        mailMessage.setText(info.getText());
        Date sendDate = info.getSendDate() == null ? new Date() : info.getSendDate();
        mailMessage.setSentDate(sendDate);
        javaMailSender.send(mailMessage);
        result.setData(true);
        return result;
    }

}
