@Test public void testDeploymentPoliciesOnMultipleHostsAndPlacements() throws Throwable {
assertNotNull(task);
assertNotNull(task);
assertNotNull(task.hostSelections);
assertEquals(2,task.hostSelections.size());
assertTrue(expectedHostsList.containsAll(task.hostSelections.stream().map(h -> h.hostLink).collect(Collectors.toList())));
assertNotNull(task);
assertEquals(expectedPlacementLink,task.groupResourcePlacementLink);
assertNotNull(task.hostSelections);
assertEquals(1,task.hostSelections.size());
assertEquals(host6.documentSelfLink,task.hostSelections.get(0).hostLink);
}