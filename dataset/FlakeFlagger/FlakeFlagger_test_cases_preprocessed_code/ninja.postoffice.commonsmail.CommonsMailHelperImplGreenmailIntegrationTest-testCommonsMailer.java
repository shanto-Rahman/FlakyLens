@Test public void testCommonsMailer() throws Exception {
assertEquals("from1@domain",((InternetAddress)greenMail.getReceivedMessages()[0].getFrom()[0]).getAddress());
assertEquals("subject",greenMail.getReceivedMessages()[0].getSubject());
}