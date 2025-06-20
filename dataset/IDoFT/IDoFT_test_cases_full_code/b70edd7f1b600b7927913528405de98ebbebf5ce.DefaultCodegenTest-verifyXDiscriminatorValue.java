@Test public void verifyXDiscriminatorValue(){
  final OpenAPI openAPI=TestUtils.parseFlattenSpec("src/test/resources/2_0/x-discriminator-value.yaml");
  final DefaultCodegen config=new DefaultCodegen();
  config.setOpenAPI(openAPI);
  String modelName;
  CodegenDiscriminator discriminator;
  Schema sc;
  CodegenModel cm;
  Boolean dryRun=Boolean.TRUE;
  final DefaultGenerator generator=new DefaultGenerator(dryRun);
  generator.openAPI=openAPI;
  generator.config=config;
  generator.configureGeneratorProperties();
  List<File> files=new ArrayList<>();
  List<String> filteredSchemas=ModelUtils.getSchemasUsedOnlyInFormParam(openAPI);
  List<Object> allModels=new ArrayList<>();
  generator.generateModels(files,allModels,filteredSchemas);
  modelName="BaseObj";
  cm=getModel(allModels,modelName);
  Assert.assertNotNull(cm);
  Assert.assertNotNull(cm.children);
  List<String> excpectedDiscriminatorValues=new ArrayList<>(Arrays.asList("daily","sub-obj"));
  ArrayList<String> xDiscriminatorValues=new ArrayList<>();
  for (  CodegenModel child : cm.children) {
    xDiscriminatorValues.add((String)child.vendorExtensions.get("x-discriminator-value"));
  }
  assertEquals(xDiscriminatorValues,excpectedDiscriminatorValues);
  discriminator=new CodegenDiscriminator();
  String prop="object_type";
  discriminator.setPropertyName(config.toVarName(prop));
  discriminator.setPropertyBaseName(prop);
  discriminator.setMapping(null);
  discriminator.setMappedModels(new HashSet<CodegenDiscriminator.MappedModel>(){
{
      add(new CodegenDiscriminator.MappedModel("DailySubObj","DailySubObj"));
      add(new CodegenDiscriminator.MappedModel("SubObj","SubObj"));
      add(new CodegenDiscriminator.MappedModel("daily","DailySubObj"));
      add(new CodegenDiscriminator.MappedModel("sub-obj","SubObj"));
    }
  }
);
  assertEquals(cm.discriminator,discriminator);
}
