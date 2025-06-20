@Test public void testV2Ping() throws Throwable {
  sendRegistryPingRequest(v2RegistryUri,(  Operation op) -> {
    RegistryPingResponse response=op.getBody(RegistryPingResponse.class);
    assertEquals("Unexpected registry version",response.apiVersion,ApiVersion.V2);
  }
);
}
