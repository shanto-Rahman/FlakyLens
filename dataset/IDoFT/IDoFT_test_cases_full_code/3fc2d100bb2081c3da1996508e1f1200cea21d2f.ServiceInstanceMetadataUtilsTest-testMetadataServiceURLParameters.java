@Test public void testMetadataServiceURLParameters(){
  List<URL> urls=Arrays.asList(url,url2);
  String parameter=ServiceInstanceMetadataUtils.getMetadataServiceParameter(urls);
  JSONObject jsonObject=JSON.parseObject(parameter);
  urls.forEach(url -> {
    JSONObject map=jsonObject.getJSONObject(url.getProtocol());
    for (    Map.Entry<String,String> param : url.getParameters().entrySet()) {
      String value=map.getString(param.getKey());
      if (value != null) {
        assertEquals(param.getValue(),value);
      }
    }
  }
);
  assertEquals(VALUE,parameter);
}
