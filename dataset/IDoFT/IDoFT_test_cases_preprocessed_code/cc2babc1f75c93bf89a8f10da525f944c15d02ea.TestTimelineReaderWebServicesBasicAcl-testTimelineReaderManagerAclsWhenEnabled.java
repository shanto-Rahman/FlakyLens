@Test public void testTimelineReaderManagerAclsWhenEnabled() throws Exception {
config.set(YarnConfiguration.YARN_ADMIN_ACL,adminUser);//RW
Assert.assertFalse(TimelineReaderWebServices.validateAuthUserWithEntityUser(manager,null,user1));
Assert.fail("user1Ugi is not allowed to view user1");
Assert.assertTrue(TimelineReaderWebServices.checkAccess(manager,adminUgi,user1));//RW
Assert.assertTrue(TimelineReaderWebServices.checkAccess(manager,adminUgi,user2));//RW
Assert.fail("user1Ugi is not allowed to view user2");
Assert.fail("user2Ugi is not allowed to view user1");
TimelineReaderWebServices.checkAccess(manager,adminUgi,entities,userKey,true);//RW
Assert.assertTrue(entities.size() == 10);
Assert.assertTrue(entities.size() == 1);
Assert.assertEquals(user1,entities.iterator().next().getInfo().get(userKey));
Assert.assertTrue(entities.size() == 1);
Assert.assertEquals(user2,entities.iterator().next().getInfo().get(userKey));
}