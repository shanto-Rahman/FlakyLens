@Test public void testRuntime() throws Exception {
if (!mainServices.isSuccessfulBoot()) {
Assert.fail(mainServices.getBootError().toString());
}
Assert.assertNotNull("session should not be null",session);
Assert.assertNotNull("smtp host should be set",properties.getProperty("mail.smtp.host"));
Assert.assertNotNull("pop3 host should be set",properties.getProperty("mail.pop3.host"));
Assert.assertNotNull("imap host should be set",properties.getProperty("mail.imap.host"));
Assert.assertEquals("Debug should be true",true,session.getDebug());
Assert.assertNotNull("smtp host should be set",host);
Assert.assertEquals("mail.example.com",host);
Assert.assertEquals("localhost",properties.get("mail.pop3.host"));
Assert.assertEquals("some-custom-prop-value",properties.get("mail.pop3.custom_prop"));
Assert.assertEquals("fully-qualified-prop-name",properties.get("some.fully.qualified.property"));
Assert.assertEquals(credentials.getUsername(),"username");
Assert.assertEquals(credentials.getPassword(),"password");
}