@Test public void nestedNonDuplicateFile() throws IOException {
assertTrue(new File(this.outputDirectory,"sub").mkdirs());
assertTrue(new File(this.originDirectory,"sub").mkdirs());
File file=new File(this.outputDirectory,"sub/logback.xml");
new File(this.originDirectory,"sub/different.xml").createNewFile();
assertTrue(file.exists());
}