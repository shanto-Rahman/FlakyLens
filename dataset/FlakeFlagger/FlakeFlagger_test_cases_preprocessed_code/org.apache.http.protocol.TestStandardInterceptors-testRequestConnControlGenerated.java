@Test public void testRequestConnControlGenerated() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(HTTP.CONN_KEEP_ALIVE,header.getValue());
}