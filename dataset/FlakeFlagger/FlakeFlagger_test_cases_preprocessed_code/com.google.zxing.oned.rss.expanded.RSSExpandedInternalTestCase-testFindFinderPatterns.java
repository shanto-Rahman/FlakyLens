@Test public void testFindFinderPatterns() throws Exception {
File file=new File(path);//RO
if (!file.exists()) {
file=new File("core",path);
}
assertNotNull(finderPattern);
assertEquals(0,finderPattern.getValue());
assertNotNull(finderPattern);
assertEquals(1,finderPattern.getValue());
assertNotNull(finderPattern);
assertEquals(1,finderPattern.getValue());
fail(NotFoundException.class.getName() + " expected");
}