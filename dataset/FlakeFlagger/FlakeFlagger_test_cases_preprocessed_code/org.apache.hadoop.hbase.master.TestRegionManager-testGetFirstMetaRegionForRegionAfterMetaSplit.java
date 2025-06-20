public void testGetFirstMetaRegionForRegionAfterMetaSplit() throws Exception {
assertEquals(metaRegionInfo1.getStartKey(),master.getRegionManager().getFirstMetaRegionForRegion(regionInfoX).getStartKey());
assertEquals(metaRegionInfo1.getRegionName(),master.getRegionManager().getFirstMetaRegionForRegion(regionInfoX).getRegionName());
}