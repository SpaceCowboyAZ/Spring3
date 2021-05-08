package jeep.controller.support;

public class CreateOrderTestSupport extends baseTest {
	/**
	 * 
	 */
	protected String createOrderBody() {
		return "{ \r\n"
				+ "\r\n"
				+ "  \"customer\":\"MORISON_LINA\", \r\n"
				+ "\r\n"
				+ "  \"model\":\"WRANGLER\", \r\n"
				+ "\r\n"
				+ "  \"trim\":\"Sport Altitude\", \r\n"
				+ "\r\n"
				+ "  \"doors\":4, \r\n"
				+ "\r\n"
				+ "  \"color\":\"EXT_NACHO\", \r\n"
				+ "\r\n"
				+ "  \"engine\":\"2_0_TURBO\", \r\n"
				+ "\r\n"
				+ "  \"tire\":\"35_TOYO\", \r\n"
				+ "\r\n"
				+ "  \"options\":[ \r\n"
				+ "\r\n"
				+ "    \"DOOR_QUAD_4\", \r\n"
				+ "\r\n"
				+ "    \"EXT_AEV_LIFT\", \r\n"
				+ "\r\n"
				+ "    \"EXT_WARN_WINCH\", \r\n"
				+ "\r\n"
				+ "    \"EXT_WARN_BUMPER_FRONT\", \r\n"
				+ "\r\n"
				+ "    \"EXT_WARN_BUMPER_REAR\", \r\n"
				+ "\r\n"
				+ "    \"EXT_ARB_COMPRESSOR\" \r\n"
				+ "\r\n"
				+ "  ] \r\n"
				+ "\r\n"
				+ "} ";
	}
}
