@Test public void testTwoGraphs(){
  CoreNLPProtos.SemgrexRequest request=buildFakeRequest(2,1);
  CoreNLPProtos.SemgrexResponse response=ProcessSemgrexRequest.processRequest(request);
  Assert.assertEquals("Expected exactly 2 replies",2,response.getResultList().size());
  checkResult(response.getResultList().get(0),1);
  checkResult(response.getResultList().get(1),1);
}
