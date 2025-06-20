@Test public void testGetTopTermsRandom3(){
  Map<String,AtlasJanusGraphIndexClient.TermFreq> terms=generateTerms(36,36,28,27,16,1,30,3,10);
  List<String> top5Terms=AtlasJanusGraphIndexClient.getTopTerms(terms);
  assertOrder(top5Terms,0,1,6,2,3);
}
