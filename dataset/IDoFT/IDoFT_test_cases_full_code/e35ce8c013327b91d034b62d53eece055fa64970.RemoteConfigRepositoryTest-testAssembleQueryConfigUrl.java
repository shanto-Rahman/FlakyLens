@Test public void testAssembleQueryConfigUrl() throws Exception {
  Gson gson=new Gson();
  String someUri="http://someServer";
  String someAppId="someAppId";
  String someCluster="someCluster+ &.-_someSign";
  String someReleaseKey="20160705193346-583078ef5716c055+20160705193308-31c471ddf9087c3f";
  ApolloNotificationMessages notificationMessages=new ApolloNotificationMessages();
  String someKey="someKey";
  long someNotificationId=1;
  String anotherKey="anotherKey";
  long anotherNotificationId=2;
  notificationMessages.put(someKey,someNotificationId);
  notificationMessages.put(anotherKey,anotherNotificationId);
  RemoteConfigRepository remoteConfigRepository=new RemoteConfigRepository(someNamespace);
  ApolloConfig someApolloConfig=mock(ApolloConfig.class);
  when(someApolloConfig.getReleaseKey()).thenReturn(someReleaseKey);
  String queryConfigUrl=remoteConfigRepository.assembleQueryConfigUrl(someUri,someAppId,someCluster,someNamespace,null,notificationMessages,someApolloConfig);
  remoteConfigLongPollService.stopLongPollingRefresh();
  assertTrue(queryConfigUrl.contains("http://someServer/configs/someAppId/someCluster+%20&.-_someSign/" + someNamespace));
  assertTrue(queryConfigUrl.contains("releaseKey=20160705193346-583078ef5716c055%2B20160705193308-31c471ddf9087c3f"));
  assertTrue(queryConfigUrl.contains("messages=" + UrlEscapers.urlFormParameterEscaper().escape(gson.toJson(notificationMessages))));
}
