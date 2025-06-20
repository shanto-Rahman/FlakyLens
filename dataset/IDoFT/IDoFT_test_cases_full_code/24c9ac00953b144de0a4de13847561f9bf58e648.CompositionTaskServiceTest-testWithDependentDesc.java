@Test public void testWithDependentDesc() throws Throwable {
  ContainerDescription desc1=TestRequestStateFactory.createContainerDescription("name1");
  ContainerDescription desc2=TestRequestStateFactory.createContainerDescription("name2",false,false);
  desc2.affinity=new String[]{desc1.name};
  CompositeDescription compositeDesc=createCompositeDesc(desc1,desc2);
  RequestBrokerState request=startRequest(compositeDesc);
  request=waitForTaskSuccess(request.documentSelfLink,RequestBrokerState.class);
  assertValidRequest(request,compositeDesc);
}
