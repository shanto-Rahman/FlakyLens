@Test public void testInvoke(){
assertThat(result.getValue(),CoreMatchers.<Object>is(5));
}