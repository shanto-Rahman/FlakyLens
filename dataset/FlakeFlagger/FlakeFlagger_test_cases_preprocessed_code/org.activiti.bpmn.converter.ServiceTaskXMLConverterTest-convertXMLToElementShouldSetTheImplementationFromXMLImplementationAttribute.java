@Test public void convertXMLToElementShouldSetTheImplementationFromXMLImplementationAttribute() throws Exception {
assertThat(((ServiceTask)element).getImplementation()).isEqualTo("myConnector");
}