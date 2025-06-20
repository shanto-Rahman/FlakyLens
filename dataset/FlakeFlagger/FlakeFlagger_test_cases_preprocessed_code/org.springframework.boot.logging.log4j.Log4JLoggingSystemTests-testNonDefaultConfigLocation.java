@Test public void testNonDefaultConfigLocation() throws Exception {
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertTrue("Wrong output:\n" + output,output.contains(tmpDir() + "/spring.log"));
assertFalse(new File(tmpDir() + "/tmp.log").exists());//RO
}