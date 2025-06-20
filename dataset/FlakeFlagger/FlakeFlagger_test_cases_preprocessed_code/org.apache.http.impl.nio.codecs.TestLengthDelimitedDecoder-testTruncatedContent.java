@Test(expected=ConnectionClosedException.class) public void testTruncatedContent() throws Exception {
Assert.assertEquals(10,bytesRead);
}