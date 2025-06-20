public void testPeriodicity(){
assertEquals(PeriodicityType.TOP_OF_SECOND,rc.computePeriodicityType("yyyy-MM-dd_HH_mm_ss"));
assertEquals(PeriodicityType.TOP_OF_MINUTE,rc.computePeriodicityType("yyyy-MM-dd_HH_mm"));
assertEquals(PeriodicityType.TOP_OF_HOUR,rc.computePeriodicityType("yyyy-MM-dd_HH"));
assertEquals(PeriodicityType.TOP_OF_DAY,rc.computePeriodicityType("yyyy-MM-dd"));
assertEquals(PeriodicityType.TOP_OF_MONTH,rc.computePeriodicityType("yyyy-MM"));
}