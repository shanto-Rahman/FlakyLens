@Test public void upgrade() throws Exception {
assertThat(collection.count()).withFailMessage("No document should be deleted by the migration!").isEqualTo(count);
assertThat(collection.count(Filters.exists("default"))).withFailMessage("The migration should have deleted the \"default\" field from the documents!").isEqualTo(0L);
assertThat(clusterConfigService.get(DefaultIndexSetConfig.class)).withFailMessage("The DefaultIndexSetConfig should have been written to cluster config!").isNotNull();
assertThat(clusterConfigService.get(DefaultIndexSetConfig.class).defaultIndexSetId()).isEqualTo("57f3d721a43c2d59cb750001");
assertThat(migrationCompleted).isNotNull();
assertThat(migrationCompleted.indexSetIds()).containsExactly("57f3d721a43c2d59cb750001","57f3d721a43c2d59cb750003");
}