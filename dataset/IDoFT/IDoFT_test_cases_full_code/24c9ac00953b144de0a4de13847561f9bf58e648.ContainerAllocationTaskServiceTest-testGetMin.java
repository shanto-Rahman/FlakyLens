@Test public void testGetMin(){
  assertEquals(1,ContainerAllocationTaskService.getMinParam(0,1L).longValue());
  assertEquals(1,ContainerAllocationTaskService.getMinParam(1,null).longValue());
  assertEquals(1,ContainerAllocationTaskService.getMinParam(2,1L).longValue());
  assertEquals(1,ContainerAllocationTaskService.getMinParam(1,2L).longValue());
  assertEquals(0,ContainerAllocationTaskService.getMinParam(0,null).longValue());
  assertEquals(1,ContainerAllocationTaskService.getMinParam(1,0L).longValue());
}
