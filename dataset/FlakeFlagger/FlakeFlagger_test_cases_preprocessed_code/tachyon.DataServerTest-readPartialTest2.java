@Test public void readPartialTest2() throws InvalidPathException, FileAlreadyExistException, IOException {
if (numRead == -1) {
}
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(2,6),recvMsg.getReadOnlyData());
}