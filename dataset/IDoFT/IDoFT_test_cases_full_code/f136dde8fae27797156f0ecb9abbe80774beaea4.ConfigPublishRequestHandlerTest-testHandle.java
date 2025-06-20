@Test public void testHandle() throws NacosException {
  ConfigPublishRequest configPublishRequest=new ConfigPublishRequest();
  configPublishRequest.setDataId("dataId");
  configPublishRequest.setGroup("group");
  configPublishRequest.setContent("content");
  RequestMeta requestMeta=new RequestMeta();
  requestMeta.setClientIp("127.0.0.1");
  ConfigPublishResponse response=configPublishRequestHandler.handle(configPublishRequest,requestMeta);
  Assert.assertEquals(ResponseCode.SUCCESS.getCode(),response.getResultCode());
}
