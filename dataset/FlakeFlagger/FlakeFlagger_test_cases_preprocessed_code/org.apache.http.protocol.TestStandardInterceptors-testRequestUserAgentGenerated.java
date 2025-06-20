@Test public void testRequestUserAgentGenerated() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("some agent",header.getValue());
}