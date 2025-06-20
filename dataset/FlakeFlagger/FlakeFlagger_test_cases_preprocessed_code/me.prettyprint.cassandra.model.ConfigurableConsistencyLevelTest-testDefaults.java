@Test public void testDefaults(){
assertEquals(HConsistencyLevel.ALL,configurableConsistencyLevel.get(OperationType.WRITE,"MyColumnFamily"));
}