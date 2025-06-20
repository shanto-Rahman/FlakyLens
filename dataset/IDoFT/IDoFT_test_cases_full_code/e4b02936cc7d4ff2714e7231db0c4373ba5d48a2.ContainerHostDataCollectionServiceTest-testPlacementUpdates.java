@Test public void testPlacementUpdates() throws Throwable {
  host.log(">>>> ResourcePool data collection test start <<<<<<<");
  ComputeDescription hostDescription=createComputeDescription();
  hostDescription=doPost(hostDescription,ComputeDescriptionService.FACTORY_LINK);
  ResourcePoolService.ResourcePoolState resourcePoolState=createAndStoreResourcePool();
  createAndStoreComputeState(hostDescription,resourcePoolState,MIN_MEMORY,1000L,0L,0.0,1);
  ComputeState second=createAndStoreComputeState(hostDescription,resourcePoolState,MIN_MEMORY,1000L,0L,0.0,1);
  doOperation(new ContainerHostDataCollectionState(),UriUtils.buildUri(host,ContainerHostDataCollectionService.HOST_INFO_DATA_COLLECTION_LINK),false,Service.Action.PATCH);
  waitFor(() -> {
    ResourcePoolService.ResourcePoolState resourcePoolStateUpdated=getDocument(ResourcePoolService.ResourcePoolState.class,resourcePoolState.documentSelfLink);
    return resourcePoolStateUpdated.maxMemoryBytes == MIN_MEMORY * 2;
  }
);
  GroupResourcePlacementService.GroupResourcePlacementState a100=createGroupResourcePlacementState(resourcePoolState.documentSelfLink,"A",100,MIN_MEMORY,700);
  GroupResourcePlacementService.GroupResourcePlacementState a200=createGroupResourcePlacementState(resourcePoolState.documentSelfLink,"A",200,MIN_MEMORY,800);
  doDelete(UriUtils.buildUri(host,second.documentSelfLink),false);
  doOperation(new ContainerHostDataCollectionState(),UriUtils.buildUri(host,ContainerHostDataCollectionService.HOST_INFO_DATA_COLLECTION_LINK),false,Service.Action.PATCH);
  waitFor(() -> {
    GroupResourcePlacementService.GroupResourcePlacementState placementStateA200=getDocument(GroupResourcePlacementService.GroupResourcePlacementState.class,a200.documentSelfLink);
    GroupResourcePlacementService.GroupResourcePlacementState placementStateA100=getDocument(GroupResourcePlacementService.GroupResourcePlacementState.class,a100.documentSelfLink);
    return placementStateA200.memoryLimit == 0 && placementStateA100.memoryLimit == MIN_MEMORY;
  }
);
  second=createAndStoreComputeState(hostDescription,resourcePoolState,MIN_MEMORY,1000L,0L,0.0,1);
  GroupResourcePlacementService.GroupResourcePlacementState b1=createGroupResourcePlacementState(resourcePoolState.documentSelfLink,"B",1,MIN_MEMORY,800);
  GroupResourcePlacementService.GroupResourcePlacementState b12=createGroupResourcePlacementState(resourcePoolState.documentSelfLink,"B",1,MIN_MEMORY,800);
  doDelete(UriUtils.buildUri(host,second.documentSelfLink),false);
  doOperation(new ContainerHostDataCollectionState(),UriUtils.buildUri(host,ContainerHostDataCollectionService.HOST_INFO_DATA_COLLECTION_LINK),false,Service.Action.PATCH);
  waitFor(() -> {
    GroupResourcePlacementService.GroupResourcePlacementState placementState=getDocument(GroupResourcePlacementService.GroupResourcePlacementState.class,b1.documentSelfLink);
    GroupResourcePlacementService.GroupResourcePlacementState placementState2=getDocument(GroupResourcePlacementService.GroupResourcePlacementState.class,b12.documentSelfLink);
    return placementState.memoryLimit == 0 && placementState2.memoryLimit == 0;
  }
);
  host.log(">>>> ResourcePool data collection test end <<<<<<<");
}
