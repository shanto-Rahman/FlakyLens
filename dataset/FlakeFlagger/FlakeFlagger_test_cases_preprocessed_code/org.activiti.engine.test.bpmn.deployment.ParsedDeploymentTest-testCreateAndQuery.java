public void testCreateAndQuery() throws UnsupportedEncodingException {
assertThat(parsedDeployment.getDeployment(),sameInstance(entity));
assertThat(processDefinitions.size(),equalTo(4));
assertThat(parsedDeployment.getBpmnParseForProcessDefinition(id1),sameInstance(parsedDeployment.getBpmnParseForProcessDefinition(id2)));
assertThat(parsedDeployment.getBpmnModelForProcessDefinition(id1),sameInstance(parsedDeployment.getBpmnParseForProcessDefinition(id1).getBpmnModel()));
assertThat(parsedDeployment.getProcessModelForProcessDefinition(id1),sameInstance(parsedDeployment.getBpmnParseForProcessDefinition(id1).getBpmnModel().getProcessById(id1.getKey())));
assertThat(parsedDeployment.getResourceForProcessDefinition(id1).getName(),equalTo(IDR_XML_NAME));
assertThat(parsedDeployment.getResourceForProcessDefinition(id2).getName(),equalTo(IDR_XML_NAME));
assertThat(parsedDeployment.getBpmnParseForProcessDefinition(en1),sameInstance(parsedDeployment.getBpmnParseForProcessDefinition(en2)));
assertThat(parsedDeployment.getBpmnParseForProcessDefinition(en1),not(equalTo(parsedDeployment.getBpmnParseForProcessDefinition(id2))));
assertThat(parsedDeployment.getResourceForProcessDefinition(en1).getName(),equalTo(EN_XML_NAME));
assertThat(parsedDeployment.getResourceForProcessDefinition(en2).getName(),equalTo(EN_XML_NAME));
}