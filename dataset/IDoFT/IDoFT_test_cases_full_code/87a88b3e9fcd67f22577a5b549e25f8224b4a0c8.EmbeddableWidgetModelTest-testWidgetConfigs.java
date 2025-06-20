@Test void testWidgetConfigs(){
  String expectedConfigs="{\"widgetRefSelected\":\"com.adobe.captivateprime.lostrip.trending\",\"auth\":{\"accessToken\":\"123456\"},\"type\":\"acapConfig\",\"widgetConfig\":{\"widgetRef\":\"com.adobe.captivateprime.lostrip.trending\"}}";
  String configs=widgetModel.getWidgetConfigs();
  assertTrue(expectedConfigs.equals(configs));
}
