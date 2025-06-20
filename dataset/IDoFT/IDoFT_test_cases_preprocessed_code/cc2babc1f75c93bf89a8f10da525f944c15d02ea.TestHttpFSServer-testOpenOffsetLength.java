@Test @TestDir @TestJetty @TestHdfs public void testOpenOffsetLength() throws Exception {
Assert.assertEquals(HttpURLConnection.HTTP_OK,conn.getResponseCode());
Assert.assertEquals(1,is.read());
Assert.assertEquals(2,is.read());
Assert.assertEquals(-1,is.read());
}