@Test public void testNoRecommend() throws Throwable {
  ContainerState containerState=TestRequestStateFactory.createContainer();
  ContainerDiff containerDiff=new ContainerDiff(containerState);
  assertEquals(ContainerRecommendation.Recommendation.NONE,ContainerRecommendation.recommend(containerDiff));
}
