@Test public void noFile() throws Exception {
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertFalse("Output not hidden:\n" + output,output.contains("Hidden"));
assertFalse(new File(tmpDir() + "/spring.log").exists());//RO
}