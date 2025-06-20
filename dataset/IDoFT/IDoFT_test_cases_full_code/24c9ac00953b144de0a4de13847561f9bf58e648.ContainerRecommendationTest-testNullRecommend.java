@Test(expected=LocalizableValidationException.class) public void testNullRecommend() throws Throwable {
  ContainerRecommendation.recommend(null);
}
