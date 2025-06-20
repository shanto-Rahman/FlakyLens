@Test public void testRequestFailShouldDeleteTheCreatedDescriptions() throws Throwable {
  host.log("########  Start of testRequestFailShouldDeleteTheCreatedDescriptions ######## ");
  host.log("### Request a single container instance. Expected to fail because there is no placement associated with it ###.");
  final String containerDescLink=containerDesc.documentSelfLink;
  RequestBrokerState request=TestRequestStateFactory.createRequestState();
  request.resourceDescriptionLink=containerDescLink;
  request.tenantLinks=Arrays.asList("unknown");
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  waitForRequestToFail(request);
  waitFor("Container description is not deleted after waiting.",() -> {
    ContainerDescription cd=getDocumentNoWait(ContainerDescription.class,containerDescLink);
    return cd == null;
  }
);
  host.log("### Request a single network instance. Expected to fail because there is no placement associated with it ###.");
  final String containerNetDescLink=containerNetworkDesc.documentSelfLink;
  request=TestRequestStateFactory.createRequestState();
  request.resourceDescriptionLink=containerNetDescLink;
  request.tenantLinks=Arrays.asList("unknown");
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  waitForRequestToFail(request);
  waitFor("Container network description is not deleted after waiting.",() -> {
    ContainerNetworkDescription cd=getDocumentNoWait(ContainerNetworkDescription.class,containerNetDescLink);
    return cd == null;
  }
);
  host.log("### Request a single volume instance. Expected to fail because there is no placement created ###.");
  final String containerVolDescLink=containerVolumeDesc.documentSelfLink;
  request=TestRequestStateFactory.createRequestState();
  request.resourceDescriptionLink=containerVolDescLink;
  request.tenantLinks=Arrays.asList("unknown");
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  waitForRequestToFail(request);
  waitFor("Container volume description is not deleted after waiting.",() -> {
    ContainerVolumeDescription cd=getDocumentNoWait(ContainerVolumeDescription.class,containerVolDescLink);
    return cd == null;
  }
);
  host.log("### Request a composite component instance. Expected to fail because there is no placement created ###.");
  CompositeDescription compositeDesc=createCompositeDesc(true,false,containerDesc,containerNetworkDesc,containerVolumeDesc);
  assertNotNull(compositeDesc);
  request=TestRequestStateFactory.createRequestState(ResourceType.COMPOSITE_COMPONENT_TYPE.getName(),compositeDesc.documentSelfLink);
  request.tenantLinks=Arrays.asList("unknown");
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  waitForRequestToFail(request);
  final String containerDescriptionLink=containerDesc.documentSelfLink;
  final String containerNetDescriptionLink=containerNetworkDesc.documentSelfLink;
  final String containerVolDescriptionLink=containerVolumeDesc.documentSelfLink;
  final String compositeDescLink=compositeDesc.documentSelfLink;
  waitFor("Composite description is not deleted after waiting.",() -> {
    CompositeDescription cd=getDocumentNoWait(CompositeDescription.class,compositeDescLink);
    return cd == null;
  }
);
  waitFor("Container description should is not deleted after waiting.",() -> {
    ContainerDescription cd=getDocumentNoWait(ContainerDescription.class,containerDescriptionLink);
    return cd == null;
  }
);
  waitFor("Container network description is not deleted after waiting.",() -> {
    ContainerNetworkDescription cnd=getDocumentNoWait(ContainerNetworkDescription.class,containerNetDescriptionLink);
    return cnd == null;
  }
);
  waitFor("Container volume description is not deleted after waiting.",() -> {
    ContainerVolumeDescription cvd=getDocumentNoWait(ContainerVolumeDescription.class,containerVolDescriptionLink);
    return cvd == null;
  }
);
}
