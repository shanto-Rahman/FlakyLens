@Test public void completingAnOrderUpdatesInventory() throws Exception {
assertThat(publications).hasSize(1);
assertThat(publications).allMatch(it -> it.getEvent() instanceof OrderCompleted);
Thread.sleep(1200);
assertThat(registry.findIncompletePublications()).isEmpty();
}