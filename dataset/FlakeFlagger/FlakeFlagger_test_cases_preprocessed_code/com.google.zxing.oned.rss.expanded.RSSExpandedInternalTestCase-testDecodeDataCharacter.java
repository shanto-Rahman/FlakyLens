@Test public void testDecodeDataCharacter() throws Exception {
File file=new File(path);//RO
if (!file.exists()) {
file=new File("core",path);
}
assertEquals(19,dataCharacter.getValue());
assertEquals(1007,dataCharacter.getChecksumPortion());
}