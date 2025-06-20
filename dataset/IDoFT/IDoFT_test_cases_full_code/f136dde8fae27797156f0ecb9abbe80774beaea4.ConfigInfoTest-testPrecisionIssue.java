@Test public void testPrecisionIssue() throws Exception {
  EnvUtil.setEnvironment(new StandardEnvironment());
  IdGenerator generator=new SnowFlowerIdGenerator();
  long expected=generator.nextId();
  ConfigInfo configInfo=new ConfigInfo();
  configInfo.setId(expected);
  String json=JacksonUtils.toJson(configInfo);
  ConfigInfo actual=JacksonUtils.toObj(json,ConfigInfo.class);
  Assert.assertEquals(expected,actual.getId());
}
