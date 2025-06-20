@Test public void addNewConverters(){
assertTrue(converters.getConverters().contains(converter1));
assertEquals(converter1,converters.getConverters().get(0));
assertEquals(converter2,converters.getConverters().get(1));
}