@Test void getUsingCustomMediaType() throws Exception {
  String results=this.mockMvc.perform(get("/employees/1").accept(FRODO_MEDIATYPE)).andExpect(header().string(HttpHeaders.CONTENT_TYPE,FRODO_MEDIATYPE.toString())).andReturn().getResponse().getContentAsString();
  assertThat(results).isEqualTo(read(new ClassPathResource("webmvc-frodo.json",getClass())));
}
