@Test public void should_build_meta_data_with_field_level_constrained_bean() throws Exception {
assertThat(parsingResult.getMetaMap().get(BeanWithFieldLevelConstraint.class)).isSameAs(meta);
}