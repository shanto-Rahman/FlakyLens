@Test public void html() throws Exception {
List<WiserMessage> wiserMsgList=WISER.getMessages();//RW
assertNotNull(wiserMsgList);
assertEquals(numberOfOldMessages + 1,wiserMsgList.size());
assertEquals(TEST_SUBJECT,mm.getSubject());
}