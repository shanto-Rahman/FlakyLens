@Test public void testInvocation(){
assertThat(value,is(nullValue()));
assertThat(value,is("newValue"));
assertThat(value,is(nullValue()));
}