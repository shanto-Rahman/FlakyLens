@Test public void testVolumeProvisioningTaskWithProvidedHostIds() throws Throwable {
if (dockerHostDesc.customProperties == null) {
}
assertNotNull(vol1);
assertNotNull(vol2);
assertTrue(hostLinks.contains(vol1.originatingHostLink));
assertTrue(hostLinks.contains(vol2.originatingHostLink));
assertFalse(vol1.originatingHostLink.equals(vol2.originatingHostLink));
}