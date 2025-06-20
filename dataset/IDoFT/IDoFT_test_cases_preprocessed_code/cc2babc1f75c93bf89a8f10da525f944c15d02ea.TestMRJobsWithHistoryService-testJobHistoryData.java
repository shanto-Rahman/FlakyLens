@Test(timeout=90000) public void testJobHistoryData() throws IOException, InterruptedException, AvroRemoteException, ClassNotFoundException {
if (!(new File(MiniMRYarnCluster.APPJAR)).exists()) {//RO
}
sleepJob.setConf(mrCluster.getConfig());//RW
job.addFileToClassPath(APP_JAR);//RW
Thread.sleep(1000);
if (TERMINAL_RM_APP_STATES.contains(mrCluster.getResourceManager().getRMContext().getRMApps().get(appID).getState())) {//RW
}
if (pollElapsed >= 60000) {
}
Assert.assertEquals(RMAppState.FINISHED,mrCluster.getResourceManager().getRMContext().getRMApps().get(appID).getState());//RW
Assert.assertEquals(counterHS,counterMR);
}