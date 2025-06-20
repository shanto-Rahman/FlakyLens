@Test public void testMRAppMasterShutDownJob() throws Exception, InterruptedException {
conf.set(MRJobConfig.MR_AM_STAGING_DIR,stagingDir);//RW
File stagingDir=new File(MRApps.getStagingAreaDir(conf,userName).toString());//RW//RO
stagingDir.mkdirs();//RW
Assert.assertTrue("Expected shutDownJob to terminate.",ExitUtil.terminateCalled());
Assert.assertEquals("Expected shutDownJob to exit with status code of 0.",0,ExitUtil.getFirstExitException().status);
assertTrue("Expected message from ExitUtil.ExitException to be " + msg,ExitUtil.getFirstExitException().getMessage().contains(msg));
Assert.assertEquals("Expected shutDownJob to exit with status code of 1.",1,ExitUtil.getFirstExitException().status);
}