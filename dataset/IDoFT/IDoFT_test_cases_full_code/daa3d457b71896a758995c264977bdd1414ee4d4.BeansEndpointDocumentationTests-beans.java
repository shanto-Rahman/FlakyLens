@Test public void beans() throws Exception {
  List<FieldDescriptor> beanFields=Arrays.asList(fieldWithPath("aliases").description("Names of any aliases."),fieldWithPath("scope").description("Scope of the bean."),fieldWithPath("type").description("Fully qualified type of the bean."),fieldWithPath("resource").description("Resource in which the bean was defined, if any.").optional(),fieldWithPath("dependencies").description("Names of any dependencies."));
  ResponseFieldsSnippet responseFields=responseFields(fieldWithPath("contexts").description("Application contexts keyed by id."),parentIdField(),fieldWithPath("contexts.*.beans").description("Beans in the application context keyed by name.")).andWithPrefix("contexts.*.beans.*.",beanFields);
  this.mockMvc.perform(get("/actuator/beans")).andExpect(status().isOk()).andDo(document("beans",preprocessResponse(limit(this::isIndependentBean,"contexts",getApplicationContext().getId(),"beans")),responseFields));
}
