@Test public void testRequestTargetHostFallback() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("somehost:1234",header.getValue());
}