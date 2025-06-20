@Test public void assertGetFailoverItems(){
assertThat(failoverService.getFailoverItems("127.0.0.1@-@1"),is(Collections.singletonList(1)));
}