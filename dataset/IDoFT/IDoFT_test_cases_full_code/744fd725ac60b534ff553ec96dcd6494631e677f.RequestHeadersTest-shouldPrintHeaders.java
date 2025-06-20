@Test public void shouldPrintHeaders(){
  RequestHeaders headers=RequestHeaders.builder().add("header","val").add("other header","val2").add("header",Arrays.asList("val3","val4")).build();
  assertThat(headers.toString()).isEqualTo("other header=[val2], header=[val, val3, val4]");
}
