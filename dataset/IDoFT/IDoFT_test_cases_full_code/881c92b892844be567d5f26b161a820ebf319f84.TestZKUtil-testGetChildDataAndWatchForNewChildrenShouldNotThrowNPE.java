/** 
 * Test should not fail with NPE when getChildDataAndWatchForNewChildren invoked with wrongNode
 */
@Test @SuppressWarnings("deprecation") public void testGetChildDataAndWatchForNewChildrenShouldNotThrowNPE() throws Exception {
  ZKUtil.getChildDataAndWatchForNewChildren(ZKW,"/wrongNode");
}
