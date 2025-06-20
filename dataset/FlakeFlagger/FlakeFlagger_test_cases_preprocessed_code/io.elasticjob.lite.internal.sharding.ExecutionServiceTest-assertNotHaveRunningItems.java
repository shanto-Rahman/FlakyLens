@Test public void assertNotHaveRunningItems(){
assertFalse(executionService.hasRunningItems(Arrays.asList(0,1,2)));
}