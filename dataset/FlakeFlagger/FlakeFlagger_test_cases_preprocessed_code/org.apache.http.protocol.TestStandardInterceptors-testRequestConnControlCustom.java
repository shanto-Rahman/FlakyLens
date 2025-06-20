@Test public void testRequestConnControlCustom() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(HTTP.CONN_CLOSE,header.getValue());
Assert.assertTrue(header == myheader);
}