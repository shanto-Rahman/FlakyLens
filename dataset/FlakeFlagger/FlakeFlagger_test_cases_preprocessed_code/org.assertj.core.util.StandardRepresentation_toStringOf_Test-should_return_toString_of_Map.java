@Test public void should_return_toString_of_Map(){
assertEquals("{\"key1\"=\"value1\", \"key2\"=\"value2\"}",new StandardRepresentation().toStringOf(map));
}