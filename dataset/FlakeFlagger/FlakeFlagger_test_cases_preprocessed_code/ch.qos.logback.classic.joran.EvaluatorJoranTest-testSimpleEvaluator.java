@Test public void testSimpleEvaluator() throws NullPointerException, EvaluationException, JoranException {
assertNotNull(evalMap);
assertNotNull(evaluator);
assertTrue(evaluator.evaluate(event0));
assertFalse(evaluator.evaluate(event1));
}