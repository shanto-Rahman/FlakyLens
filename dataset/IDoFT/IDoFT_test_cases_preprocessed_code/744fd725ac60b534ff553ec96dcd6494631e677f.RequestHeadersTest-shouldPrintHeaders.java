@Test public void shouldPrintHeaders(){
assertThat(headers.toString()).isEqualTo("other header=[val2], header=[val, val3, val4]");
}