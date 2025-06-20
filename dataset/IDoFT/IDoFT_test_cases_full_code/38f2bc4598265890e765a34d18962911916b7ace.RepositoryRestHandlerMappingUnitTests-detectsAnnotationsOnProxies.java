@Test public void detectsAnnotationsOnProxies(){
  Class<?> type=createProxy(new SomeController());
  RepositoryRestConfiguration configuration=mock(RepositoryRestConfiguration.class);
  doReturn(URI.create("")).when(configuration).getBasePath();
  HandlerMappingStub mapping=new HandlerMappingStub(mock(ResourceMappings.class),configuration);
  assertThat(mapping.isHandler(type)).isTrue();
}
