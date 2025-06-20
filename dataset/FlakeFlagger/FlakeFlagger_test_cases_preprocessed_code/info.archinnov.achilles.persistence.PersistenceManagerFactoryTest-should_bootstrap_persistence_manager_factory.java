@Test public void should_bootstrap_persistence_manager_factory() throws Exception {
assertThat(pmf.entityMetaMap).isSameAs(entityMetaMap);
assertThat(pmf.configContext).isSameAs(configContext);
assertThat(pmf.daoContext).isSameAs(daoContext);
assertThat(Whitebox.getInternalState(contextFactory,DaoContext.class)).isSameAs(daoContext);
assertThat(Whitebox.getInternalState(contextFactory,ConfigurationContext.class)).isSameAs(configContext);
assertThat(Whitebox.getInternalState(contextFactory,"entityMetaMap")).isSameAs(entityMetaMap);
assertThat(Whitebox.getInternalState(schemaContext,Cluster.class)).isSameAs(cluster);
assertThat(Whitebox.getInternalState(schemaContext,Session.class)).isSameAs(session);
assertThat(Whitebox.getInternalState(schemaContext,"entityMetaMap")).isSameAs(entityMetaMap);
assertThat(Whitebox.getInternalState(schemaContext,"keyspaceName")).isEqualTo("keyspace");
assertThat((Boolean)Whitebox.getInternalState(schemaContext,"forceColumnFamilyCreation")).isTrue();
assertThat((Boolean)Whitebox.getInternalState(schemaContext,"hasCounter")).isTrue();
}