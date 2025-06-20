@Test public void smtpHostNotSet(){
assertEquals(0,this.context.getBeansOfType(JavaMailSender.class).size());
}