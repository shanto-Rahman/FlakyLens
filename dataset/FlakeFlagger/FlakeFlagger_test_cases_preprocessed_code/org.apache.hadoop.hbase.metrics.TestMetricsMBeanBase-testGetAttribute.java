public void testGetAttribute() throws Exception {
assertEquals(2.0,(Float)this.stats.getAttribute("metricsRate"),0.001);
assertEquals(5,this.stats.getAttribute("intValue"));
assertEquals(10L,this.stats.getAttribute("varyRateMinTime"));
assertEquals(50L,this.stats.getAttribute("varyRateMaxTime"));
assertEquals(30L,this.stats.getAttribute("varyRateAvgTime"));
assertEquals(2,this.stats.getAttribute("varyRateNumOps"));
}