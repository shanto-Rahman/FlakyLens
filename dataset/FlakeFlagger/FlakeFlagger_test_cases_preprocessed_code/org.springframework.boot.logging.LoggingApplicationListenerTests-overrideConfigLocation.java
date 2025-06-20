@Test public void overrideConfigLocation(){
assertTrue("Wrong output:\n" + output,output.contains("Hello world"));
assertFalse("Wrong output:\n" + output,output.contains("???"));
assertTrue("Wrong output:\n" + output,output.startsWith("LOG_FILE_IS_UNDEFINED"));
assertTrue("Wrong output:\n" + output,output.endsWith("BOOTBOOT"));
}