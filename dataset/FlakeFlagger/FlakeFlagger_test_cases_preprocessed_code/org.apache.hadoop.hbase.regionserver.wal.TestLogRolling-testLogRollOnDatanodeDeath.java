/** 
 * Tests that logs are rolled upon detecting datanode death Requires an HDFS jar with HDFS-826 & syncFs() support (HDFS-200)
 * @throws Exception
 */
public void testLogRollOnDatanodeDeath() throws Exception {
assertTrue("This test requires HLog file replication.",fs.getDefaultReplication() > 1);
assertTrue("Need HDFS-826 for this test",log.canGetCurReplicas());
assertTrue("Need append support for this test",HLog.isAppend(conf));
assertTrue(dfsCluster.getDataNodes().size() >= fs.getDefaultReplication() + 1);
assertTrue("Log should have a timestamp older than now",curTime > oldFilenum && oldFilenum != -1);
assertTrue("The log shouldn't have rolled yet",oldFilenum == log.getFilenum());
if (m.getName().endsWith("getPipeline")) {
}
assertTrue("Need DFSOutputStream.getPipeline() for this test",getPipeline != null);
assertTrue(pipeline.length == fs.getDefaultReplication());
assertTrue(dnprop != null);
assertTrue("Missing datanode should've triggered a log roll",newFilenum > oldFilenum && newFilenum > curTime);
assertTrue("The log should not roll again.",log.getFilenum() == newFilenum);
assertTrue("New log file should have the default replication",log.getLogReplication() == fs.getDefaultReplication());
}