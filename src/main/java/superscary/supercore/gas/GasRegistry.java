package superscary.supercore.gas;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

/**
 * Copyright (c) 2017 by SuperScary(ERBF) http://codesynced.com
 * <p>
 * All rights reserved. No part of this software may be reproduced,
 * distributed, or transmitted in any form or by any means, including
 * photocopying, recording, or other electronic or mechanical methods,
 * without the prior written permission of the publisher, except in
 * the case of brief quotations embodied in critical reviews and
 * certain other noncommercial uses permitted by copyright law.
 */
public class GasRegistry
{

	private static HashMap<GasStack, ResourceLocation> gasStackResourceLocationHashMap = new HashMap<>();

	public static void register(GasStack stack, ResourceLocation location)
	{
		gasStackResourceLocationHashMap.put(stack, location);
	}

}
