@Test public void smptHostWithJavaMailProperties(){
assertEquals("true",bean.getJavaMailProperties().get("mail.smtp.auth"));
}