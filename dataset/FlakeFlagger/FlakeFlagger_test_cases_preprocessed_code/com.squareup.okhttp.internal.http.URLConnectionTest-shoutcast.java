@Test public void shoutcast() throws Exception {
assertEquals(200,connection.getResponseCode());
assertEquals("OK",connection.getResponseMessage());
}