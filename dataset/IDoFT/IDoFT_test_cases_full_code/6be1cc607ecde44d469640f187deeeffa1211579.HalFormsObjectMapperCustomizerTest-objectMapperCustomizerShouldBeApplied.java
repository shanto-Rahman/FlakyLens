@Test void objectMapperCustomizerShouldBeApplied() throws Exception {
  String actualHalFormsJson=mockMvc.perform(get("/employees/0")).andReturn().getResponse().getContentAsString();
  String expectedHalFormsJson=mapper.readFileContent("hal-forms-custom.json");
  assertThat(actualHalFormsJson).isEqualTo(expectedHalFormsJson);
}
