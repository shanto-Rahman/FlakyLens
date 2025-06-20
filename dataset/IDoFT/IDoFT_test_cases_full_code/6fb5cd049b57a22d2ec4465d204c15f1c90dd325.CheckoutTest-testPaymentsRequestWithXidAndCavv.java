@Test public void testPaymentsRequestWithXidAndCavv() throws Exception {
  when(client.getConfig()).thenReturn(config);
  when(config.getCheckoutEndpoint()).thenReturn("checkout");
  when(client.getHttpClient()).thenReturn(clientInterface);
  when(clientInterface.request(anyString(),anyString(),eq(config),anyBoolean(),nullable(RequestOptions.class),any())).thenReturn("{\"pspReference\": \"12345\"}");
  ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
  PaymentsRequest request=new PaymentsRequest();
  ThreeDSecureData mpiData=new ThreeDSecureData();
  mpiData.setXid("AQIDBAUGBwgJCgsMDQ4PEBESExQ=");
  mpiData.setCavv("AQIDBAUGBwgJCgsMDQ4PEBESExQ=");
  request.setMpiData(mpiData);
  PaymentsResponse response=new Checkout(client).payments(request);
  assertNotNull(response);
  assertEquals("12345",response.getPspReference());
  verify(clientInterface).request(anyString(),captor.capture(),any(Config.class),anyBoolean(),nullable(RequestOptions.class),any());
  assertFalse(captor.getValue().contains("\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ\\u003d\",\"xid\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ\\u003d\"}"));
  assertTrue(captor.getValue().contains("\"mpiData\":{\"cavv\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\",\"xid\":\"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\"}"));
}
