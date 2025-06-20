@Test public void assertGetDisabledItems(){
assertThat(executionService.getDisabledItems(Arrays.asList(0,1,2)),is(Arrays.asList(0,1)));
}