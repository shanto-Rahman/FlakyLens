@Test public void testDeleteEventsWithGroups() throws Throwable {
  int eventsCountGroup1=5;
  int eventsCountGroup2=2;
  String group1="/tenants/qe/groups/" + UUID.randomUUID().toString();
  String group2="/tenants/qe/groups/" + UUID.randomUUID().toString();
  createEventLogs(eventsCountGroup1,Collections.singletonList(group1));
  createEventLogs(eventsCountGroup2,Collections.singletonList(group2));
  ServiceDocumentDeleteTaskState deleteTaskState=doPostWithProjectHeader(request,ServiceDocumentDeleteTaskService.FACTORY_LINK,group1,ServiceDocumentDeleteTaskState.class);
  waitForTaskSuccess(deleteTaskState.documentSelfLink,ServiceDocumentDeleteTaskService.ServiceDocumentDeleteTaskState.class);
  verifyEventsCount(eventsCountGroup2);
  deleteTaskState=doPostWithProjectHeader(request,ServiceDocumentDeleteTaskService.FACTORY_LINK,group2,ServiceDocumentDeleteTaskState.class);
  waitForTaskSuccess(deleteTaskState.documentSelfLink,ServiceDocumentDeleteTaskService.ServiceDocumentDeleteTaskState.class);
  verifyEventsCount(0);
}
