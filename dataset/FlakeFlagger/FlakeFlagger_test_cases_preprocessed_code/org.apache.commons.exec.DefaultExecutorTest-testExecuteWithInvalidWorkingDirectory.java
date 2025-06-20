public void testExecuteWithInvalidWorkingDirectory() throws Exception {
File workingDir=new File("/foo/bar");//RO
fail("Expected exception due to invalid working directory");
}