@Test public void should_get_state() throws Exception {
assertThat(facade.getEntity()).isSameAs(entity);
assertThat(facade.<CompleteBean>getEntityClass()).isSameAs(CompleteBean.class);
assertThat(facade.getEntityMeta()).isSameAs(meta);
assertThat(facade.getIdMeta()).isSameAs(idMeta);
assertThat(facade.getPrimaryKey()).isSameAs(primaryKey);
assertThat(facade.isClusteredCounter()).isTrue();
assertThat(facade.getOptions()).isSameAs(options);
assertThat(facade.getTtl().get()).isEqualTo(9);
assertThat(facade.getTimestamp().get()).isEqualTo(100L);
assertThat(facade.getConsistencyLevel().get()).isEqualTo(LOCAL_ONE);
assertThat(facade.hasCasConditions()).isTrue();
assertThat(facade.getCasConditions()).contains(casCondition);
assertThat(facade.getCASResultListener().get()).isSameAs(listener);
assertThat(facade.getAllCountersMeta()).containsExactly(counterMeta);
assertThat(facade.getAllGettersExceptCounters()).containsExactly(nameMeta.getGetter());
}