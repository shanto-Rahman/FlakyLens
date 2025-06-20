@Test public void hashCodeAndEquals() throws Exception {
assertThat(bc.hashCode(),equalTo(bc.hashCode()));
assertThat(bc.hashCode(),equalTo(bc_substring.hashCode()));
assertThat(bc.hashCode(),equalTo(bc_string.hashCode()));
assertThat(bc,equalTo(bc));
assertThat(bc,equalTo(bc_substring));
assertThat(bc,equalTo(bc_string));
assertThat(bc.hashCode(),not(equalTo(abcd.hashCode())));
assertThat(bc,not(equalTo(abcd)));
}