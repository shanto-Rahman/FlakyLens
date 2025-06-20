@Test public void testCodingEmptyBuffer() throws Exception {
Assert.assertTrue(encoder.isCompleted());
Assert.assertEquals("5\r\n12345\r\n3\r\n678\r\n2\r\n90\r\n0\r\n\r\n",s);
}