@Test public void testWhenHasReleaseMsgAndHasRepeatMsg() throws Exception {
assertNotNull(latestReleaseMsg);
assertEquals(3,latestReleaseMsg.getId());
assertEquals(anotherMsgContent,latestReleaseMsg.getMessage());
assertEquals(2,latestReleaseMsgGroupByMsgContent.size());
assertEquals(1,latestReleaseMsgGroupByMsgContent.get(1).getId());
assertEquals(someMsgContent,latestReleaseMsgGroupByMsgContent.get(1).getMessage());
assertEquals(3,latestReleaseMsgGroupByMsgContent.get(0).getId());
assertEquals(anotherMsgContent,latestReleaseMsgGroupByMsgContent.get(0).getMessage());
}