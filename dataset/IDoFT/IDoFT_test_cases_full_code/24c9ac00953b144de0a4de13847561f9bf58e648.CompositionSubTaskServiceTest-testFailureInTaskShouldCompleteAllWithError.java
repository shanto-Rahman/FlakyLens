@Test public void testFailureInTaskShouldCompleteAllWithError() throws Throwable {
  CompositeDescription compositeDescription=createCompositeDescription("test1","test2");
  CompositionSubTaskState subTask1=createCompositionSubTask("test1",compositeDescription.documentSelfLink,compositeDescription.descriptionLinks.get(0));
  CompositionSubTaskState subTask2=createCompositionSubTask("test2",compositeDescription.documentSelfLink,compositeDescription.descriptionLinks.get(1));
  subTask1.dependentLinks=new HashSet<>(Arrays.asList(subTask2.documentSelfLink));
  subTask2.dependsOnLinks=new HashSet<>(Arrays.asList(subTask1.documentSelfLink));
  subTask1.customProperties=new HashMap<>();
  subTask1.customProperties.put(MockDockerAdapterService.FAILURE_EXPECTED,Boolean.TRUE.toString());
  subTask1=doPost(subTask1);
  subTask2=doPost(subTask2);
  subTask1=waitForTaskError(subTask1.documentSelfLink,CompositionSubTaskState.class);
  subTask2=waitForTaskError(subTask2.documentSelfLink,CompositionSubTaskState.class);
  assertNull(subTask1.resourceLinks);
  assertNull(subTask2.resourceLinks);
}
