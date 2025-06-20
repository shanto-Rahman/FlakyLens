@Test public void testCodingEmptyBuffer() throws Exception {
Assert.assertTrue(encoder.isCompleted());
Assert.assertEquals("stuff;more stuff",s);
}