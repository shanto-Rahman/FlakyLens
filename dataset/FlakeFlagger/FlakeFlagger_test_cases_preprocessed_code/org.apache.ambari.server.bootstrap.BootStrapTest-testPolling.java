@Test public void testPolling() throws Exception {
FileUtils.writeStringToFile(new File(tmpFolder,"host1.done"),"0");
FileUtils.writeStringToFile(new File(tmpFolder,"host1.log"),"err_log_1");
FileUtils.writeStringToFile(new File(tmpFolder,"host2.done"),"1");
FileUtils.writeStringToFile(new File(tmpFolder,"host2.log"),"err_log_2");
Assert.assertTrue(polledHostStatus.size() == 2);
Assert.assertEquals(polledHostStatus.get(0).getHostName(),"host1");
Assert.assertEquals(polledHostStatus.get(0).getLog(),"err_log_1");
Assert.assertEquals(polledHostStatus.get(0).getStatus(),"DONE");
Assert.assertEquals(polledHostStatus.get(1).getHostName(),"host2");
Assert.assertEquals(polledHostStatus.get(1).getLog(),"err_log_2");
Assert.assertEquals(polledHostStatus.get(1).getStatus(),"FAILED");
}