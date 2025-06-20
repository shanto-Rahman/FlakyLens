@Test public void testSuccessCriteria(){
assertTrue(rs1.isSuccessFactorMet());
assertFalse(rs1.isSuccessFactorMet());
assertTrue(rs2.isSuccessFactorMet());
assertTrue(rs2.isSuccessFactorMet());
assertFalse(rs3.isSuccessFactorMet());
assertFalse(rs3.isSuccessFactorMet());
}