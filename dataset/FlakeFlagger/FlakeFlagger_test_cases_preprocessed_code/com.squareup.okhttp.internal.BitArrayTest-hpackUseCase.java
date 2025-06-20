/** 
 * Lazy grow into a variable capacity bit set. 
 */
@Test public void hpackUseCase(){
assertTrue(b.get(0));
assertTrue(b.get(1));
assertTrue(b.get(63));
fail();
assertTrue(b.get(0));
assertTrue(b.get(1));
assertTrue(b.get(63));
assertFalse(b.get(64));
assertTrue(b.get(64));
}