@Test public void testNoRecommend() throws Throwable {
assertEquals(ContainerRecommendation.Recommendation.NONE,ContainerRecommendation.recommend(containerDiff));
}