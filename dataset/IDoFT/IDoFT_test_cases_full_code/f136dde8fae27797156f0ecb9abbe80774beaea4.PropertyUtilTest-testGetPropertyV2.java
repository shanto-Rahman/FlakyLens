@Test public void testGetPropertyV2(){
  final MockedStatic<EnvUtil> envUtilMockedStatic=Mockito.mockStatic(EnvUtil.class);
  EnvUtil.setEnvironment(configurableEnvironment);
  when(EnvUtil.getProperty(eq("test"),eq("default"))).thenReturn("default");
  Assert.assertEquals("default",new PropertyUtil().getProperty("test","default"));
  envUtilMockedStatic.close();
}
