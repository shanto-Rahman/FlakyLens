@Test public void testComplexOrthogonalize(){
  short ZERO_INDEX=CircleLookupTable.ZERO_INDEX;
  ComplexVector cv=new ComplexVector(new short[]{ZERO_INDEX,0});
  ComplexVector cv2=new ComplexVector(new short[]{0,0});
  ComplexVectorUtils.renderPairwiseOrthogonal(cv2,cv);
  cv2.normalize();
  assertArrayEquals(new short[]{0,ZERO_INDEX},cv2.getPhaseAngles());
}
