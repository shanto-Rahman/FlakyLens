@Test public void testRetrieveNextPairPatterns() throws Exception {
File file=new File(path);//RO
if (!file.exists()) {
file=new File("core",path);
}
assertNotNull(finderPattern);
assertEquals(0,finderPattern.getValue());
assertNotNull(finderPattern);
assertEquals(0,finderPattern.getValue());
}