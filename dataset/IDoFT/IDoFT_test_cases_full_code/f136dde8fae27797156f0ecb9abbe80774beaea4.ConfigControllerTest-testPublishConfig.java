@Test public void testPublishConfig() throws Exception {
  MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post(Constants.CONFIG_CONTROLLER_PATH).param("dataId","test").param("group","test").param("tenant","").param("content","test").param("tag","").param("appName","").param("src_user","").param("config_tags","").param("desc","").param("use","").param("effect","").param("type","").param("schema","");
  String actualValue=mockmvc.perform(builder).andReturn().getResponse().getContentAsString();
  Assert.assertEquals("true",actualValue);
}
