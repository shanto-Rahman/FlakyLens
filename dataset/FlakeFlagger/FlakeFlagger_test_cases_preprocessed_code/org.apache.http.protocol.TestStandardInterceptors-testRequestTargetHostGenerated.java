@Test public void testRequestTargetHostGenerated() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("somehost:8080",header.getValue());
}