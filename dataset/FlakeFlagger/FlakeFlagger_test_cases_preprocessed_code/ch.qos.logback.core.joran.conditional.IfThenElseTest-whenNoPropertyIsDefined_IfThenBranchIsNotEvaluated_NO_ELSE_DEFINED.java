@Test public void whenNoPropertyIsDefined_IfThenBranchIsNotEvaluated_NO_ELSE_DEFINED() throws JoranException {
assertTrue(checker.isErrorFree(0));
}