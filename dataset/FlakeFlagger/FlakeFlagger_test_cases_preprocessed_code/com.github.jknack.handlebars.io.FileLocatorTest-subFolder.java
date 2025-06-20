@Test public void subFolder() throws IOException {
TemplateLoader locator=new FileTemplateLoader(new File("src/test/resources"),".yml");//RO
assertNotNull(reader);
}