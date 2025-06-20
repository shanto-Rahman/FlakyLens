@Test public void assertGetLocalFailoverItemsIfShutdown(){
assertThat(failoverService.getLocalFailoverItems(),is(Collections.<Integer>emptyList()));
}