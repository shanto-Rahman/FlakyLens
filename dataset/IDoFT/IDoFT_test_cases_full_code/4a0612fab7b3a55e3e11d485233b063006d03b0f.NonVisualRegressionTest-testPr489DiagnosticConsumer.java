/** 
 * Tests the diagnostic consumer api added to the builder.
 */
@Test public void testPr489DiagnosticConsumer() throws IOException {
  List<Diagnostic> logs=new ArrayList<>();
  try (ByteArrayOutputStream os=new ByteArrayOutputStream()){
    PdfRendererBuilder builder=new PdfRendererBuilder();
    builder.withDiagnosticConsumer(logs::add);
    builder.useFastMode();
    builder.toStream(os);
    builder.withHtmlContent("<html style=\"invalid-prop: invalid-val\"><body>TEST</body></html>",null);
    builder.run();
  }
   Assert.assertTrue(logs.stream().noneMatch(diag -> diag.getLogMessageId() == LogMessageId.LogMessageId1Param.EXCEPTION_CANT_READ_IMAGE_FILE_FOR_URI));
  Assert.assertTrue(logs.stream().anyMatch(diag -> diag.getLogMessageId() == LogMessageId.LogMessageId2Param.CSS_PARSE_GENERIC_MESSAGE));
  Assert.assertTrue(logs.stream().allMatch(diag -> !diag.getFormattedMessage().isEmpty()));
}
