@Test public void testGetTopTermsRandom5(){
  Map<String,AtlasJanusGraphIndexClient.TermFreq> terms=generateTerms(36,10,28,27,16,1,30,36,36);
  List<String> top5Terms=AtlasJanusGraphIndexClient.getTopTerms(terms);
  assertOrder(top5Terms,0,7,8,6,2);
}
