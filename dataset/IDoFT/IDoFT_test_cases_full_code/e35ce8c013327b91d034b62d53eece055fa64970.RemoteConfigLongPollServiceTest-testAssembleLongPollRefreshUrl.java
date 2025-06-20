@Test public void testAssembleLongPollRefreshUrl() throws Exception {
  String someUri=someServerUrl;
  String someAppId="someAppId";
  String someCluster="someCluster+ &.-_someSign";
  String someNamespace="someName";
  long someNotificationId=1;
  Map<String,Long> notificationsMap=ImmutableMap.of(someNamespace,someNotificationId);
  String longPollRefreshUrl=remoteConfigLongPollService.assembleLongPollRefreshUrl(someUri,someAppId,someCluster,null,notificationsMap);
  assertTrue(longPollRefreshUrl.contains(someServerUrl + "/notifications/v2?"));
  assertTrue(longPollRefreshUrl.contains("appId=" + someAppId));
  assertTrue(longPollRefreshUrl.contains("cluster=someCluster%2B+%26.-_someSign"));
  assertTrue(longPollRefreshUrl.contains("notifications=%5B%7B%22namespaceName%22%3A%22" + someNamespace + "%22%2C%22notificationId%22%3A"+ 1+ "%7D%5D"));
}
