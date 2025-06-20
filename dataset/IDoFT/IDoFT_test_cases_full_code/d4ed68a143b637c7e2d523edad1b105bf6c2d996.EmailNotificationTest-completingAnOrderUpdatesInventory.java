@Test public void completingAnOrderUpdatesInventory() throws Exception {
  Product product=catalog.findAll().iterator().next();
  Order order=orders.createOrder();
  order.add(product,5);
  orders.complete(order);
  Iterable<EventPublication> publications=registry.findIncompletePublications();
  assertThat(publications).hasSize(1);
  assertThat(publications).allMatch(it -> it.getEvent() instanceof OrderCompleted);
  Thread.sleep(1200);
  assertThat(registry.findIncompletePublications()).isEmpty();
}
