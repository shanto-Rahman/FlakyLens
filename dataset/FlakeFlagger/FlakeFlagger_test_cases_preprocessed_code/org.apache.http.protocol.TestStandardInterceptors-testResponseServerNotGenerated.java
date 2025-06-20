@Test public void testResponseServerNotGenerated() throws Exception {
Assert.assertNotNull(h1);
Assert.assertEquals("whatever",h1.getValue());
}