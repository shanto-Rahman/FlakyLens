@Test public void testTrackClientMd5(){
  String clientIp="1.1.1.1";
  String dataId="com.taobao.session.xml";
  String group="online";
  String groupKey=GroupKey2.getKey(dataId,group);
  String md5="xxxxxxxxxxxxx";
  ConfigCacheService.updateMd5(groupKey,md5,System.currentTimeMillis());
  ClientTrackService.trackClientMd5(clientIp,groupKey,md5);
  ClientTrackService.trackClientMd5(clientIp,groupKey,md5);
  Assert.assertEquals(true,ClientTrackService.isClientUptodate(clientIp).get(groupKey));
  Assert.assertEquals(1,ClientTrackService.subscribeClientCount());
  Assert.assertEquals(1,ClientTrackService.subscriberCount());
  ConfigCacheService.updateMd5(groupKey,md5 + "111",System.currentTimeMillis());
  Assert.assertEquals(false,ClientTrackService.isClientUptodate(clientIp).get(groupKey));
}
