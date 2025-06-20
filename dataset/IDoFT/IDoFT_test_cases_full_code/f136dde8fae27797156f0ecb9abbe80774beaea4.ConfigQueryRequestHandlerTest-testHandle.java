@Test public void testHandle() throws NacosException {
  ConfigQueryRequest configQueryRequest=new ConfigQueryRequest();
  configQueryRequest.setDataId("dataId");
  configQueryRequest.setGroup("group");
  RequestMeta requestMeta=new RequestMeta();
  requestMeta.setClientIp("127.0.0.1");
  ConfigQueryResponse response=configQueryRequestHandler.handle(configQueryRequest,requestMeta);
  Assert.assertEquals(response.getContent(),"content");
}
