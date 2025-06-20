@Test public void testFindStageByHostRole(){
injector.getInstance(OrmTestHelper.class).createStageCommands();//RW
HostRoleCommandDAO hostRoleCommandDAO=injector.getInstance(HostRoleCommandDAO.class);//RW
assertEquals(1,list.size());
}