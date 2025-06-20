@Test public void shouldSortFromLowToHigh(){
List<?> priorities=Arrays.asList(MEDIUM_HIGH,HIGH,LOW,MEDIUM,MEDIUM,HIGH,LOW,MEDIUM,HIGH);//RW
assertEquals(Arrays.asList(LOW,LOW,MEDIUM,MEDIUM,MEDIUM,MEDIUM_HIGH,HIGH,HIGH,HIGH),priorities);//RW
}