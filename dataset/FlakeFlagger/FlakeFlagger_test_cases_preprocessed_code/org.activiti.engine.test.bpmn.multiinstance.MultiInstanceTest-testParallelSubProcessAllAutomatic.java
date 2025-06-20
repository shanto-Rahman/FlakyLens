@Deployment public void testParallelSubProcessAllAutomatic(){
assertTrue(waitSubExecutions.size() > 0);
assertEquals(0,waitSubExecutions.size());
assertEquals(10,runtimeService.getVariable(waitState.getId(),"sum"));
}