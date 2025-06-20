@Test public void testCompareMd5(){
  final MockedStatic<ConfigCacheService> configCacheServiceMockedStatic=Mockito.mockStatic(ConfigCacheService.class);
  when(ConfigCacheService.isUptodate(anyString(),anyString(),anyString(),anyString())).thenReturn(false);
  Map<String,String> clientMd5Map=new HashMap<>();
  clientMd5Map.put("test","test");
  MockHttpServletRequest request=new MockHttpServletRequest();
  request.addHeader("Vipserver-Tag","test");
  MockHttpServletResponse response=new MockHttpServletResponse();
  List<String> changedGroupKeys=MD5Util.compareMd5(request,response,clientMd5Map);
  Assert.assertEquals(1,changedGroupKeys.size());
  Assert.assertEquals("test",changedGroupKeys.get(0));
  configCacheServiceMockedStatic.close();
}
