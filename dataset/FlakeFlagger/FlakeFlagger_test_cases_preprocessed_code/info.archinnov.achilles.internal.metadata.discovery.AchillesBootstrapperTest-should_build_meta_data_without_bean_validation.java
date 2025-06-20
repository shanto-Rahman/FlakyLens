@Test public void should_build_meta_data_without_bean_validation() throws Exception {
assertThat(parsingResult.getMetaMap().get(UserBean.class)).isSameAs(meta);
assertThat(parsingResult.hasSimpleCounter()).isFalse();
}