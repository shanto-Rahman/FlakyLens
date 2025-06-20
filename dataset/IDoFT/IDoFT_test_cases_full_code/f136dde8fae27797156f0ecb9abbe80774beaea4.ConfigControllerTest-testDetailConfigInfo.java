@Test public void testDetailConfigInfo() throws Exception {
  ConfigAllInfo configAllInfo=new ConfigAllInfo();
  configAllInfo.setDataId("test");
  configAllInfo.setGroup("test");
  configAllInfo.setCreateIp("localhost");
  configAllInfo.setCreateUser("test");
  when(persistService.findConfigAllInfo("test","test","")).thenReturn(configAllInfo);
  MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get(Constants.CONFIG_CONTROLLER_PATH).param("show","all").param("dataId","test").param("group","test").param("tenant","");
  String actualValue=mockmvc.perform(builder).andReturn().getResponse().getContentAsString();
  ConfigAllInfo resConfigAllInfo=JacksonUtils.toObj(actualValue,ConfigAllInfo.class);
  Assert.assertEquals(configAllInfo.getDataId(),resConfigAllInfo.getDataId());
  Assert.assertEquals(configAllInfo.getGroup(),resConfigAllInfo.getGroup());
  Assert.assertEquals(configAllInfo.getCreateIp(),resConfigAllInfo.getCreateIp());
  Assert.assertEquals(configAllInfo.getCreateUser(),resConfigAllInfo.getCreateUser());
}
