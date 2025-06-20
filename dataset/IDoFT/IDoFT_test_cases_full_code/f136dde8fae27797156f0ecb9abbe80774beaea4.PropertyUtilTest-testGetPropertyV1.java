@Test public void testGetPropertyV1(){
  final MockedStatic<EnvUtil> envUtilMockedStatic=Mockito.mockStatic(EnvUtil.class);
  EnvUtil.setEnvironment(configurableEnvironment);
  when(EnvUtil.getProperty(eq("test"))).thenReturn("test");
  Assert.assertEquals("test",new PropertyUtil().getProperty("test"));
  envUtilMockedStatic.close();
}
