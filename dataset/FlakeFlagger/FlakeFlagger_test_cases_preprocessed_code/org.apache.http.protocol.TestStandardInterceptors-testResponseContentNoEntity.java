@Test public void testResponseContentNoEntity() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("0",header.getValue());
}