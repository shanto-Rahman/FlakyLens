@Test public void testBatchMutationManagement(){
assertTrue("Execute time should be > 0",r.getExecutionTimeMicro() > 0);
assertTrue("Should have operated on a host",r.getHostUsed() != null);
assertEquals("Execute time should be 0",0,r.getExecutionTimeMicro());
assertEquals("Execute time should be 0",0,r.getExecutionTimeMicro());
assertTrue("Should have operated with a null host",r.getHostUsed() == null);
}