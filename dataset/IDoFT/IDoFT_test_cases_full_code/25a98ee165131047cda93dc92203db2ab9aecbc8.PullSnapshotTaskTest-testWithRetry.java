@Test public void testWithRetry() throws StorageEngineException, IllegalPathException {
  boolean useAsyncServer=ClusterDescriptor.getInstance().getConfig().isUseAsyncServer();
  int pullSnapshotRetryIntervalMs=ClusterDescriptor.getInstance().getConfig().getPullSnapshotRetryIntervalMs();
  ClusterDescriptor.getInstance().getConfig().setUseAsyncServer(false);
  ClusterDescriptor.getInstance().getConfig().setPullSnapshotRetryIntervalMs(100);
  try {
    requiredRetries=3;
    testNormal(false);
  }
  finally {
    ClusterDescriptor.getInstance().getConfig().setUseAsyncServer(useAsyncServer);
    ClusterDescriptor.getInstance().getConfig().setPullSnapshotRetryIntervalMs(pullSnapshotRetryIntervalMs);
  }
}
