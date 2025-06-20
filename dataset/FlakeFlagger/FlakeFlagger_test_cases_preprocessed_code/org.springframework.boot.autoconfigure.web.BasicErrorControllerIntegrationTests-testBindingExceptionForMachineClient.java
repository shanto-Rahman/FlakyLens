@Test @SuppressWarnings("rawtypes") public void testBindingExceptionForMachineClient() throws Exception {
assertThat(resp,containsString("Error count: 1"));
assertThat(resp,containsString("errors=[{"));
assertThat(resp,containsString("codes=["));
assertThat(resp,containsString("org.springframework.validation.BindException"));
}