@Test public void setExpandsData_FixedCapacity(){
assertEquals(b.data,BigInteger.ZERO.setBit(63).longValue());
}