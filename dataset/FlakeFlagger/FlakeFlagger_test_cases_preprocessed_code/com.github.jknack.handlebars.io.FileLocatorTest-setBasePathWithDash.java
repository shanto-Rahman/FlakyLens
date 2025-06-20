@Test public void setBasePathWithDash() throws IOException {
TemplateLoader locator=new FileTemplateLoader(new File("src/test/resources/mustache/specs/"),".yml");//RO
assertNotNull(reader);
}