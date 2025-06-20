@Test public void assertGetLocalTakeOffItems(){
assertThat(failoverService.getLocalTakeOffItems(),is(Arrays.asList(0,1)));
}