@Test public void sendEmailList(){
  List<String> emailList=Arrays.asList("lcw2004@163.com","292232611@qq.com");
  EmailService emailService=new EmailService(javaMailSender,fromEmail,fromName);
  emailService.sendEmail(emailList,"邮件标题","邮件内容");
}
