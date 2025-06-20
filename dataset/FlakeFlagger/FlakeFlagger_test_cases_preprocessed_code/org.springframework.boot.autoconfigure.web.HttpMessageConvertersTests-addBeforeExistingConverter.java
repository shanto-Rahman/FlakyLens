@Test public void addBeforeExistingConverter(){
assertTrue(converters.getConverters().contains(converter1));
assertTrue(converters.getConverters().contains(converter2));
if (candidate instanceof MappingJackson2HttpMessageConverter) {
}
assertEquals(3,httpConverters.size());
assertEquals(0,httpConverters.indexOf(converter1));
assertEquals(1,httpConverters.indexOf(converter2));
}