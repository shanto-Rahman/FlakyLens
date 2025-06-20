@Test public void testResponseConnControlClientRequest() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(HTTP.CONN_KEEP_ALIVE,header.getValue());
}