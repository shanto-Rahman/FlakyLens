@Test public void testSepculateSuccessfulWithUpdateEvents() throws Exception {
  Clock actualClock=SystemClock.getInstance();
  final ControlledClock clock=new ControlledClock(actualClock);
  clock.setTime(System.currentTimeMillis());
  MRApp app=new MRApp(NUM_MAPPERS,NUM_REDUCERS,false,"test",true,clock);
  Job job=app.submit(new Configuration(),true,true);
  app.waitForState(job,JobState.RUNNING);
  Map<TaskId,Task> tasks=job.getTasks();
  Assert.assertEquals("Num tasks is not correct",NUM_MAPPERS + NUM_REDUCERS,tasks.size());
  Iterator<Task> taskIter=tasks.values().iterator();
  while (taskIter.hasNext()) {
    app.waitForState(taskIter.next(),TaskState.RUNNING);
  }
  clock.setTime(System.currentTimeMillis() + 1000);
  EventHandler appEventHandler=app.getContext().getEventHandler();
  for (  Map.Entry<TaskId,Task> mapTask : tasks.entrySet()) {
    for (    Map.Entry<TaskAttemptId,TaskAttempt> taskAttempt : mapTask.getValue().getAttempts().entrySet()) {
      TaskAttemptStatus status=createTaskAttemptStatus(taskAttempt.getKey(),(float)0.5,TaskAttemptState.RUNNING);
      TaskAttemptStatusUpdateEvent event=new TaskAttemptStatusUpdateEvent(taskAttempt.getKey(),new AtomicReference<>(status));
      appEventHandler.handle(event);
    }
  }
  Task speculatedTask=null;
  int numTasksToFinish=NUM_MAPPERS + NUM_REDUCERS - 1;
  clock.setTime(System.currentTimeMillis() + 1000);
  for (  Map.Entry<TaskId,Task> task : tasks.entrySet()) {
    for (    Map.Entry<TaskAttemptId,TaskAttempt> taskAttempt : task.getValue().getAttempts().entrySet()) {
      if (numTasksToFinish > 0) {
        appEventHandler.handle(new TaskAttemptEvent(taskAttempt.getKey(),TaskAttemptEventType.TA_DONE));
        appEventHandler.handle(new TaskAttemptEvent(taskAttempt.getKey(),TaskAttemptEventType.TA_CONTAINER_COMPLETED));
        numTasksToFinish--;
        app.waitForState(taskAttempt.getValue(),TaskAttemptState.SUCCEEDED);
      }
 else {
        TaskAttemptStatus status=createTaskAttemptStatus(taskAttempt.getKey(),(float)0.75,TaskAttemptState.RUNNING);
        speculatedTask=task.getValue();
        TaskAttemptStatusUpdateEvent event=new TaskAttemptStatusUpdateEvent(taskAttempt.getKey(),new AtomicReference<>(status));
        appEventHandler.handle(event);
      }
    }
  }
  clock.setTime(System.currentTimeMillis() + 15000);
  for (  Map.Entry<TaskId,Task> task : tasks.entrySet()) {
    for (    Map.Entry<TaskAttemptId,TaskAttempt> taskAttempt : task.getValue().getAttempts().entrySet()) {
      if (taskAttempt.getValue().getState() != TaskAttemptState.SUCCEEDED) {
        TaskAttemptStatus status=createTaskAttemptStatus(taskAttempt.getKey(),(float)0.75,TaskAttemptState.RUNNING);
        TaskAttemptStatusUpdateEvent event=new TaskAttemptStatusUpdateEvent(taskAttempt.getKey(),new AtomicReference<>(status));
        appEventHandler.handle(event);
      }
    }
  }
  final Task speculatedTaskConst=speculatedTask;
  GenericTestUtils.waitFor(new Supplier<Boolean>(){
    @Override public Boolean get(){
      if (speculatedTaskConst.getAttempts().size() != 2) {
        clock.setTime(System.currentTimeMillis() + 1000);
        return false;
      }
 else {
        return true;
      }
    }
  }
,1000,60000);
  TaskAttempt[] ta=makeFirstAttemptWin(appEventHandler,speculatedTask);
  verifySpeculationMessage(app,ta);
  app.waitForState(Service.STATE.STOPPED);
}
