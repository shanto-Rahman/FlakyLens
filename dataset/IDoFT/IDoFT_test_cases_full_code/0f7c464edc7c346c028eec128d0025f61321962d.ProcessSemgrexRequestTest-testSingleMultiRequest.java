/** 
 * Test that the multiple request pathway works with 1 request
 */
@Test public void testSingleMultiRequest() throws IOException {
  byte[] request=buildRepeatedRequest(1,true);
  ByteArrayInputStream bin=new ByteArrayInputStream(request);
  ByteArrayOutputStream bout=new ByteArrayOutputStream();
  ProcessSemgrexRequest processor=new ProcessSemgrexRequest();
  processor.processMultipleInputs(bin,bout);
  checkRepeatedResults(bout.toByteArray(),1);
}
