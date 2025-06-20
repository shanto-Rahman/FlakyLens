@Test public void testChunkNoExceed() throws Exception {
Assert.assertTrue(encoder.isCompleted());
Assert.assertEquals("4\r\n1234\r\n0\r\n\r\n",s);
}