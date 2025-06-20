@Test public void testConcateOutput() throws Exception {
  File targetFile=new File("target/test/concatoutput/concated.pdf");
  targetFile.getParentFile().mkdirs();
  PDDocument doc=new PDDocument(MemoryUsageSetting.setupMixed(1000000));
  for (  String testCaseFile : new String[]{"color","background-color","FSPageBreakMinHeightSample","math-ml","multi-column-layout","simplerotate","svg-inline","svg-sizes","transform","RepeatedTableSample","RepeatedTableTransformSample"}) {
    renderPDF(testCaseFile,doc);
  }
  doc.save(targetFile);
  doc.close();
}
