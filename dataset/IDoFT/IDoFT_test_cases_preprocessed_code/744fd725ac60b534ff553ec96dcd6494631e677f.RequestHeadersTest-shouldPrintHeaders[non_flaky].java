@Test public void shouldPrintHeaders(){
assertThat(headers.toString()).isEqualTo("header=[val, val3, val4], other header=[val2]");
}