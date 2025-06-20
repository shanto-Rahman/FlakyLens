@Test public void should_duplicate_for_new_entity() throws Exception {
assertThat(duplicateContext.stateHolderFacade.getEntity()).isSameAs(entity);
assertThat(duplicateContext.stateHolderFacade.getPrimaryKey()).isSameAs(primaryKey);
}