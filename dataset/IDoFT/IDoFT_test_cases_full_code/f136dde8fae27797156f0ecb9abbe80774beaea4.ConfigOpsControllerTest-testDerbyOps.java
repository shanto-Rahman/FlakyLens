@Test public void testDerbyOps() throws Exception {
  MockedStatic propertyUtil=Mockito.mockStatic(PropertyUtil.class);
  when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  propertyUtil.close();
  Mockito.mockStatic(DynamicDataSource.class);
  DynamicDataSource dataSource=Mockito.mock(DynamicDataSource.class);
  when(DynamicDataSource.getInstance()).thenReturn(dataSource);
  LocalDataSourceServiceImpl dataSourceService=Mockito.mock(LocalDataSourceServiceImpl.class);
  when(dataSource.getDataSource()).thenReturn(dataSourceService);
  JdbcTemplate template=Mockito.mock(JdbcTemplate.class);
  when(dataSourceService.getJdbcTemplate()).thenReturn(template);
  when(template.queryForList("SELECT * FROM TEST")).thenReturn(new ArrayList<>());
  MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get(Constants.OPS_CONTROLLER_PATH + "/derby").param("sql","SELECT * FROM TEST");
  String actualValue=mockMvc.perform(builder).andReturn().getResponse().getContentAsString();
  Assert.assertEquals("200",JacksonUtils.toObj(actualValue).get("code").toString());
}
