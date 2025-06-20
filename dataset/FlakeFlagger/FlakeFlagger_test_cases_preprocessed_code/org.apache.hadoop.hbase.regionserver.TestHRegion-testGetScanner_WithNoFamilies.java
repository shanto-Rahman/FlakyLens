public void testGetScanner_WithNoFamilies() throws IOException {
assertEquals(1,((RegionScanner)is).getStoreHeap().getHeap().size());
assertEquals(families.length - 1,((RegionScanner)is).getStoreHeap().getHeap().size());
}