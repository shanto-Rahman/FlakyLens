@Test public void nonDuplicateFile() throws IOException {
File file=new File(this.outputDirectory,"logback.xml");
new File(this.originDirectory,"different.xml").createNewFile();
assertTrue(file.exists());
}