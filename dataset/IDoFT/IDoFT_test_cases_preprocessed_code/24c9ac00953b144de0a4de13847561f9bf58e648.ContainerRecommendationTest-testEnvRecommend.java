@Test public void testEnvRecommend() throws Throwable {
assertEquals(ContainerRecommendation.Recommendation.REDEPLOY,ContainerRecommendation.recommend(containerDiffs.get(0)));
}