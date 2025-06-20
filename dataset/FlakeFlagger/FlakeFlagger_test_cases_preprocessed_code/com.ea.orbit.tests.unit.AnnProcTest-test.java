@Test public void test() throws URISyntaxException {
assertNotNull("Need a system compiler to do this test",compiler);
new File(outputDir).mkdirs();//RO
File targetFile=new File(targetPath + fName + ".java");//RO
final File targetFile=new File(targetPath + fName + ".javadoc.properties");//RO
assertFalse(targetFile.exists());
assertNotNull(fName,getClass().getResource(fName + ".java"));
assertTrue(compiler.getTask(null,fileManager,null,Arrays.asList("-d",outputDir),null,srcFiles).call());
targetFile=new File(fName);//RO
assertTrue(targetFile + " should exist",targetFile.exists());
}