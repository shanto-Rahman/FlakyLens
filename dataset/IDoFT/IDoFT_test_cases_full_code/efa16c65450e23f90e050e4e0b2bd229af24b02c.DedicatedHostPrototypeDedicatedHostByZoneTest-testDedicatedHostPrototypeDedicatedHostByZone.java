@Test public void testDedicatedHostPrototypeDedicatedHostByZone() throws Throwable {
  DedicatedHostProfileIdentityByName dedicatedHostProfileIdentityModel=new DedicatedHostProfileIdentityByName.Builder().name("mx2-host-152x1216").build();
  assertEquals(dedicatedHostProfileIdentityModel.name(),"mx2-host-152x1216");
  ResourceGroupIdentityById resourceGroupIdentityModel=new ResourceGroupIdentityById.Builder().id("fee82deba12e4c0fb69c3b09d1f12345").build();
  assertEquals(resourceGroupIdentityModel.id(),"fee82deba12e4c0fb69c3b09d1f12345");
  DedicatedHostGroupPrototypeDedicatedHostByZoneContext dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel=new DedicatedHostGroupPrototypeDedicatedHostByZoneContext.Builder().name("my-host-group").resourceGroup(resourceGroupIdentityModel).build();
  assertEquals(dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel.name(),"my-host-group");
  assertEquals(dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel.resourceGroup(),resourceGroupIdentityModel);
  ZoneIdentityByName zoneIdentityModel=new ZoneIdentityByName.Builder().name("us-south-1").build();
  assertEquals(zoneIdentityModel.name(),"us-south-1");
  DedicatedHostPrototypeDedicatedHostByZone dedicatedHostPrototypeDedicatedHostByZoneModel=new DedicatedHostPrototypeDedicatedHostByZone.Builder().instancePlacementEnabled(true).name("my-host").profile(dedicatedHostProfileIdentityModel).resourceGroup(resourceGroupIdentityModel).group(dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel).zone(zoneIdentityModel).build();
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.instancePlacementEnabled(),Boolean.valueOf(true));
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.name(),"my-host");
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.profile(),dedicatedHostProfileIdentityModel);
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.resourceGroup(),resourceGroupIdentityModel);
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.group(),dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel);
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModel.zone(),zoneIdentityModel);
  String json=TestUtilities.serialize(dedicatedHostPrototypeDedicatedHostByZoneModel);
  DedicatedHostPrototypeDedicatedHostByZone dedicatedHostPrototypeDedicatedHostByZoneModelNew=TestUtilities.deserialize(json,DedicatedHostPrototypeDedicatedHostByZone.class);
  assertTrue(dedicatedHostPrototypeDedicatedHostByZoneModelNew instanceof DedicatedHostPrototypeDedicatedHostByZone);
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.instancePlacementEnabled(),Boolean.valueOf(true));
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.name(),"my-host");
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.profile().toString(),dedicatedHostProfileIdentityModel.toString());
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.resourceGroup().toString(),resourceGroupIdentityModel.toString());
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.group().toString(),dedicatedHostGroupPrototypeDedicatedHostByZoneContextModel.toString());
  assertEquals(dedicatedHostPrototypeDedicatedHostByZoneModelNew.zone().toString(),zoneIdentityModel.toString());
}
