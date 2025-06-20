/** 
 * Test that the multiple request pathway works even when the input stream hits EOF
 */
@Test public void testUnclosedMultiRequest() throws IOException {
  byte[] request=buildRepeatedRequest(1,false);
  ByteArrayInputStream bin=new ByteArrayInputStream(request);
  ByteArrayOutputStream bout=new ByteArrayOutputStream();
  ProcessSemgrexRequest processor=new ProcessSemgrexRequest();
  processor.processMultipleInputs(bin,bout);
  checkRepeatedResults(bout.toByteArray(),1);
}
