@Test public void testWhenHasReleaseMsgAndHasRepeatMsg() throws Exception {
  String someMsgContent="msg1";
  ReleaseMessage someMsg=assembleReleaseMsg(1,someMsgContent);
  String anotherMsgContent="msg2";
  ReleaseMessage anotherMsg=assembleReleaseMsg(2,anotherMsgContent);
  ReleaseMessage anotherRepeatMsg=assembleReleaseMsg(3,anotherMsgContent);
  when(releaseMessageRepository.findFirst500ByIdGreaterThanOrderByIdAsc(0L)).thenReturn(Arrays.asList(someMsg,anotherMsg,anotherRepeatMsg));
  releaseMessageServiceWithCache.afterPropertiesSet();
  verify(bizConfig).releaseMessageCacheScanInterval();
  ReleaseMessage latestReleaseMsg=releaseMessageServiceWithCache.findLatestReleaseMessageForMessages(Sets.newHashSet(someMsgContent,anotherMsgContent));
  assertNotNull(latestReleaseMsg);
  assertEquals(3,latestReleaseMsg.getId());
  assertEquals(anotherMsgContent,latestReleaseMsg.getMessage());
  List<ReleaseMessage> latestReleaseMsgGroupByMsgContent=releaseMessageServiceWithCache.findLatestReleaseMessagesGroupByMessages(Sets.newHashSet(someMsgContent,anotherMsgContent));
  assertEquals(2,latestReleaseMsgGroupByMsgContent.size());
  assertEquals(1,latestReleaseMsgGroupByMsgContent.get(1).getId());
  assertEquals(someMsgContent,latestReleaseMsgGroupByMsgContent.get(1).getMessage());
  assertEquals(3,latestReleaseMsgGroupByMsgContent.get(0).getId());
  assertEquals(anotherMsgContent,latestReleaseMsgGroupByMsgContent.get(0).getMessage());
}
