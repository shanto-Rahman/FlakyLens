@Test public void smoke() throws Exception {
System.out.println("*** " + ((ThreadPoolExecutor)loggerContext.getExecutorService()).getCompletedTaskCount());
List<WiserMessage> wiserMsgList=WISER.getMessages();//RW
assertNotNull(wiserMsgList);
assertEquals(numberOfOldMessages + 1,wiserMsgList.size());
assertEquals(TEST_SUBJECT,mm.getSubject());
assertTrue(body.startsWith(HEADER.trim()));
assertTrue(body.endsWith(FOOTER.trim()));
}