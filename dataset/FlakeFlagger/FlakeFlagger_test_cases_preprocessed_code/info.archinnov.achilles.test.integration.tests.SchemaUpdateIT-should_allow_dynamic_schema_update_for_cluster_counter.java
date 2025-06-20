@Test public void should_allow_dynamic_schema_update_for_cluster_counter() throws Exception {
assertThat(pm.find(ClusteredCounterEntityWithNewCounterField.class,new ClusteredCounterEntityWithNewCounterField.Compound(id,date))).isNotNull();
}