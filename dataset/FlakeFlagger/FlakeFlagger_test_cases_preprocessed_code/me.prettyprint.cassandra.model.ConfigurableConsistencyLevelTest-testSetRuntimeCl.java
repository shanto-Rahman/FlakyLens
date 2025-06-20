@Test public void testSetRuntimeCl(){
assertEquals(HConsistencyLevel.ANY,configurableConsistencyLevel.get(OperationType.READ,"OtherCf"));
}