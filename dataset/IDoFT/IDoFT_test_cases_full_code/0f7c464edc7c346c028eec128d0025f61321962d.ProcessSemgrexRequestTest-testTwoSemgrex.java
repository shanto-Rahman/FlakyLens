@Test public void testTwoSemgrex(){
  CoreNLPProtos.SemgrexRequest request=buildFakeRequest(1,2);
  CoreNLPProtos.SemgrexResponse response=ProcessSemgrexRequest.processRequest(request);
  Assert.assertEquals("Expected exactly 1 reply",1,response.getResultList().size());
  checkResult(response.getResultList().get(0),2);
}
