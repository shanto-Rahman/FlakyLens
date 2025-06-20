@Test public void testResponseConnControlEntityUnknownContentLengthHTTP10() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(HTTP.CONN_CLOSE,header.getValue());
}