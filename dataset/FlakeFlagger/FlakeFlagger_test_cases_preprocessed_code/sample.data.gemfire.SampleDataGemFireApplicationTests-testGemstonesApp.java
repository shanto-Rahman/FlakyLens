@Test public void testGemstonesApp(){
assertEquals(0,this.gemstoneService.count());
assertTrue(asList(this.gemstoneService.list()).isEmpty());
assertEquals(2,this.gemstoneService.count());
assertTrue(asList(this.gemstoneService.list()).containsAll(getGemstones("Diamond","Ruby")));
assertEquals(2,this.gemstoneService.count());
assertTrue(asList(this.gemstoneService.list()).containsAll(getGemstones("Diamond","Ruby")));
assertEquals(4,this.gemstoneService.count());
assertTrue(asList(this.gemstoneService.list()).containsAll(getGemstones("Diamond","Ruby","Pearl","Sapphire")));
assertEquals(4,this.gemstoneService.count());
assertTrue(asList(this.gemstoneService.list()).containsAll(getGemstones("Diamond","Ruby","Pearl","Sapphire")));
assertEquals(createGemstone("Diamond"),this.gemstoneService.get("Diamond"));
assertEquals(createGemstone("Pearl"),this.gemstoneService.get("Pearl"));
}