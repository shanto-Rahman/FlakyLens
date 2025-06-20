@Test public void testDedicatedHostPrototypeDedicatedHostByZone() throws Throwable {
assertEquals(dedicatedHostProfileIdentityModel.name(),"mx2-host-152x1216");
assertEquals(resourceGroupIdentityModel.id(),"fee82deba12e4c0fb69c3b09d1f12345");
assertEquals(dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel.name(),"my-host-group");
assertEquals(dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel.resourceGroup(),resourceGroupIdentityModel);
assertEquals(zoneIdentityModel.name(),"us-south-1");
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.instancePlacementEnabled(),Boolean.valueOf(true));
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.name(),"my-host");
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.profile(),dedicatedHostProfileIdentityModel);
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.resourceGroup(),resourceGroupIdentityModel);
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.group(),dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel);
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.zone(),zoneIdentityModel);
assertTrue(dedicatedHostPrototypeDedicatedHostByZoneModelNew instanceof DedicatedHostPrototypeDedicatedHostByZone);
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.instancePlacementEnabled(),Boolean.valueOf(true));
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.name(),"my-host");
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.profile().toString(),dedicatedHostProfileIdentityModel.toString());
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.resourceGroup().toString(),resourceGroupIdentityModel.toString());
assertEquals(JsonParser.parseString(dedicatedHostPrototypeDedicatedHostByZoneModelNew.group().toString()),JsonParser.parseString(dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel.toString()));
assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.zone().toString(),zoneIdentityModel.toString());
}