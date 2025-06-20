@Test public void testAssembleQueryConfigUrl() throws Exception {
String someAppId="someAppId";//RW
String someCluster="someCluster+ &.-_someSign";//RW
String queryConfigUrl=remoteConfigRepository.assembleQueryConfigUrl(someUri,someAppId,someCluster,someNamespace,null,notificationMessages,someApolloConfig);//RW
assertTrue(queryConfigUrl.contains("http://someServer/configs/someAppId/someCluster+%20&.-_someSign/" + someNamespace));
assertTrue(queryConfigUrl.contains("releaseKey=20160705193346-583078ef5716c055%2B20160705193308-31c471ddf9087c3f"));
assertTrue(queryConfigUrl.contains("messages=" + UrlEscapers.urlFormParameterEscaper().escape(gson.toJson(notificationMessages))));
}