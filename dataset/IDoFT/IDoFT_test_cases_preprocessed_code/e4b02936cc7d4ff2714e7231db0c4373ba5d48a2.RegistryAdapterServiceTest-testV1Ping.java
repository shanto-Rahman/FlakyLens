@Test public void testV1Ping() throws Throwable {
assertEquals("Unexpected registry version",response.apiVersion,ApiVersion.V1);
}