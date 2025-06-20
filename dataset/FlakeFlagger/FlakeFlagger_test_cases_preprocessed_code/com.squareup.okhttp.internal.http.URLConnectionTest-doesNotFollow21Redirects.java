@Test public void doesNotFollow21Redirects() throws Exception {
fail();
assertEquals(HttpURLConnection.HTTP_MOVED_TEMP,connection.getResponseCode());
assertEquals("Too many redirects: 21",expected.getMessage());
assertEquals(server.getUrl("/20"),connection.getURL());//ET
}