@Test public void verifySupervisorStartsAndStopsDockerContainer() throws Exception {
assertEquals(IMAGE,containerConfig.image());
assertEquals(EXPECTED_CONTAINER_ENV,ImmutableSet.copyOf(containerConfig.env()));
assertEquals(JOB.getId().toShortString(),shortJobIdFromContainerName(containerName));
}