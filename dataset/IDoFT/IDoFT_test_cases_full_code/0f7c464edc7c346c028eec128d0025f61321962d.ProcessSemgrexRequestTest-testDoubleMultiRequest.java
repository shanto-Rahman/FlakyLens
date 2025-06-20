/** 
 * Test that the multiple request pathway works with 2 requests
 */
@Test public void testDoubleMultiRequest() throws IOException {
  byte[] request=buildRepeatedRequest(2,true);
  ByteArrayInputStream bin=new ByteArrayInputStream(request);
  ByteArrayOutputStream bout=new ByteArrayOutputStream();
  ProcessSemgrexRequest processor=new ProcessSemgrexRequest();
  processor.processMultipleInputs(bin,bout);
  checkRepeatedResults(bout.toByteArray(),2);
}
