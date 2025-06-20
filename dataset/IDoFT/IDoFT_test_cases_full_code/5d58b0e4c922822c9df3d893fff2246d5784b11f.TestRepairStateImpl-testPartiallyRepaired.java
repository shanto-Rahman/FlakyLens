@Test public void testPartiallyRepaired(){
  long now=System.currentTimeMillis();
  long repairIntervalInMs=TimeUnit.HOURS.toMillis(1);
  long expectedAtLeastRepairedAt=now - repairIntervalInMs;
  RepairConfiguration repairConfiguration=repairConfiguration(repairIntervalInMs);
  Node node=mockNode("DC1");
  when(mockHostStates.isUp(eq(node))).thenReturn(true);
  VnodeRepairState vnodeRepairState=new VnodeRepairState(new LongTokenRange(1,2),ImmutableSet.of(node),VnodeRepairState.UNREPAIRED);
  VnodeRepairState repairedVnodeRepairState=new VnodeRepairState(new LongTokenRange(2,3),ImmutableSet.of(node),now);
  VnodeRepairStates vnodeRepairStates=VnodeRepairStatesImpl.newBuilder(Arrays.asList(vnodeRepairState,repairedVnodeRepairState)).build();
  when(mockVnodeRepairStateFactory.calculateNewState(eq(tableReference),isNull())).thenReturn(vnodeRepairStates);
  when(mockReplicaRepairGroupFactory.generateReplicaRepairGroups(repairGroupCaptor.capture())).thenReturn(Collections.singletonList(mockReplicaRepairGroup));
  RepairState repairState=new RepairStateImpl(tableReference,repairConfiguration,mockVnodeRepairStateFactory,mockHostStates,mockTableRepairMetrics,mockReplicaRepairGroupFactory,mockPostUpdateHook);
  RepairStateSnapshot repairStateSnapshot=repairState.getSnapshot();
  List<VnodeRepairState> capturedVnodeStates=repairGroupCaptor.getValue();
  assertThat(capturedVnodeStates).hasSize(1);
  VnodeRepairState capturedVnodeRepairState=capturedVnodeStates.get(0);
  assertVnodeRepairStateRepairedBefore(vnodeRepairState,capturedVnodeRepairState,System.currentTimeMillis() - repairIntervalInMs);
  assertRepairStateSnapshot(repairStateSnapshot,expectedAtLeastRepairedAt,Collections.singletonList(mockReplicaRepairGroup),vnodeRepairStates);
  verify(mockTableRepairMetrics).repairState(eq(tableReference),eq(1),eq(1));
  verify(mockTableRepairMetrics).lastRepairedAt(eq(tableReference),eq(repairStateSnapshot.lastCompletedAt()));
  verify(mockPostUpdateHook,times(1)).postUpdate(repairStateSnapshot);
}
