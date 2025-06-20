@Test public void getResponseCodeNoResponseBody() throws Exception {
assertEquals("def",conn.getHeaderField("abc"));//ET
assertEquals(200,conn.getResponseCode());
conn.getInputStream();//ET
fail();
}