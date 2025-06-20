@Test public void testRequestUserAgentNotGenerated() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("whatever",header.getValue());
}