@Test public void fileExists() throws Exception {
new RandomAccessDataFile(new File("/does/not/exist"));//RO
}