@Test public void testImportDerby() throws Exception {
  MockedStatic propertyUtil=Mockito.mockStatic(PropertyUtil.class);
  when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  propertyUtil.close();
  Mockito.mockStatic(ApplicationUtils.class);
  when(ApplicationUtils.getBean(DatabaseOperate.class)).thenReturn(Mockito.mock(DatabaseOperate.class));
  MockMultipartFile file=new MockMultipartFile("file","test.zip","application/zip","test".getBytes());
  MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.multipart(Constants.OPS_CONTROLLER_PATH + "/data/removal").file(file);
  int actualValue=mockMvc.perform(builder).andReturn().getResponse().getStatus();
  Assert.assertEquals(200,actualValue);
}
