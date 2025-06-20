@Test public void testSalsaWithRandomGraph() throws Exception {
  Random random=new Random(12653467345382L);
  int maxNumLeftNodes=256;
  int leftDegree=64;
  int maxNumRightNodes=maxNumLeftNodes * leftDegree;
  double rightPowerLawExponent=2.0;
  SmallLeftRegularBipartiteGraph smallLeftRegularBipartiteGraph=new SmallLeftRegularBipartiteGraph(maxNumLeftNodes,leftDegree,maxNumRightNodes,maxNumLeftNodes,rightPowerLawExponent,Integer.MAX_VALUE,new NullStatsReceiver());
  double queryNodeWeightFraction=0.9;
  int maxNumResults=3;
  double resetProbability=0.3;
  int maxRandomWalkLength=5;
  int numRandomWalks=10000;
  int maxSocialProofSize=2;
  int maxSocialProofTypeSize=4;
  int expectedNodesToHit=numRandomWalks * maxRandomWalkLength * 10;
  ResultFilterChain resultFilterChain=new ResultFilterChain(Lists.newArrayList(new RequestedSetFilter(new NullStatsReceiver()),new DirectInteractionsFilter(smallLeftRegularBipartiteGraph,new NullStatsReceiver())));
  int maxUserId=1000;
  final SalsaStats expectedSalsaStats=new SalsaStats(1,64,998,21050,1,227,64);
  LongList metadata7=new LongArrayList(new long[]{0,0,0,0,0,0,0});
  LongList metadata10=new LongArrayList(new long[]{0,0,0,0,0,0,0,0,0,0});
  ArrayList<HashMap<Byte,ConnectingUsersWithMetadata>> socialProof=new ArrayList<>();
  for (int i=0; i < 3; i++) {
    socialProof.add(new HashMap<>());
  }
  socialProof.get(0).put((byte)0,new ConnectingUsersWithMetadata(new LongArrayList(new long[]{718,889,109,164,207,767,302,888,453,738}),metadata10));
  socialProof.get(1).put((byte)0,new ConnectingUsersWithMetadata(new LongArrayList(new long[]{47,96,499,306,396,805,351,875,308,186}),metadata10));
  socialProof.get(2).put((byte)0,new ConnectingUsersWithMetadata(new LongArrayList(new long[]{623,880,550,363,886,156,130}),metadata7));
  final List<RecommendationInfo> expectedTopResults=new ArrayList<RecommendationInfo>();
  expectedTopResults.add(new TweetRecommendationInfo(735,0.0010926365795724466,socialProof.get(0)));
  expectedTopResults.add(new TweetRecommendationInfo(119,0.0010451306413301663,socialProof.get(1)));
  expectedTopResults.add(new TweetRecommendationInfo(70,0.0010451306413301663,socialProof.get(2)));
  Set<Long> sourceIdList=Sets.newHashSetWithExpectedSize(maxNumLeftNodes);
  Set<Long> destinationIds=Sets.newHashSetWithExpectedSize(leftDegree);
  smallLeftRegularBipartiteGraph.reset();
  long userId=random.nextInt(maxUserId);
  SalsaRequest salsaRequest=new SalsaRequestBuilder(userId).withQueryNodeWeightFraction(queryNodeWeightFraction).withMaxNumResults(maxNumResults).withResetProbability(resetProbability).withMaxRandomWalkLength(maxRandomWalkLength).withNumRandomWalks(numRandomWalks).withMaxSocialProofSize(maxSocialProofSize).withMaxSocialProofTypeSize(maxSocialProofTypeSize).withResultFilterChain(resultFilterChain).build();
  sourceIdList.clear();
  for (int i=1; i <= maxNumLeftNodes; i++) {
    sourceIdList.add((long)random.nextInt(maxUserId));
  }
  sourceIdList.add(userId);
  for (  long sourceId : sourceIdList) {
    destinationIds.clear();
    for (int i=1; i <= leftDegree; i++) {
      destinationIds.add((long)random.nextInt(maxUserId));
    }
    for (    long destinationId : destinationIds) {
      smallLeftRegularBipartiteGraph.addEdge(sourceId,destinationId,(byte)0);
    }
  }
  Salsa salsa=new Salsa(smallLeftRegularBipartiteGraph,expectedNodesToHit,new NullStatsReceiver());
  SalsaResponse salsaResponse=salsa.computeRecommendations(salsaRequest,random);
  List<RecommendationInfo> salsaResults=Lists.newArrayList(salsaResponse.getRankedRecommendations());
  assertEquals(expectedSalsaStats,salsaResponse.getSalsaStats());
  assertEquals(expectedTopResults,salsaResults);
}
