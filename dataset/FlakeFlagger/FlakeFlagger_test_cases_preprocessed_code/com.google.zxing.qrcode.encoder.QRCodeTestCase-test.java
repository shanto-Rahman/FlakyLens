@Test public void test(){
assertSame(Mode.BYTE,qrCode.getMode());
assertSame(ErrorCorrectionLevel.H,qrCode.getECLevel());
assertEquals(7,qrCode.getVersion().getVersionNumber());
assertEquals(3,qrCode.getMaskPattern());
assertSame(matrix,qrCode.getMatrix());
}