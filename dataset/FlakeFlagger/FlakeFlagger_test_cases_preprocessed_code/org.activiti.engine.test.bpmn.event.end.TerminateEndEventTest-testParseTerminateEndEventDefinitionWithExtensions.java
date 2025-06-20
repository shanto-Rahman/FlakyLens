public void testParseTerminateEndEventDefinitionWithExtensions(){
assertThat(extensionElements.size(),is(1));
assertThat(strangeProperties.size(),is(1));
assertThat(strangeProperty.getNamespace(),is("http://activiti.org/bpmn"));
assertThat(strangeProperty.getElementText(),is("value"));
assertThat(strangeProperty.getAttributes().size(),is(1));
assertThat(id.getName(),is("id"));
assertThat(id.getValue(),is("strangeId"));
}