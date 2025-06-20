@Test public void should_detect_constrained_class() throws Exception {
assertThat(context.isClassConstrained(BeanWithFieldLevelConstraint.class)).isTrue();
}