/** 
 * Test RegionInfo serialization
 * @throws Exception
 */
public void testRegionInfo() throws Exception {
assertEquals(hri.getEncodedName(),deserializedHri.getEncodedName());
assertEquals(hri.getTableDesc().getFamilies().size(),deserializedHri.getTableDesc().getFamilies().size());
}