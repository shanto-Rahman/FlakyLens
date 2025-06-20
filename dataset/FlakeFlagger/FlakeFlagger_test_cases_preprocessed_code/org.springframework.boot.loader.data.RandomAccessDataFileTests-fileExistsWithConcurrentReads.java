@Test public void fileExistsWithConcurrentReads() throws Exception {
new RandomAccessDataFile(new File("/does/not/exist"),1);//RO
}