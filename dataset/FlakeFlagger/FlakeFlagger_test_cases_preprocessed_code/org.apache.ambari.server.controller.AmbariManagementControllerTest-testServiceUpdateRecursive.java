@Test public void testServiceUpdateRecursive() throws AmbariException {
fail("Expected failure for invalid state update");
fail("Expected failure for invalid state update");
Assert.assertEquals(State.STARTED,s1.getDesiredState());
Assert.assertEquals(State.STARTED,s2.getDesiredState());
Assert.assertEquals(State.STARTED,sc1.getDesiredState());
Assert.assertEquals(State.STARTED,sc2.getDesiredState());
Assert.assertEquals(State.STARTED,sc3.getDesiredState());
Assert.assertEquals(State.INSTALLED,sc4.getDesiredState());
Assert.assertEquals(State.STARTED,sch1.getDesiredState());
Assert.assertEquals(State.STARTED,sch2.getDesiredState());
Assert.assertEquals(State.STARTED,sch3.getDesiredState());
Assert.assertEquals(State.STARTED,sch4.getDesiredState());
Assert.assertEquals(State.STARTED,sch5.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch6.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch1.getState());
Assert.assertEquals(State.START_FAILED,sch2.getState());
Assert.assertEquals(State.INSTALLED,sch3.getState());
Assert.assertEquals(State.STARTED,sch4.getState());
Assert.assertEquals(State.INSTALLED,sch5.getState());
Assert.assertEquals(State.INSTALLED,sch6.getState());
Assert.assertTrue(!stages.isEmpty());
Assert.assertEquals(3,stages.size());
if (s.getStageId() == 1) {
}
if (s.getStageId() == 2) {
}
if (s.getStageId() == 3) {
}
Assert.assertEquals(2,stage1.getExecutionCommands(host1).size());
Assert.assertEquals(1,stage1.getExecutionCommands(host2).size());
Assert.assertEquals(1,stage2.getExecutionCommands(host1).size());
Assert.assertNotNull(stage1.getExecutionCommandWrapper(host1,"NAMENODE"));
Assert.assertNotNull(stage1.getExecutionCommandWrapper(host1,"DATANODE"));
Assert.assertNotNull(stage1.getExecutionCommandWrapper(host2,"NAMENODE"));
Assert.assertNotNull(stage2.getExecutionCommandWrapper(host1,"HBASE_MASTER"));
Assert.assertNull(stage1.getExecutionCommandWrapper(host2,"DATANODE"));
Assert.assertNotNull(stage3.getExecutionCommandWrapper(host1,"HBASE_SERVICE_CHECK"));
Assert.assertNotNull(stage2.getExecutionCommandWrapper(host2,"HDFS_SERVICE_CHECK"));
Assert.assertNull(trackAction);
}