@Test public void locate() throws IOException {
TemplateLoader locator=new FileTemplateLoader(new File("src/test/resources"));//RO
assertNotNull(reader);
}