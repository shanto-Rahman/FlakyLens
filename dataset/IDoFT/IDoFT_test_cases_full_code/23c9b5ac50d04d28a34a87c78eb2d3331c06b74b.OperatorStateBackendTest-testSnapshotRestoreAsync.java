@Test public void testSnapshotRestoreAsync() throws Exception {
  OperatorStateBackend operatorStateBackend=new DefaultOperatorStateBackendBuilder(OperatorStateBackendTest.class.getClassLoader(),new ExecutionConfig(),true,emptyStateHandles,new CloseableRegistry()).build();
  ListStateDescriptor<MutableType> stateDescriptor1=new ListStateDescriptor<>("test1",new JavaSerializer<MutableType>());
  ListStateDescriptor<MutableType> stateDescriptor2=new ListStateDescriptor<>("test2",new JavaSerializer<MutableType>());
  ListStateDescriptor<MutableType> stateDescriptor3=new ListStateDescriptor<>("test3",new JavaSerializer<MutableType>());
  MapStateDescriptor<MutableType,MutableType> broadcastStateDescriptor1=new MapStateDescriptor<>("test4",new JavaSerializer<MutableType>(),new JavaSerializer<MutableType>());
  MapStateDescriptor<MutableType,MutableType> broadcastStateDescriptor2=new MapStateDescriptor<>("test5",new JavaSerializer<MutableType>(),new JavaSerializer<MutableType>());
  MapStateDescriptor<MutableType,MutableType> broadcastStateDescriptor3=new MapStateDescriptor<>("test6",new JavaSerializer<MutableType>(),new JavaSerializer<MutableType>());
  ListState<MutableType> listState1=operatorStateBackend.getListState(stateDescriptor1);
  ListState<MutableType> listState2=operatorStateBackend.getListState(stateDescriptor2);
  ListState<MutableType> listState3=operatorStateBackend.getUnionListState(stateDescriptor3);
  BroadcastState<MutableType,MutableType> broadcastState1=operatorStateBackend.getBroadcastState(broadcastStateDescriptor1);
  BroadcastState<MutableType,MutableType> broadcastState2=operatorStateBackend.getBroadcastState(broadcastStateDescriptor2);
  BroadcastState<MutableType,MutableType> broadcastState3=operatorStateBackend.getBroadcastState(broadcastStateDescriptor3);
  listState1.add(MutableType.of(42));
  listState1.add(MutableType.of(4711));
  listState2.add(MutableType.of(7));
  listState2.add(MutableType.of(13));
  listState2.add(MutableType.of(23));
  listState3.add(MutableType.of(17));
  listState3.add(MutableType.of(18));
  listState3.add(MutableType.of(19));
  listState3.add(MutableType.of(20));
  broadcastState1.put(MutableType.of(1),MutableType.of(2));
  broadcastState1.put(MutableType.of(2),MutableType.of(5));
  broadcastState2.put(MutableType.of(2),MutableType.of(5));
  BlockerCheckpointStreamFactory streamFactory=new BlockerCheckpointStreamFactory(1024 * 1024);
  OneShotLatch waiterLatch=new OneShotLatch();
  OneShotLatch blockerLatch=new OneShotLatch();
  streamFactory.setWaiterLatch(waiterLatch);
  streamFactory.setBlockerLatch(blockerLatch);
  RunnableFuture<SnapshotResult<OperatorStateHandle>> runnableFuture=operatorStateBackend.snapshot(1,1,streamFactory,CheckpointOptions.forCheckpointWithDefaultLocation());
  ExecutorService executorService=Executors.newFixedThreadPool(1);
  executorService.submit(runnableFuture);
  waiterLatch.await();
  listState1.add(MutableType.of(77));
  broadcastState1.put(MutableType.of(32),MutableType.of(97));
  int n=0;
  for (  MutableType mutableType : listState2.get()) {
    if (++n == 2) {
      blockerLatch.trigger();
    }
    mutableType.setValue(mutableType.getValue() + 10);
  }
  listState3.clear();
  broadcastState2.clear();
  operatorStateBackend.getListState(new ListStateDescriptor<>("test4",new JavaSerializer<MutableType>()));
  SnapshotResult<OperatorStateHandle> snapshotResult=runnableFuture.get();
  OperatorStateHandle stateHandle=snapshotResult.getJobManagerOwnedSnapshot();
  try {
    operatorStateBackend.close();
    operatorStateBackend.dispose();
    AbstractStateBackend abstractStateBackend=new MemoryStateBackend(4096);
    CloseableRegistry cancelStreamRegistry=new CloseableRegistry();
    operatorStateBackend=abstractStateBackend.createOperatorStateBackend(createMockEnvironment(),"testOperator",StateObjectCollection.singleton(stateHandle),cancelStreamRegistry);
    assertEquals(3,operatorStateBackend.getRegisteredStateNames().size());
    assertEquals(3,operatorStateBackend.getRegisteredBroadcastStateNames().size());
    listState1=operatorStateBackend.getListState(stateDescriptor1);
    listState2=operatorStateBackend.getListState(stateDescriptor2);
    listState3=operatorStateBackend.getUnionListState(stateDescriptor3);
    broadcastState1=operatorStateBackend.getBroadcastState(broadcastStateDescriptor1);
    broadcastState2=operatorStateBackend.getBroadcastState(broadcastStateDescriptor2);
    broadcastState3=operatorStateBackend.getBroadcastState(broadcastStateDescriptor3);
    assertEquals(3,operatorStateBackend.getRegisteredStateNames().size());
    assertEquals(3,operatorStateBackend.getRegisteredBroadcastStateNames().size());
    Iterator<MutableType> it=listState1.get().iterator();
    assertEquals(42,it.next().value);
    assertEquals(4711,it.next().value);
    assertFalse(it.hasNext());
    it=listState2.get().iterator();
    assertEquals(7,it.next().value);
    assertEquals(13,it.next().value);
    assertEquals(23,it.next().value);
    assertFalse(it.hasNext());
    it=listState3.get().iterator();
    assertEquals(17,it.next().value);
    assertEquals(18,it.next().value);
    assertEquals(19,it.next().value);
    assertEquals(20,it.next().value);
    assertFalse(it.hasNext());
    Iterator<Map.Entry<MutableType,MutableType>> bIt=broadcastState1.iterator();
    assertTrue(bIt.hasNext());
    Map.Entry<MutableType,MutableType> entry=bIt.next();
    assertEquals(1,entry.getKey().value);
    assertEquals(2,entry.getValue().value);
    assertTrue(bIt.hasNext());
    entry=bIt.next();
    assertEquals(2,entry.getKey().value);
    assertEquals(5,entry.getValue().value);
    assertFalse(bIt.hasNext());
    bIt=broadcastState2.iterator();
    assertTrue(bIt.hasNext());
    entry=bIt.next();
    assertEquals(2,entry.getKey().value);
    assertEquals(5,entry.getValue().value);
    assertFalse(bIt.hasNext());
    bIt=broadcastState3.iterator();
    assertFalse(bIt.hasNext());
    operatorStateBackend.close();
    operatorStateBackend.dispose();
  }
  finally {
    stateHandle.discardState();
  }
  executorService.shutdown();
}
