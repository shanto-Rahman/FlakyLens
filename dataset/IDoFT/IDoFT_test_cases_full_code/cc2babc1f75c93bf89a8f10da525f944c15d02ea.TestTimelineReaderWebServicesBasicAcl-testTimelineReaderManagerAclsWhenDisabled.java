@Test public void testTimelineReaderManagerAclsWhenDisabled() throws Exception {
  config.setBoolean(YarnConfiguration.YARN_ACL_ENABLE,false);
  config.set(YarnConfiguration.YARN_ADMIN_ACL,adminUser);
  manager=new TimelineReaderManager(null);
  manager.init(config);
  manager.start();
  Assert.assertTrue(manager.checkAccess(null));
  Assert.assertFalse(TimelineReaderWebServices.isDisplayEntityPerUserFilterEnabled(config));
}
