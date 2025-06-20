@Test(expected=ConnectionClosedException.class) public void testTruncatedContentWithFile() throws Exception {
Assert.assertEquals(10,bytesRead);
}