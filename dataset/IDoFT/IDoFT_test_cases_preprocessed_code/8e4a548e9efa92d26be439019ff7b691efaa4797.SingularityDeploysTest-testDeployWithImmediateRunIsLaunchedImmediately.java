@Test public void testDeployWithImmediateRunIsLaunchedImmediately(){
Assertions.assertEquals(1,taskManager.getNumActiveTasks());
Assertions.assertEquals(0,taskManager.getNumScheduledTasks());
Assertions.assertEquals("printenv > tmp.txt",(String)command.get("value"));
}