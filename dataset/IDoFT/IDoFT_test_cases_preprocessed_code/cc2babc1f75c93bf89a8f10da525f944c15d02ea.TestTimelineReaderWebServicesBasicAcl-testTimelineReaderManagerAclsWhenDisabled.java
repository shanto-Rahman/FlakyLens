@Test public void testTimelineReaderManagerAclsWhenDisabled() throws Exception {
config.set(YarnConfiguration.YARN_ADMIN_ACL,adminUser);//RW
Assert.assertTrue(manager.checkAccess(null));
Assert.assertFalse(TimelineReaderWebServices.isDisplayEntityPerUserFilterEnabled(config));
}