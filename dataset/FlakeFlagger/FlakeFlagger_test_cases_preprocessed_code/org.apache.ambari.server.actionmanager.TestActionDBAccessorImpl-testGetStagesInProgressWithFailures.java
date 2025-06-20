@Test public void testGetStagesInProgressWithFailures(){
assertEquals(1,stages.size());
assertEquals(requestId + 1,stages.get(0).getRequestId());
}