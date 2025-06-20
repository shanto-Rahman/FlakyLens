@Test public void testRequestStatusShouldNotBeModifiedAfterCompletion() throws Throwable {
  ContainerDescription desc1=TestRequestStateFactory.createContainerDescription("name1");
  desc1.portBindings=null;
  ContainerDescription desc2=TestRequestStateFactory.createContainerDescription("name2");
  desc2.portBindings=null;
  desc2.affinity=new String[]{desc1.name};
  CompositeDescription compositeDesc=createCompositeDesc(desc1,desc2);
  RequestStatus requestStatus=verifyRequestStatus(compositeDesc.documentSelfLink,ResourceType.COMPOSITE_COMPONENT_TYPE);
  assertEquals(compositeDesc.name,requestStatus.name);
  String compositionTaskLink=UriUtils.buildUriPath(CompositionTaskFactoryService.SELF_LINK,extractId(requestStatus.documentSelfLink));
  CompositionTaskState compositionTaskState=getDocument(CompositionTaskState.class,compositionTaskLink);
  assertNotNull(compositionTaskState);
  assertEquals(1,requestStatus.resourceLinks.size());
  assertEquals(compositionTaskState.compositeComponentLink,requestStatus.resourceLinks.iterator().next());
  requestStatus.taskInfo=TaskState.createAsStarted();
  doOperation(requestStatus,UriUtils.buildUri(host,requestStatus.documentSelfLink),false,Action.PATCH);
  RequestStatus finalStatus=getRequestStatus(requestId);
  assertTrue(TaskState.isFinished(finalStatus.taskInfo));
}
