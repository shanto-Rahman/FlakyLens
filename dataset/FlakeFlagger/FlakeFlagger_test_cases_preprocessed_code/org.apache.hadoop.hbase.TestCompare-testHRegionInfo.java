/** 
 * Sort of HRegionInfo.
 */
public void testHRegionInfo(){
assertTrue(a.compareTo(b) != 0);
assertTrue(a.compareTo(b) < 0);
assertTrue(b.compareTo(a) > 0);
assertEquals(a,a);
assertTrue(a.compareTo(a) == 0);
assertTrue(a.compareTo(b) < 0);
assertTrue(a.compareTo(b) < 0);
assertTrue(a.compareTo(b) < 0);
}