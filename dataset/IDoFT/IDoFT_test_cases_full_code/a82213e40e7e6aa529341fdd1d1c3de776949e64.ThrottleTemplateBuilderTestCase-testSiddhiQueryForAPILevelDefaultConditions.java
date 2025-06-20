@Test public void testSiddhiQueryForAPILevelDefaultConditions() throws APITemplateException {
  APIPolicy apiPolicy=SampleTestObjectCreator.createDefaultAPIPolicy();
  APIThrottlePolicyTemplateBuilder templateBuilder=new APIThrottlePolicyTemplateBuilder(apiPolicy);
  String actualQuery=templateBuilder.getThrottlePolicyTemplateForAPILevelDefaultCondition();
  String expectedQuery=SampleTestObjectCreator.createDefaultSiddhiAppForAPILevelDefaultThrottlePolicy();
  Assert.assertEquals(actualQuery,expectedQuery);
}
