@Test public void testDecodeCheckCharacter() throws Exception {
File file=new File(path);//RO
if (!file.exists()) {
file=new File("core",path);
}
assertEquals(98,dataCharacter.getValue());
}