@Test public void should_return_native_query_builder() throws Exception {
assertThat(builder).isNotNull();
assertThat(Whitebox.getInternalState(builder,DaoContext.class)).isSameAs(daoContext);
assertThat(Whitebox.getInternalState(builder,String.class)).isEqualTo("queryString");
}