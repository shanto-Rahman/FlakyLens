@Test public void testRequestTargetHostNotGenerated() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("whatever",header.getValue());
}