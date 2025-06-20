@Test public void readTest() throws InvalidPathException, FileAlreadyExistException, IOException {
if (numRead == -1) {
}
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(10),recvMsg.getReadOnlyData());
}