@Test public void testIgnoreMarker() throws NullPointerException, EvaluationException, JoranException {
assertNotNull(evalMap);
assertTrue(evaluator.evaluate(event));
}