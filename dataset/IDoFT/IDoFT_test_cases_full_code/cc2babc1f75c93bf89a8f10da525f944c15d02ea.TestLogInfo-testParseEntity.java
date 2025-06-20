@Test public void testParseEntity() throws Exception {
  TimelineDataManager tdm=PluginStoreTestUtils.getTdmWithMemStore(config);
  EntityLogInfo testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,TEST_ENTITY_FILE_NAME,UserGroupInformation.getLoginUser().getUserName());
  testLogInfo.parseForStore(tdm,getTestRootPath(),true,jsonFactory,objMapper,fs);
  PluginStoreTestUtils.verifyTestEntities(tdm);
  TimelineEntity entityNew=PluginStoreTestUtils.createEntity("id_3","type_3",789l,null,null,null,null,"domain_id_1");
  TimelineEntities entityList=new TimelineEntities();
  entityList.addEntity(entityNew);
  writeEntitiesLeaveOpen(entityList,new Path(getTestRootPath(TEST_ATTEMPT_DIR_NAME),TEST_ENTITY_FILE_NAME));
  testLogInfo.parseForStore(tdm,getTestRootPath(),true,jsonFactory,objMapper,fs);
  TimelineEntity entity3=tdm.getEntity(entityNew.getEntityType(),entityNew.getEntityId(),EnumSet.allOf(TimelineReader.Field.class),UserGroupInformation.getLoginUser());
  assertNotNull(entity3);
  assertEquals("Failed to read out entity new",entityNew.getStartTime(),entity3.getStartTime());
  tdm.close();
}
