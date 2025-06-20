/** 
 * This test triggers two checkpoints and then sends a decline message from one of the tasks for the first checkpoint. This should discard the first checkpoint while not triggering a new checkpoint because a later checkpoint is already in progress.
 */
@Test public void testTriggerAndDeclineCheckpointComplex(){
  try {
    final JobID jid=new JobID();
    final long timestamp=System.currentTimeMillis();
    final ExecutionAttemptID attemptID1=new ExecutionAttemptID();
    final ExecutionAttemptID attemptID2=new ExecutionAttemptID();
    ExecutionVertex vertex1=mockExecutionVertex(attemptID1);
    ExecutionVertex vertex2=mockExecutionVertex(attemptID2);
    CheckpointCoordinator coord=getCheckpointCoordinator(jid,vertex1,vertex2,failureManager,manuallyTriggeredScheduledExecutor);
    assertEquals(0,coord.getNumberOfPendingCheckpoints());
    assertEquals(0,coord.getNumberOfRetainedSuccessfulCheckpoints());
    assertEquals(0,manuallyTriggeredScheduledExecutor.getScheduledTasks().size());
    final CompletableFuture<CompletedCheckpoint> checkpointFuture1=coord.triggerCheckpoint(timestamp,false);
    manuallyTriggeredScheduledExecutor.triggerAll();
    assertFalse(checkpointFuture1.isCompletedExceptionally());
    final CompletableFuture<CompletedCheckpoint> checkpointFuture2=coord.triggerCheckpoint(timestamp + 2,false);
    manuallyTriggeredScheduledExecutor.triggerAll();
    assertFalse(checkpointFuture2.isCompletedExceptionally());
    assertEquals(2,coord.getNumberOfPendingCheckpoints());
    assertEquals(0,coord.getNumberOfRetainedSuccessfulCheckpoints());
    assertEquals(2,manuallyTriggeredScheduledExecutor.getScheduledTasks().size());
    Iterator<Map.Entry<Long,PendingCheckpoint>> it=coord.getPendingCheckpoints().entrySet().iterator();
    long checkpoint1Id=it.next().getKey();
    long checkpoint2Id=it.next().getKey();
    PendingCheckpoint checkpoint1=coord.getPendingCheckpoints().get(checkpoint1Id);
    PendingCheckpoint checkpoint2=coord.getPendingCheckpoints().get(checkpoint2Id);
    assertNotNull(checkpoint1);
    assertEquals(checkpoint1Id,checkpoint1.getCheckpointId());
    assertEquals(timestamp,checkpoint1.getCheckpointTimestamp());
    assertEquals(jid,checkpoint1.getJobId());
    assertEquals(2,checkpoint1.getNumberOfNonAcknowledgedTasks());
    assertEquals(0,checkpoint1.getNumberOfAcknowledgedTasks());
    assertEquals(0,checkpoint1.getOperatorStates().size());
    assertFalse(checkpoint1.isDiscarded());
    assertFalse(checkpoint1.areTasksFullyAcknowledged());
    assertNotNull(checkpoint2);
    assertEquals(checkpoint2Id,checkpoint2.getCheckpointId());
    assertEquals(timestamp + 2,checkpoint2.getCheckpointTimestamp());
    assertEquals(jid,checkpoint2.getJobId());
    assertEquals(2,checkpoint2.getNumberOfNonAcknowledgedTasks());
    assertEquals(0,checkpoint2.getNumberOfAcknowledgedTasks());
    assertEquals(0,checkpoint2.getOperatorStates().size());
    assertFalse(checkpoint2.isDiscarded());
    assertFalse(checkpoint2.areTasksFullyAcknowledged());
{
      verify(vertex1.getCurrentExecutionAttempt(),times(1)).triggerCheckpoint(eq(checkpoint1Id),eq(timestamp),any(CheckpointOptions.class));
      verify(vertex2.getCurrentExecutionAttempt(),times(1)).triggerCheckpoint(eq(checkpoint1Id),eq(timestamp),any(CheckpointOptions.class));
    }
{
      verify(vertex1.getCurrentExecutionAttempt(),times(1)).triggerCheckpoint(eq(checkpoint2Id),eq(timestamp + 2),any(CheckpointOptions.class));
      verify(vertex2.getCurrentExecutionAttempt(),times(1)).triggerCheckpoint(eq(checkpoint2Id),eq(timestamp + 2),any(CheckpointOptions.class));
    }
    coord.receiveDeclineMessage(new DeclineCheckpoint(jid,attemptID1,checkpoint1Id),TASK_MANAGER_LOCATION_INFO);
    assertTrue(checkpoint1.isDiscarded());
    assertEquals(1,coord.getNumberOfPendingCheckpoints());
    assertEquals(0,coord.getNumberOfRetainedSuccessfulCheckpoints());
    assertEquals(1,manuallyTriggeredScheduledExecutor.getScheduledTasks().size());
    long checkpointIdNew=coord.getPendingCheckpoints().entrySet().iterator().next().getKey();
    PendingCheckpoint checkpointNew=coord.getPendingCheckpoints().get(checkpointIdNew);
    assertEquals(checkpoint2Id,checkpointIdNew);
    assertNotNull(checkpointNew);
    assertEquals(checkpointIdNew,checkpointNew.getCheckpointId());
    assertEquals(jid,checkpointNew.getJobId());
    assertEquals(2,checkpointNew.getNumberOfNonAcknowledgedTasks());
    assertEquals(0,checkpointNew.getNumberOfAcknowledgedTasks());
    assertEquals(0,checkpointNew.getOperatorStates().size());
    assertFalse(checkpointNew.isDiscarded());
    assertFalse(checkpointNew.areTasksFullyAcknowledged());
    assertNotEquals(checkpoint1.getCheckpointId(),checkpointNew.getCheckpointId());
    coord.receiveDeclineMessage(new DeclineCheckpoint(jid,attemptID1,checkpoint1Id),TASK_MANAGER_LOCATION_INFO);
    coord.receiveDeclineMessage(new DeclineCheckpoint(jid,attemptID2,checkpoint1Id),TASK_MANAGER_LOCATION_INFO);
    assertTrue(checkpoint1.isDiscarded());
    coord.shutdown(JobStatus.FINISHED);
  }
 catch (  Exception e) {
    e.printStackTrace();
    fail(e.getMessage());
  }
}
