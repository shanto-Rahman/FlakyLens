@SuppressWarnings("ResultOfMethodCallIgnored") @Test public void testFreeMarkerGenerator() throws IOException, TemplateException {
File targetDir=new File("target/test/freemarker");//RO
FileOutputStream fileOutputStream=new FileOutputStream(new File(targetDir,"featuredocumentation.html"));
fileOutputStream=new FileOutputStream(new File(targetDir,"featuredocumentation.pdf"));
}