@Test public void testUndeployLeftoverJobs() throws Exception {
  final HeliosSoloDeployment solo=buildHeliosSoloDeployment();
  final ListenableFuture<List<String>> hostsFuture=Futures.<List<String>>immediateFuture(ImmutableList.of(HOST1,HOST2));
  when(heliosClient.listHosts()).thenReturn(hostsFuture);
  final ListenableFuture<HostStatus> statusFuture11=Futures.immediateFuture(HostStatus.newBuilder().setStatus(Status.UP).setStatuses(ImmutableMap.of(JOB_ID1,TASK_STATUS1)).setJobs(ImmutableMap.of(JOB_ID1,Deployment.of(JOB_ID1,Goal.START))).build());
  final ListenableFuture<HostStatus> statusFuture21=Futures.immediateFuture(HostStatus.newBuilder().setStatus(Status.UP).setStatuses(ImmutableMap.of(JOB_ID2,TASK_STATUS2)).setJobs(ImmutableMap.of(JOB_ID2,Deployment.of(JOB_ID2,Goal.START))).build());
  final ListenableFuture<HostStatus> statusFuture12=Futures.immediateFuture(HostStatus.newBuilder().setStatus(Status.UP).setStatuses(Collections.<JobId,TaskStatus>emptyMap()).setJobs(ImmutableMap.of(JOB_ID1,Deployment.of(JOB_ID1,Goal.START))).build());
  final ListenableFuture<HostStatus> statusFuture22=Futures.immediateFuture(HostStatus.newBuilder().setStatus(Status.UP).setStatuses(Collections.<JobId,TaskStatus>emptyMap()).setJobs(ImmutableMap.of(JOB_ID2,Deployment.of(JOB_ID2,Goal.START))).build());
  when(heliosClient.hostStatus(HOST1)).thenReturn(statusFuture11);
  when(heliosClient.hostStatus(HOST2)).thenReturn(statusFuture21);
  final ListenableFuture<JobUndeployResponse> undeployFuture1=Futures.immediateFuture(new JobUndeployResponse(JobUndeployResponse.Status.OK,HOST1,JOB_ID1));
  final ListenableFuture<JobUndeployResponse> undeployFuture2=Futures.immediateFuture(new JobUndeployResponse(JobUndeployResponse.Status.OK,HOST2,JOB_ID2));
  when(heliosClient.undeploy(JOB_ID1,HOST1)).thenAnswer(new Answer<ListenableFuture<JobUndeployResponse>>(){
    @Override public ListenableFuture<JobUndeployResponse> answer(    final InvocationOnMock invocation) throws Throwable {
      when(heliosClient.hostStatus(HOST1)).thenReturn(statusFuture12);
      return undeployFuture1;
    }
  }
);
  when(heliosClient.undeploy(JOB_ID2,HOST2)).thenAnswer(new Answer<ListenableFuture<JobUndeployResponse>>(){
    @Override public ListenableFuture<JobUndeployResponse> answer(    final InvocationOnMock invocation) throws Throwable {
      when(heliosClient.hostStatus(HOST1)).thenReturn(statusFuture22);
      return undeployFuture2;
    }
  }
);
  solo.undeployLeftoverJobs();
  verify(heliosClient).undeploy(JOB_ID1,HOST1);
  verify(heliosClient).undeploy(JOB_ID2,HOST2);
}
