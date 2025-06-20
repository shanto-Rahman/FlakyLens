@Test public void assertGetLocalFailoverItems(){
assertThat(failoverService.getLocalFailoverItems(),is(Collections.singletonList(0)));
}