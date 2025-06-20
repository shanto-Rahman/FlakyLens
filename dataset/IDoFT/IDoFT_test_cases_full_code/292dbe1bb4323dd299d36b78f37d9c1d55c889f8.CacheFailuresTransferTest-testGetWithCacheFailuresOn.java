@Test public void testGetWithCacheFailuresOn() throws Exception {
  String path="org/apache/maven/test/get-in-second-proxy/1.0/get-in-second-proxy-1.0.jar";
  Path expectedFile=managedDefaultDir.resolve(path);
  setupTestableManagedRepository(path);
  assertNotExistsInManagedDefaultRepo(expectedFile);
  BaseRepositoryContentLayout layout=managedDefaultRepository.getLayout(BaseRepositoryContentLayout.class);
  Artifact artifact=layout.getArtifact(path);
  saveRemoteRepositoryConfig("badproxied1","Bad Proxied 1","http://bad.machine.com/repo/","default");
  saveRemoteRepositoryConfig("badproxied2","Bad Proxied 2","http://bad.machine.com/anotherrepo/","default");
  saveConnector(ID_DEFAULT_MANAGED,"badproxied1",ChecksumPolicy.FIX,ReleasesPolicy.ALWAYS,SnapshotsPolicy.ALWAYS,CachedFailuresPolicy.YES,false);
  saveConnector(ID_DEFAULT_MANAGED,"badproxied2",ChecksumPolicy.FIX,ReleasesPolicy.ALWAYS,SnapshotsPolicy.ALWAYS,CachedFailuresPolicy.YES,false);
  wagonMock.get(EasyMock.eq(path),EasyMock.anyObject(File.class));
  EasyMock.expectLastCall().andThrow(new ResourceDoesNotExistException("resource does not exist.")).times(2);
  wagonMockControl.replay();
  StorageAsset downloadedFile=proxyHandler.fetchFromProxies(managedDefaultRepository.getRepository(),artifact);
  wagonMockControl.verify();
  wagonMockControl.reset();
  wagonMockControl.replay();
  downloadedFile=proxyHandler.fetchFromProxies(managedDefaultRepository.getRepository(),artifact);
  wagonMockControl.verify();
  assertNotDownloaded(downloadedFile);
  assertNoTempFiles(expectedFile);
}
