@Test public void testRuleRequest() throws Throwable {
assertEquals(ruleTargetAttributeModel.name(),"resource_id");
assertEquals(ruleTargetAttributeModel.operator(),"string_equals");
assertEquals(ruleTargetAttributeModel.value(),"f0f8f7994e754ff38f9d370201966561");
assertEquals(targetResourceModel.serviceName(),"iam-groups");
assertEquals(targetResourceModel.resourceKind(),"zone");
assertEquals(targetResourceModel.additionalTargetAttributes(),new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)));
assertEquals(ruleRequiredConfigModel.description(),"testString");
assertEquals(ruleRequiredConfigModel.property(),"public_access_enabled");
assertEquals(ruleRequiredConfigModel.operator(),"is_true");
assertEquals(ruleRequiredConfigModel.value(),"testString");
assertEquals(enforcementActionModel.action(),"disallow");
assertEquals(ruleRequestModel.accountId(),"testString");
assertEquals(ruleRequestModel.name(),"testString");
assertEquals(ruleRequestModel.description(),"testString");
assertEquals(ruleRequestModel.ruleType(),"user_defined");
assertEquals(ruleRequestModel.target(),targetResourceModel);
assertEquals(ruleRequestModel.requiredConfig(),ruleRequiredConfigModel);
assertEquals(ruleRequestModel.enforcementActions(),new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)));
assertEquals(ruleRequestModel.labels(),new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
assertTrue(ruleRequestModelNew instanceof RuleRequest);
assertEquals(ruleRequestModelNew.accountId(),"testString");
assertEquals(ruleRequestModelNew.name(),"testString");
assertEquals(ruleRequestModelNew.description(),"testString");
assertEquals(ruleRequestModelNew.ruleType(),"user_defined");
assertEquals(ruleRequestModelNew.target().toString(),targetResourceModel.toString());
assertEquals(ruleRequestModelNew.requiredConfig().toString(),ruleRequiredConfigModel.toString());
}