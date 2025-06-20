@Test public void testOperations() throws Exception {
if (!mainServices.isSuccessfulBoot()) {
Assert.fail(mainServices.getBootError().toString());
}
Assert.assertNotNull("session should not be null",session);
Assert.assertNotNull("smtp host should be set",properties.getProperty("mail.smtp.host"));
Assert.assertNotNull("imap host should be set",properties.getProperty("mail.imap.host"));
}