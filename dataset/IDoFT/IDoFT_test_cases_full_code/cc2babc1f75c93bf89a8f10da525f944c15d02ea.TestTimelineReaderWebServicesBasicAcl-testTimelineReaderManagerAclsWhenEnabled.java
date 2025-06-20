@Test public void testTimelineReaderManagerAclsWhenEnabled() throws Exception {
  Configuration config=new YarnConfiguration();
  config.setBoolean(YarnConfiguration.YARN_ACL_ENABLE,true);
  config.setBoolean(YarnConfiguration.FILTER_ENTITY_LIST_BY_USER,true);
  config.set(YarnConfiguration.YARN_ADMIN_ACL,adminUser);
  manager=new TimelineReaderManager(null);
  manager.init(config);
  manager.start();
  String user1="user1";
  String user2="user2";
  UserGroupInformation user1Ugi=UserGroupInformation.createRemoteUser(user1);
  UserGroupInformation user2Ugi=UserGroupInformation.createRemoteUser(user2);
  Assert.assertFalse(TimelineReaderWebServices.validateAuthUserWithEntityUser(manager,null,user1));
  try {
    TimelineReaderWebServices.checkAccess(manager,null,user1);
    Assert.fail("user1Ugi is not allowed to view user1");
  }
 catch (  ForbiddenException e) {
  }
  Assert.assertTrue(TimelineReaderWebServices.checkAccess(manager,adminUgi,user1));
  Assert.assertTrue(TimelineReaderWebServices.checkAccess(manager,adminUgi,user2));
  try {
    TimelineReaderWebServices.checkAccess(manager,user1Ugi,user2);
    Assert.fail("user1Ugi is not allowed to view user2");
  }
 catch (  ForbiddenException e) {
  }
  try {
    TimelineReaderWebServices.checkAccess(manager,user1Ugi,user2);
    Assert.fail("user2Ugi is not allowed to view user1");
  }
 catch (  ForbiddenException e) {
  }
  String userKey="user";
  Set<TimelineEntity> entities=createEntities(10,userKey);
  TimelineReaderWebServices.checkAccess(manager,adminUgi,entities,userKey,true);
  Assert.assertTrue(entities.size() == 10);
  entities=createEntities(5,userKey);
  TimelineReaderWebServices.checkAccess(manager,user1Ugi,entities,userKey,true);
  Assert.assertTrue(entities.size() == 1);
  Assert.assertEquals(user1,entities.iterator().next().getInfo().get(userKey));
  entities=createEntities(8,userKey);
  TimelineReaderWebServices.checkAccess(manager,user2Ugi,entities,userKey,true);
  Assert.assertTrue(entities.size() == 1);
  Assert.assertEquals(user2,entities.iterator().next().getInfo().get(userKey));
}
