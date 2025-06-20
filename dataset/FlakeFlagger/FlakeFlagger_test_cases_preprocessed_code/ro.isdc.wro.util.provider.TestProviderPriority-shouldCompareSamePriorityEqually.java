@Test public void shouldCompareSamePriorityEqually(){
assertEquals(0,Ordered.ASCENDING_COMPARATOR.compare(LOW,LOW));//RW
assertEquals(0,Ordered.ASCENDING_COMPARATOR.compare(MEDIUM,MEDIUM));//RW
assertEquals(0,Ordered.ASCENDING_COMPARATOR.compare(HIGH,HIGH));//RW
}