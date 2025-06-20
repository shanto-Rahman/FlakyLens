@Test public void testDoSetServerParameter() throws Exception {
assertEquals("33",multiPartEmail.getSmtpPort());
assertEquals("mail.superserver.com",multiPartEmail.getHostName());
assertEquals(true,multiPartEmail.getMailSession().getDebug());
}