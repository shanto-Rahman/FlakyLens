@Test public void testLastRequestId(){
injector.getInstance(OrmTestHelper.class).createStageCommands();//RW
ClusterDAO clusterDAO=injector.getInstance(ClusterDAO.class);//RW
StageDAO stageDAO=injector.getInstance(StageDAO.class);//RW
assertEquals(0L,stageDAO.getLastRequestId());
}