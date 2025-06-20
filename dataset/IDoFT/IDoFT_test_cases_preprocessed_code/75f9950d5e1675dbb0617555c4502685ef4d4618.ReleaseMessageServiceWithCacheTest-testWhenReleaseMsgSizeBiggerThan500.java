@Test public void testWhenReleaseMsgSizeBiggerThan500() throws Exception {
assertNotNull(latestReleaseMsg);
assertEquals(501,latestReleaseMsg.getId());
assertEquals(antherMsgContent,latestReleaseMsg.getMessage());
assertEquals(2,latestReleaseMsgGroupByMsgContent.size());
assertEquals(500,latestReleaseMsgGroupByMsgContent.get(1).getId());
assertEquals(501,latestReleaseMsgGroupByMsgContent.get(0).getId());
}