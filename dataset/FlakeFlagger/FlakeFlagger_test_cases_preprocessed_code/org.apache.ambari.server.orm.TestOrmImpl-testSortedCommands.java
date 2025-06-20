@Test public void testSortedCommands(){
injector.getInstance(OrmTestHelper.class).createStageCommands();//RW
HostRoleCommandDAO hostRoleCommandDAO=injector.getInstance(HostRoleCommandDAO.class);//RW
HostDAO hostDAO=injector.getInstance(HostDAO.class);//RW
StageDAO stageDAO=injector.getInstance(StageDAO.class);//RW
assertTrue(list.get(0).getTaskId() < list.get(1).getTaskId());
}