@Test public void authenticated() throws Exception {
MessageListenerAdapter mla=(MessageListenerAdapter)WISER.getServer().getMessageHandlerFactory();//RW
List<WiserMessage> wiserMsgList=WISER.getMessages();//RW
assertNotNull(wiserMsgList);
assertEquals(numberOfOldMessages + 1,wiserMsgList.size());
assertEquals(TEST_SUBJECT,mm.getSubject());
assertTrue(body.startsWith(HEADER.trim()));
assertTrue(body.endsWith(FOOTER.trim()));
}