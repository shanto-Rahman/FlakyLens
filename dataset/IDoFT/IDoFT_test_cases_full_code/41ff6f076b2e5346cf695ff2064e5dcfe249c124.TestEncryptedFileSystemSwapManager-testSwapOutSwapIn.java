/** 
 * Test a simple swap to disk / swap from disk operation.  Configured to use  {@link StaticKeyProvider}.
 */
@Test public void testSwapOutSwapIn() throws GeneralSecurityException, IOException {
  final File folderRepository=Files.createTempDirectory(getClass().getSimpleName()).toFile();
  folderRepository.deleteOnExit();
  new File(folderRepository,"swap").deleteOnExit();
  final Properties properties=new Properties();
  properties.put(NiFiProperties.FLOWFILE_REPOSITORY_ENCRYPTION_KEY_PROVIDER_IMPLEMENTATION_CLASS,StaticKeyProvider.class.getName());
  properties.put(NiFiProperties.FLOWFILE_REPOSITORY_ENCRYPTION_KEY_ID,NiFiProperties.FLOWFILE_REPOSITORY_ENCRYPTION_KEY);
  properties.put(NiFiProperties.FLOWFILE_REPOSITORY_ENCRYPTION_KEY,StringUtils.repeat("00",32));
  properties.put(NiFiProperties.FLOWFILE_REPOSITORY_DIRECTORY,folderRepository.getPath());
  final NiFiProperties nifiProperties=NiFiProperties.createBasicNiFiProperties(null,properties);
  final List<FlowFileRecord> flowFiles=new ArrayList<>();
  for (int i=0; (i < 100); ++i) {
    flowFiles.add(new StandardFlowFileRecord.Builder().id(i).build());
  }
  final FlowFileSwapManager swapManager=createSwapManager(nifiProperties);
  final String queueIdentifier=UUID.randomUUID().toString();
  final FlowFileQueue flowFileQueue=Mockito.mock(FlowFileQueue.class);
  when(flowFileQueue.getIdentifier()).thenReturn(queueIdentifier);
  final String swapPath=swapManager.swapOut(flowFiles,flowFileQueue,"partition-1");
  final SwapContents swapContents=swapManager.swapIn(swapPath,flowFileQueue);
  final List<FlowFileRecord> flowFilesRecovered=swapContents.getFlowFiles();
  Assert.assertEquals(flowFiles.size(),flowFilesRecovered.size());
  Assert.assertTrue(flowFilesRecovered.containsAll(flowFiles));
  Assert.assertTrue(flowFiles.containsAll(flowFilesRecovered));
}
