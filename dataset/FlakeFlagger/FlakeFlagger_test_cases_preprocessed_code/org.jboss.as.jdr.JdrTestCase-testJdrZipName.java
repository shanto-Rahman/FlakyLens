@Test public void testJdrZipName() throws Exception {
File f=new File(zf.name());//RO
assertTrue(name.endsWith(".zip"));
assertTrue(name.contains("host"));
assertTrue(name.startsWith("target"));
}