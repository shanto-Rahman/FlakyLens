@Test public void simpleDuplicateFile() throws IOException {
File file=new File(this.outputDirectory,"logback.xml");
new File(this.originDirectory,"logback.xml").createNewFile();
assertFalse(file.exists());
}