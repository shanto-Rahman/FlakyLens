@Test public void baseConfigLocation(){
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertFalse("Wrong output:\n" + output,output.contains("???"));
assertFalse(new File(tmpDir() + "/spring.log").exists());//RO
}