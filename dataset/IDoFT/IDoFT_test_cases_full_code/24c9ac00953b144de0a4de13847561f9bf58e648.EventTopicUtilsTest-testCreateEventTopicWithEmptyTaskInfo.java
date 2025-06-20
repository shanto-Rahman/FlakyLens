@Test(expected=LocalizableValidationException.class) public void testCreateEventTopicWithEmptyTaskInfo(){
  EventTopicUtils.registerEventTopic(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),false,new SchemaBuilder(),null,host);
}
