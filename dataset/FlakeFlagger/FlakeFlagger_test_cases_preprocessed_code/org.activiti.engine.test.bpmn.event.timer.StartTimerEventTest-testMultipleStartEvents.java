public void testMultipleStartEvents(){
assertEquals(4,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().executable().count());
assertEquals(1,executableTimers.size());
assertEquals(4,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().executable().count());
assertEquals(2,executableTimers.size());
assertEquals(4,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().executable().count());
assertEquals(2,executableTimers.size());
assertEquals(2,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().executable().count());
assertEquals(2,executableTimers.size());
assertEquals(1,managementService.createTimerJobQuery().count());
assertEquals(0,managementService.createTimerJobQuery().executable().count());
}