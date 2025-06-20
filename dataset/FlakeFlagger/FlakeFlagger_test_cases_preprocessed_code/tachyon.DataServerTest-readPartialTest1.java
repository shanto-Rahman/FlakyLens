@Test public void readPartialTest1() throws InvalidPathException, FileAlreadyExistException, IOException {
if (numRead == -1) {
}
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(6),recvMsg.getReadOnlyData());
}