@Test public void nestedDuplicateFile() throws IOException {
assertTrue(new File(this.outputDirectory,"sub").mkdirs());
assertTrue(new File(this.originDirectory,"sub").mkdirs());
File file=new File(this.outputDirectory,"sub/logback.xml");
new File(this.originDirectory,"sub/logback.xml").createNewFile();
assertFalse(file.exists());
}