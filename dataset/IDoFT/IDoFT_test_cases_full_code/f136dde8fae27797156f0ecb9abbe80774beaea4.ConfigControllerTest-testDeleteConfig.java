@Test public void testDeleteConfig() throws Exception {
  MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.delete(Constants.CONFIG_CONTROLLER_PATH).param("dataId","test").param("group","test").param("tenant","").param("tag","");
  String actualValue=mockmvc.perform(builder).andReturn().getResponse().getContentAsString();
  Assert.assertEquals("true",actualValue);
}
