@Test public void testGetPropertyNames() throws Exception {
  String somePropertyName="somePropertyName";
  String anotherPropertyName="anotherPropertyName";
  Set<String> somePropertyNames=Sets.newHashSet(somePropertyName,anotherPropertyName);
  when(someConfig.getPropertyNames()).thenReturn(somePropertyNames);
  String[] result=configPropertySource.getPropertyNames();
  verify(someConfig,times(1)).getPropertyNames();
  assertArrayEquals(somePropertyNames.toArray(),result);
}
