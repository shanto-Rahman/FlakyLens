@Test public void verifySupervisorStartsAndStopsDockerContainer() throws Exception {
  final String containerId="deadbeef";
  when(docker.createContainer(any(ContainerConfig.class),any(String.class))).thenReturn(ContainerCreation.builder().id(containerId).build());
  final ImageInfo imageInfo=mock(ImageInfo.class);
  when(docker.inspectImage(IMAGE)).thenReturn(imageInfo);
  final SettableFuture<ContainerExit> waitFuture=SettableFuture.create();
  when(docker.waitContainer(containerId)).thenAnswer(futureAnswer(waitFuture));
  sut.setGoal(START);
  verify(docker,timeout(30000)).createContainer(containerConfigCaptor.capture(),containerNameCaptor.capture());
  verify(model,timeout(30000)).setTaskStatus(eq(JOB.getId()),eq(TaskStatus.newBuilder().setJob(JOB).setGoal(START).setState(CREATING).setContainerId(null).setEnv(ENV).build()));
  final ContainerConfig containerConfig=containerConfigCaptor.getValue();
  assertEquals(IMAGE,containerConfig.image());
  assertEquals(EXPECTED_CONTAINER_ENV,ImmutableSet.copyOf(containerConfig.env()));
  final String containerName=containerNameCaptor.getValue();
  assertEquals(JOB.getId().toShortString(),shortJobIdFromContainerName(containerName));
  verify(docker,timeout(30000)).startContainer(eq(containerId));
  verify(model,timeout(30000)).setTaskStatus(eq(JOB.getId()),eq(TaskStatus.newBuilder().setJob(JOB).setGoal(START).setState(STARTING).setContainerId(containerId).setEnv(ENV).build()));
  when(docker.inspectContainer(eq(containerId))).thenReturn(runningResponse);
  verify(docker,timeout(30000)).waitContainer(containerId);
  verify(model,timeout(30000)).setTaskStatus(eq(JOB.getId()),eq(TaskStatus.newBuilder().setJob(JOB).setGoal(START).setState(RUNNING).setContainerId(containerId).setEnv(ENV).build()));
  sut.setGoal(STOP);
  verify(docker,timeout(30000)).stopContainer(eq(containerId),eq(Supervisor.DEFAULT_SECONDS_TO_WAIT_BEFORE_KILL));
  when(docker.inspectContainer(eq(containerId))).thenReturn(stoppedResponse);
  verify(model,timeout(30000)).setTaskStatus(eq(JOB.getId()),eq(TaskStatus.newBuilder().setJob(JOB).setGoal(START).setState(PULLING_IMAGE).setContainerId(null).setEnv(ENV).build()));
  verify(model,timeout(30000)).setTaskStatus(eq(JOB.getId()),eq(TaskStatus.newBuilder().setJob(JOB).setGoal(STOP).setState(STOPPING).setContainerId(containerId).setEnv(ENV).build()));
  verify(model,timeout(30000)).setTaskStatus(eq(JOB.getId()),eq(TaskStatus.newBuilder().setJob(JOB).setGoal(STOP).setState(STOPPED).setContainerId(containerId).setEnv(ENV).build()));
}
