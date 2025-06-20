@Test public void testSynchronizeFlowWhenProposedMissingComponentsAreDifferent(){
  final FlowSynchronizer standardFlowSynchronizer=new StandardFlowSynchronizer(PropertyEncryptorFactory.getPropertyEncryptor(nifiProperties),nifiProperties,extensionManager);
  final Set<String> missingComponents=new HashSet<>();
  missingComponents.add("1");
  missingComponents.add("2");
  final DataFlow proposedDataFlow=mock(DataFlow.class);
  when(proposedDataFlow.getMissingComponents()).thenReturn(missingComponents);
  try {
    controller.synchronize(standardFlowSynchronizer,proposedDataFlow,mock(FlowService.class));
    Assert.fail("Should have thrown exception");
  }
 catch (  UninheritableFlowException e) {
    assertTrue(e.getMessage().contains("Proposed flow has missing components that are not considered missing in the current flow (1,2)"));
  }
}
