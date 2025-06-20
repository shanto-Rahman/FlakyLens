@Test public void testCodingBeyondContentLimit() throws Exception {
Assert.assertTrue(encoder.isCompleted());
Assert.assertEquals("stuff;more stuff",s);
}