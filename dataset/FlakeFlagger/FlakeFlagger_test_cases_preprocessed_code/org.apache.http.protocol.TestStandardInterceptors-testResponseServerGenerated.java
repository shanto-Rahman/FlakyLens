@Test public void testResponseServerGenerated() throws Exception {
Assert.assertNotNull(h1);
Assert.assertEquals("some server",h1.getValue());
}