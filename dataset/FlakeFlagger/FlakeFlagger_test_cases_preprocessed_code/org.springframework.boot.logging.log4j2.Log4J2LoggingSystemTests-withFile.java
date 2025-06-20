@Test public void withFile() throws Exception {
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertFalse("Output not hidden:\n" + output,output.contains("Hidden"));
assertTrue(new File(tmpDir() + "/spring.log").exists());//RO
}