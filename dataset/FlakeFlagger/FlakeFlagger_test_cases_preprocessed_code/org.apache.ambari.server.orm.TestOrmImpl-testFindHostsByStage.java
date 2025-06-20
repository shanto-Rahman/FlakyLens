@Test public void testFindHostsByStage(){
injector.getInstance(OrmTestHelper.class).createStageCommands();//RW
HostDAO hostDAO=injector.getInstance(HostDAO.class);//RW
StageDAO stageDAO=injector.getInstance(StageDAO.class);//RW
assertEquals(2,hosts.size());
}