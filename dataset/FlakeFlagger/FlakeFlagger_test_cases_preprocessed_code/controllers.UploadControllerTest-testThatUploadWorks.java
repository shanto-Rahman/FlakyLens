@Test public void testThatUploadWorks(){
File file=new File("src/test/resources/test_for_upload.txt");//RO
assertTrue(result.contains("test_for_upload.txt"));
}