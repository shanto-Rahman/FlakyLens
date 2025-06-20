@Test public void executeValidationShouldRiseErrorsForEmptyServiceTask(){
assertThat(errors).hasSize(1);
assertThat(errors.get(0).getProblem()).isEqualTo("activiti-servicetask-missing-implementation");
assertThat(errors.get(0).getDefaultDescription()).isEqualTo("One of the attributes 'implementation', 'class', 'delegateExpression', 'type', 'operation', or 'expression' is mandatory on serviceTask.");
}