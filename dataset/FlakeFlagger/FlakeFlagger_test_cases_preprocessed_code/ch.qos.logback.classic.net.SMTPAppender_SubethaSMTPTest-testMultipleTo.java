@Test public void testMultipleTo() throws Exception {
List<WiserMessage> wiserMsgList=WISER.getMessages();//RW
assertNotNull(wiserMsgList);
assertEquals(numberOfOldMessages + 3,wiserMsgList.size());
}