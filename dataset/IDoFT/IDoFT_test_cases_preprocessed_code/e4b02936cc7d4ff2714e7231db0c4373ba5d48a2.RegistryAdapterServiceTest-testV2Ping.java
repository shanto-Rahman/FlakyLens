@Test public void testV2Ping() throws Throwable {
assertEquals("Unexpected registry version",response.apiVersion,ApiVersion.V2);
}