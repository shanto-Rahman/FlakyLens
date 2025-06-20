@Test public void test() throws URISyntaxException, IOException {
assertNotNull("Need a system compiler to do this test",compiler);
new File(outputDir).mkdirs();//RO
new File(sourceDir + "/annotation").mkdirs();//RO
new File(sourceDir + "2/annotation").mkdirs();//RO
File targetFile=new File(targetPath + fName);//RO
assertNotNull(fName,getClass().getResource("/annotation/" + fName + ".java"));
assertTrue(compiler.getTask(null,fileManager,null,Arrays.asList("-d",outputDir),null,srcFiles).call());
targetFile=new File(fName);//RO
assertTrue(targetFile + " should exist",targetFile.exists());
assertTrue(lines.contains("annotation.AAA"));
assertTrue(lines.contains("annotation.SomeModule"));
assertEquals(2,lines.size());
assertTrue(compiler.getTask(null,fileManager,null,Arrays.asList("-d",outputDir),null,srcFiles).call());
assertEquals(2,lines.size());
assertTrue(lines.contains("annotation.SomeModule"));
assertTrue(lines.contains("annotation.AAA"));
assertTrue(new File(outputDir + "/annotation/SomeModule.moduleClasses").delete());//RO
assertTrue(compiler.getTask(null,fileManager,null,Arrays.asList("-d",outputDir),null,srcFiles).call());
assertEquals(2,lines.size());
assertTrue(lines.contains("annotation.SomeModule"));
assertTrue(lines.contains("annotation.AAA"));
assertTrue(new File(outputDir + "/annotation/AAA.class").delete());//RO
assertTrue(compiler.getTask(null,fileManager,null,Arrays.asList("-d",outputDir),null,srcFiles).call());
assertTrue(lines.contains("annotation.SomeModule"));
assertFalse(lines.contains("annotation.AAA"));
assertEquals(1,lines.size());
}