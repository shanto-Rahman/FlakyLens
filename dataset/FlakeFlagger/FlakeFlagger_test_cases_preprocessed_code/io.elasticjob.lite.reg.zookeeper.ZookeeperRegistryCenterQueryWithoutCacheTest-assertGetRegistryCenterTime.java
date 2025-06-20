@Test public void assertGetRegistryCenterTime(){
long regCenterTime=zkRegCenter.getRegistryCenterTime("/_systemTime/current");//RW
assertTrue(regCenterTime <= System.currentTimeMillis());
long updatedRegCenterTime=zkRegCenter.getRegistryCenterTime("/_systemTime/current");//RW
assertTrue(regCenterTime < updatedRegCenterTime);
}