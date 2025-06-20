/** 
 * Test that when the diagram is generated for a model without graphic info then the default diagram image is returned or the ActivitiInterchangeInfoNotFoundException is thrown depending on the value of the generateDefaultDiagram parameter.
 */
@Deployment public void testGenerateDefaultDiagram() throws Exception {
assertThat(resourceStream).isNotNull();
assertThat(diagram).isNotNull();
assertThat(diagram).isEqualTo(IOUtils.toByteArray(imageStream));
}