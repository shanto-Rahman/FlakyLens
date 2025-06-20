@Test public void should_FindCorrectDataInStats(){
  Mockito.when(configuration.isProductionMode()).thenReturn(true);
  TemplateParser instance=NpmTemplateParser.getInstance();
  TemplateParser.TemplateData templateContent=instance.getTemplateContent(Likeable.class,"likeable-element",service);
  Assert.assertEquals("Parent element ID not the expected one.","likeable-element",templateContent.getTemplateElement().parent().id());
  Assert.assertEquals("Expected template element to have 3 children",3,templateContent.getTemplateElement().childNodeSize());
  Assert.assertEquals("Template element should have contained a div element with the id 'test'","div",templateContent.getTemplateElement().getElementById("test").tag().toString());
}
