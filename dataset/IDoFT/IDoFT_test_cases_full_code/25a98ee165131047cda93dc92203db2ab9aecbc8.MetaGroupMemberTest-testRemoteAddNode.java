@Test public void testRemoteAddNode(){
  System.out.println("Start testRemoteAddNode()");
  int prevTimeout=RaftServer.getConnectionTimeoutInMS();
  try {
    testMetaMember.setPartitionTable(null);
    AtomicReference<AddNodeResponse> result=new AtomicReference<>();
    GenericHandler<AddNodeResponse> handler=new GenericHandler<>(TestUtils.getNode(0),result);
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(10),TestUtils.getStartUpStatus(),handler);
    AddNodeResponse response=result.get();
    assertEquals(Response.RESPONSE_PARTITION_TABLE_UNAVAILABLE,response.getRespNum());
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(0),TestUtils.getStartUpStatus(),handler);
    assertNull(result.get());
    testMetaMember.setCharacter(LEADER);
    testMetaMember.onElectionWins();
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(10),TestUtils.getStartUpStatus(),handler);
    response=result.get();
    assertEquals(Response.RESPONSE_AGREE,response.getRespNum());
    assertEquals(partitionTable.serialize(),response.partitionTableBytes);
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(10),TestUtils.getStartUpStatus(),handler);
    response=result.get();
    assertEquals(Response.RESPONSE_AGREE,response.getRespNum());
    assertEquals(partitionTable.serialize(),response.partitionTableBytes);
    testMetaMember.setCharacter(FOLLOWER);
    testMetaMember.setLeader(TestUtils.getNode(1));
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(11),TestUtils.getStartUpStatus(),handler);
    while (result.get() == null) {
    }
    response=result.get();
    assertEquals(Response.RESPONSE_AGREE,response.getRespNum());
    assertEquals(partitionTable.serialize(),response.partitionTableBytes);
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    Node node=TestUtils.getNode(12).setNodeIdentifier(10);
    new MetaAsyncService(testMetaMember).addNode(node,TestUtils.getStartUpStatus(),handler);
    response=result.get();
    assertEquals(Response.RESPONSE_IDENTIFIER_CONFLICT,response.getRespNum());
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    node=TestUtils.getNode(13);
    StartUpStatus startUpStatus=TestUtils.getStartUpStatus();
    startUpStatus.setPartitionInterval(-1);
    new MetaAsyncService(testMetaMember).addNode(node,startUpStatus,handler);
    response=result.get();
    assertEquals(Response.RESPONSE_NEW_NODE_PARAMETER_CONFLICT,response.getRespNum());
    assertFalse(response.getCheckStatusResponse().isPartitionalIntervalEquals());
    assertTrue(response.getCheckStatusResponse().isHashSaltEquals());
    assertTrue(response.getCheckStatusResponse().isReplicationNumEquals());
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    node=TestUtils.getNode(12);
    startUpStatus=TestUtils.getStartUpStatus();
    startUpStatus.setHashSalt(0);
    new MetaAsyncService(testMetaMember).addNode(node,startUpStatus,handler);
    response=result.get();
    assertEquals(Response.RESPONSE_NEW_NODE_PARAMETER_CONFLICT,response.getRespNum());
    assertTrue(response.getCheckStatusResponse().isPartitionalIntervalEquals());
    assertFalse(response.getCheckStatusResponse().isHashSaltEquals());
    assertTrue(response.getCheckStatusResponse().isReplicationNumEquals());
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    node=TestUtils.getNode(12);
    startUpStatus=TestUtils.getStartUpStatus();
    startUpStatus.setReplicationNumber(0);
    new MetaAsyncService(testMetaMember).addNode(node,startUpStatus,handler);
    response=result.get();
    assertEquals(Response.RESPONSE_NEW_NODE_PARAMETER_CONFLICT,response.getRespNum());
    assertTrue(response.getCheckStatusResponse().isPartitionalIntervalEquals());
    assertTrue(response.getCheckStatusResponse().isHashSaltEquals());
    assertFalse(response.getCheckStatusResponse().isReplicationNumEquals());
    assertTrue(response.getCheckStatusResponse().isClusterNameEquals());
    dummyResponse.set(Response.RESPONSE_NO_CONNECTION);
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    new Thread(() -> {
      await().atLeast(200,TimeUnit.MILLISECONDS);
      dummyResponse.set(Response.RESPONSE_AGREE);
    }
).start();
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(12),TestUtils.getStartUpStatus(),handler);
    response=result.get();
    assertEquals(Response.RESPONSE_AGREE,response.getRespNum());
    dummyResponse.set(100);
    testMetaMember.setCharacter(LEADER);
    result.set(null);
    testMetaMember.setPartitionTable(partitionTable);
    new MetaAsyncService(testMetaMember).addNode(TestUtils.getNode(13),TestUtils.getStartUpStatus(),handler);
    response=result.get();
    assertNull(response);
  }
  finally {
    testMetaMember.stop();
    RaftServer.setConnectionTimeoutInMS(prevTimeout);
  }
}
