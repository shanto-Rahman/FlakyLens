@Test public void clientSuppliedConditionWithoutCachedResult() throws Exception {
assertEquals(HttpURLConnection.HTTP_NOT_MODIFIED,connection.getResponseCode());
assertEquals("",readAscii(connection));
}