@Test public void testAbortHostRoleCommands(){
injector.getInstance(OrmTestHelper.class).createStageCommands();//RW
HostRoleCommandDAO hostRoleCommandDAO=injector.getInstance(HostRoleCommandDAO.class);//RW
assertEquals(2,result);
}