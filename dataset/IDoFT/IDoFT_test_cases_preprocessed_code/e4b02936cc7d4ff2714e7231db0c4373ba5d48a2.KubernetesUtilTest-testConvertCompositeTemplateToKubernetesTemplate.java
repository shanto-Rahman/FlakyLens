@Test public void testConvertCompositeTemplateToKubernetesTemplate() throws IOException {
assertEquals(2,kubernetesTemplate.deployments.size());
assertEquals(2,kubernetesTemplate.services.size());
assertEquals(switchToUnixLineEnds(expectedMysqlDeployment).trim(),mysqlDeploymentSerialized);
assertEquals(switchToUnixLineEnds(expectedWordpressService).trim(),wordpressServiceSerialized);
assertEquals(switchToUnixLineEnds(expectedWordpressDeployment).trim(),wordpressDeploymentSerialized);
assertEquals(switchToUnixLineEnds(expectedMySqlService).trim(),mysqlServiceSerialized);
assertEquals(switchToUnixLineEnds(builder.toString()).trim(),kubernetesTemplateSerialized);
}