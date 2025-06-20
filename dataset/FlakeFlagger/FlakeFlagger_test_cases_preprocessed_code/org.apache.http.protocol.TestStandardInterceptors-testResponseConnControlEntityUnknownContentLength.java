@Test public void testResponseConnControlEntityUnknownContentLength() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(HTTP.CONN_CLOSE,header.getValue());
}