@Test public void testVolumeProvisioningTaskWithSoftAntiaffinity() throws Throwable {
assertNotNull(compositeDesc);
assertEquals(3,compositeDesc.descriptionLinks.size());
assertNotNull(cc.componentLinks);
assertEquals(cc.componentLinks.size(),3);
if (link.startsWith(ContainerVolumeService.FACTORY_LINK)) {
if (containerLink1 == null) {
}
}
assertNotNull(cont1);
assertNotNull(cont2);
assertTrue("Containers should be on the same host.",cont1.parentLink.equals(cont2.parentLink));
assertNotNull(volumeDescProp);
assertEquals("volume customPropertyValue string",volumeDescProp);
assertTrue("Volume is provisioned on wrong host.",volume.originatingHostLink.equals(cont1.parentLink));
assertEquals(cont1.volumes.length,1);
assertTrue("Host volume name is different than Container volume name.",cont1.volumes[0].contains(volume.name));
assertTrue("Volume is provisioned on wrong host.",volume.originatingHostLink.equals(cont2.parentLink));
assertEquals(cont2.volumes.length,1);
assertTrue("Host volume name is different than Container volume name.",cont2.volumes[0].contains(volume.name));
}