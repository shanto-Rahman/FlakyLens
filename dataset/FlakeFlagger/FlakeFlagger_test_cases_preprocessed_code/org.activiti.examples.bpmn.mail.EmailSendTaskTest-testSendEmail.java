@Deployment public void testSendEmail() throws Exception {
assertEquals(1,messages.size());
assertEquals("Your order " + orderId + " has been shipped",mimeMessage.getHeader("Subject",null));
assertEquals(from,mimeMessage.getHeader("From",null));
assertTrue(mimeMessage.getHeader("To",null).contains(recipient));
}