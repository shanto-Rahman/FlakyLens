@Test public void turboFilterStopOnReset(){
assertTrue(nopTF.isStarted());
assertFalse(nopTF.isStarted());
}