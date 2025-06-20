@Test void objectMapperCustomizerShouldBeApplied() throws Exception {
  String actualHalJson=this.mockMvc.perform(get("/employees/0")).andReturn().getResponse().getContentAsString();
  String expectedHalJson=this.mapper.readFileContent("hal-custom.json");
  assertThat(actualHalJson).isEqualTo(expectedHalJson);
}
