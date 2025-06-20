@Test public void testEnvRecommend() throws Throwable {
  ContainerDescription containerDescription=TestRequestStateFactory.createContainerDescription();
  ContainerState containerState=TestRequestStateFactory.createContainer();
  containerState.env=new String[]{"a=b"};
  List<ContainerDiff> containerDiffs=ContainerDiff.inspect(containerDescription,Lists.newArrayList(containerState));
  assertEquals(ContainerRecommendation.Recommendation.REDEPLOY,ContainerRecommendation.recommend(containerDiffs.get(0)));
}
