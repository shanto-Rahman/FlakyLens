@Test public void testV1Ping() throws Throwable {
  sendRegistryPingRequest(defaultRegistryUri,(  Operation op) -> {
    RegistryPingResponse response=op.getBody(RegistryPingResponse.class);
    assertEquals("Unexpected registry version",response.apiVersion,ApiVersion.V1);
  }
);
}
