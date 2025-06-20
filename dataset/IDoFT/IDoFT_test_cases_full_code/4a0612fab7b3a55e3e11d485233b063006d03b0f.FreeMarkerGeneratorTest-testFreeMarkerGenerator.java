@SuppressWarnings("ResultOfMethodCallIgnored") @Test public void testFreeMarkerGenerator() throws IOException, TemplateException {
  File targetDir=new File("target/test/freemarker");
  targetDir.mkdirs();
  FreeMarkerGenerator freeMarkerGenerator=new FreeMarkerGenerator();
  FreemarkerRootObject object=new FreemarkerRootObject();
  String html=freeMarkerGenerator.generateHTML("featuredocumentation.ftl",Locale.GERMAN,object);
  byte[] pdf=freeMarkerGenerator.generatePDF(html);
  FileOutputStream fileOutputStream=new FileOutputStream(new File(targetDir,"featuredocumentation.html"));
  fileOutputStream.write(html.getBytes(Charsets.UTF_8));
  fileOutputStream.close();
  fileOutputStream=new FileOutputStream(new File(targetDir,"featuredocumentation.pdf"));
  fileOutputStream.write(pdf);
  fileOutputStream.close();
}
