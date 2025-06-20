@SuppressWarnings("unchecked") @Test public void testCollectorContextWithKeyword() throws Exception {
Assertions.assertEquals(0,validationResult.getValidationMessages().size());
Assertions.assertEquals(0,validationResult.getValidationMessages().size());
Assertions.assertEquals(2,contextValues.size());
Assertions.assertEquals(contextValues.get(0),"actual_value_added_to_context1");
Assertions.assertEquals(contextValues.get(1),"actual_value_added_to_context2");
}