@Test public void testEmptyExpressionThrowsException() throws Exception {
  Map<String,Value> variables=new HashMap<>();
  variables.put("key1",ValueFactory.create("value1"));
  variables.put("key2",ValueFactory.create("value2"));
  final Context context=new Context(variables,Collections.<String,Value>emptyMap());
  when(scriptEvaluator.evalExpr(eq("expression"),eq(variables),eq(EMPTY_SET),eq(EMPTY_FUNCTION_SET))).thenReturn(ValueFactory.create(newArrayList()));
  RuntimeException exception=assertThrows(RuntimeException.class,() -> parallelLoopBinding.bindParallelLoopList(createBasicSyncLoopStatement(),context,EMPTY_SET,"nodeName"));
  Assert.assertEquals("Error evaluating parallel loop expression in step 'nodeName', error is: \n" + "expression is empty",exception.getMessage());
}
