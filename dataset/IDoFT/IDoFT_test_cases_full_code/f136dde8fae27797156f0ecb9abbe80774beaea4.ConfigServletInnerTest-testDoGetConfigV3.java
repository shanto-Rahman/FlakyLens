@Test public void testDoGetConfigV3() throws Exception {
  final MockedStatic<ConfigCacheService> configCacheService=Mockito.mockStatic(ConfigCacheService.class);
  when(ConfigCacheService.tryReadLock(anyString())).thenReturn(0);
  MockHttpServletRequest request=new MockHttpServletRequest();
  MockHttpServletResponse response=new MockHttpServletResponse();
  String actualValue=configServletInner.doGetConfig(request,response,"test","test","test","test","true","localhost");
  Assert.assertEquals(HttpServletResponse.SC_NOT_FOUND + "",actualValue);
  when(ConfigCacheService.tryReadLock(anyString())).thenReturn(-1);
  actualValue=configServletInner.doGetConfig(request,response,"test","test","test","test","true","localhost");
  Assert.assertEquals(HttpServletResponse.SC_CONFLICT + "",actualValue);
  configCacheService.close();
}
