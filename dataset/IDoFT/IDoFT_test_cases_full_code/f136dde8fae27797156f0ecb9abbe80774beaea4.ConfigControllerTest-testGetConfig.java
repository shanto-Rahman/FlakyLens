@Test public void testGetConfig() throws Exception {
  MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get(Constants.CONFIG_CONTROLLER_PATH).param("dataId","test").param("group","test").param("tenant","").param("tag","");
  int actualValue=mockmvc.perform(builder).andReturn().getResponse().getStatus();
  Assert.assertEquals(200,actualValue);
}
