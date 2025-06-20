@Test public void testRequestStatusShouldNotBeModifiedAfterCompletion() throws Throwable {
assertEquals(compositeDesc.name,requestStatus.name);
assertNotNull(compositionTaskState);
assertEquals(1,requestStatus.resourceLinks.size());
assertEquals(compositionTaskState.compositeComponentLink,requestStatus.resourceLinks.iterator().next());
assertTrue(TaskState.isFinished(finalStatus.taskInfo));
}