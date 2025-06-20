@Test public void multipleShifts_FixedCapacity(){
assertEquals(b.data,BigInteger.ZERO.setBit(10).shiftLeft(2).shiftLeft(2).longValue());
}