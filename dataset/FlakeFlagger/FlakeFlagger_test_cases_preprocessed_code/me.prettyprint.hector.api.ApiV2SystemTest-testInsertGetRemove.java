@Test public void testInsertGetRemove(){
assertTrue("Time should be > 0",mr.getExecutionTimeMicro() > 0);
assertNotNull(r);
assertNotNull(c);
assertEquals("testInsertGetRemove_value_",value);
assertEquals("testInsertGetRemove",name);
assertEquals(q,r.getQuery());
assertTrue("Time should be > 0",r.getExecutionTimeMicro() > 0);
assertTrue("Time should be > 0",mr2.getExecutionTimeMicro() > 0);
assertNotNull(r2);
assertNull("Value should have been deleted",r2.get());
}