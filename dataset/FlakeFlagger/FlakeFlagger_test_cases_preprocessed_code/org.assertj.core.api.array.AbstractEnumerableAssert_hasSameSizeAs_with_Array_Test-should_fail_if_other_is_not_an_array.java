@Test public void should_fail_if_other_is_not_an_array(){
assertThat(new byte[]{1,2}).hasSameSizeAs("a string");
}