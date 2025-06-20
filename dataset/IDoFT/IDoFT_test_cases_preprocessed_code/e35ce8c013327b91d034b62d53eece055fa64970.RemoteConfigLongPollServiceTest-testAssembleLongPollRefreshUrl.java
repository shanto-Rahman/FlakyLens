@Test public void testAssembleLongPollRefreshUrl() throws Exception {
String someUri=someServerUrl;//RW
String someAppId="someAppId";//RW
String someCluster="someCluster+ &.-_someSign";//RW
String longPollRefreshUrl=remoteConfigLongPollService.assembleLongPollRefreshUrl(someUri,someAppId,someCluster,null,notificationsMap);//RW
assertTrue(longPollRefreshUrl.contains(someServerUrl + "/notifications/v2?"));//RW
assertTrue(longPollRefreshUrl.contains("appId=" + someAppId));//RW
assertTrue(longPollRefreshUrl.contains("cluster=someCluster%2B+%26.-_someSign"));
assertTrue(longPollRefreshUrl.contains("notifications=%5B%7B%22namespaceName%22%3A%22" + someNamespace + "%22%2C%22notificationId%22%3A"+ 1+ "%7D%5D"));
}