@Test void rendersRepresentationModelWithTemplates() throws Exception {
  EmployeeResource resource=new EmployeeResource("Frodo Baggins");
  Link link=Affordances.of(Link.of("/employees/1")).afford(HttpMethod.POST).withInputAndOutput(EmployeeResource.class).withName("foo").toLink();
  resource.add(link);
  assertThat(mapper.writeObject(resource)).isEqualTo(mapper.readFileContent("employee-resource-support.json"));
}
