@Test public void testUnion(){
assertEquals(vertices.get(0).getSlotSharingGroup(),vertices.get(4).getSlotSharingGroup());
assertEquals(vertices.get(2).getSlotSharingGroup(),vertices.get(3).getSlotSharingGroup());
assertEquals(vertices.get(2).getSlotSharingGroup(),vertices.get(5).getSlotSharingGroup());
assertEquals(vertices.get(3).getSlotSharingGroup(),vertices.get(5).getSlotSharingGroup());
}