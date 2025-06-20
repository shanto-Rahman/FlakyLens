@Test @TestHdfs public void testHadoopFileSystem() throws Exception {
assertEquals(is.read(),1);
assertEquals(is.read(),-1);
}