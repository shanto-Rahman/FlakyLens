@Deployment public void testHistoricActivityInstanceProperties(){
assertEquals(task.getId(),historicActivityInstance.getTaskId());
assertEquals("kermit",historicActivityInstance.getAssignee());
}