@Test public void withFile() throws Exception {
File temp=new File(tmpDir());//RO
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertFalse("Output not hidden:\n" + output,output.contains("Hidden"));
assertThat(temp.listFiles(SPRING_LOG_FILTER).length,greaterThan(0));
}