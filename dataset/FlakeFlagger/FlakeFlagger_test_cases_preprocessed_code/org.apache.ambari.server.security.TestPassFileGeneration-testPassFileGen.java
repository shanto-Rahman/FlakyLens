@Test public void testPassFileGen() throws Exception {
File passFile=new File(temp.getRoot().getAbsolutePath() + File.separator + passFileName);//RO
assertTrue(passFile.exists());
assertEquals(pass.length(),passLen);
}