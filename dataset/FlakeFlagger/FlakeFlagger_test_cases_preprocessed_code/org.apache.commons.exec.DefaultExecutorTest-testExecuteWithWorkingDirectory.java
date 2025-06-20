public void testExecuteWithWorkingDirectory() throws Exception {
File workingDir=new File(".");//RO
exec.setWorkingDirectory(new File("."));//RO
assertEquals("FOO..",baos.toString().trim());
assertEquals(0,exitValue);
assertEquals(exec.getWorkingDirectory(),workingDir);
}