@Test public void testInsert(){
assertTrue("Execution time on single insert should be > 0",mr.getExecutionTimeMicro() > 0);
assertTrue("Should have operated on a host",mr.getHostUsed() != null);
}