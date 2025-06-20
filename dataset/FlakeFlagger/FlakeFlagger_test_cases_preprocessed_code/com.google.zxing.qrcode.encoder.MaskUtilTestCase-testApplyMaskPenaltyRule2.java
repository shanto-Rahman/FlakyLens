@Test public void testApplyMaskPenaltyRule2(){
assertEquals(0,MaskUtil.applyMaskPenaltyRule2(matrix));
assertEquals(0,MaskUtil.applyMaskPenaltyRule2(matrix));
assertEquals(3,MaskUtil.applyMaskPenaltyRule2(matrix));
assertEquals(3 * 4,MaskUtil.applyMaskPenaltyRule2(matrix));
}