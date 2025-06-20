@Test public void testGetEntityPluginRead() throws Exception {
  EntityGroupFSTimelineStore store=null;
  ApplicationId appId=ApplicationId.fromString("application_1501509265053_0001");
  String user=UserGroupInformation.getCurrentUser().getShortUserName();
  Path userBase=new Path(testActiveDirPath,user);
  Path userAppRoot=new Path(userBase,appId.toString());
  Path attemotDirPath=new Path(userAppRoot,getAttemptDirName(appId));
  try {
    store=createAndStartTimelineStore(AppState.ACTIVE);
    String logFileName=EntityGroupFSTimelineStore.ENTITY_LOG_PREFIX + EntityGroupPlugInForTest.getStandardTimelineGroupId(appId);
    createTestFiles(appId,attemotDirPath,logFileName);
    TimelineEntity entity=store.getEntity(entityNew.getEntityId(),entityNew.getEntityType(),EnumSet.allOf(Field.class));
    assertNotNull(entity);
    assertEquals(entityNew.getEntityId(),entity.getEntityId());
    assertEquals(entityNew.getEntityType(),entity.getEntityType());
  }
  finally {
    if (store != null) {
      store.stop();
    }
    fs.delete(userBase,true);
  }
}
