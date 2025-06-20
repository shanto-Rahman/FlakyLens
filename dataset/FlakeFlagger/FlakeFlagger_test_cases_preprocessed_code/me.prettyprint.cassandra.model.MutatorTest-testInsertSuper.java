@Test public void testInsertSuper(){
assertTrue("Execute time should be > 0",r.getExecutionTimeMicro() > 0);
assertTrue("Should have operated on a host",r.getHostUsed() != null);
}