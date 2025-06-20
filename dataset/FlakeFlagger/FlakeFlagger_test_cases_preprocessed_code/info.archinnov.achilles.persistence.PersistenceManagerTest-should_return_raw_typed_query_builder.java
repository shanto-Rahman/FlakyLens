@Test public void should_return_raw_typed_query_builder() throws Exception {
assertThat(builder).isNotNull();
assertThat(Whitebox.getInternalState(builder,DaoContext.class)).isSameAs(daoContext);
assertThat(Whitebox.getInternalState(builder,EntityMeta.class)).isSameAs(meta);
assertThat(Whitebox.getInternalState(builder,PersistenceContextFactory.class)).isSameAs(contextFactory);
assertThat(Whitebox.getInternalState(builder,String.class)).isEqualTo("querystring");
}