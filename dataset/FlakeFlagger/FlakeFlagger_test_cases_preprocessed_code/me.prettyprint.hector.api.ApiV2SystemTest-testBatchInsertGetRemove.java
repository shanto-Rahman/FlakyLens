@Test public void testBatchInsertGetRemove(){
assertNotNull(r);
assertNotNull(c);
assertEquals("testInsertGetRemove_value_" + i,value);
assertNotNull(r);
assertNull("Value should have been deleted",r.get());
}