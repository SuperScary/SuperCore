package superscary.supercore.client.cape;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

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
public class CapeProvider
{

	private static ArrayList<Class<? extends ICoreMod>> provider = new ArrayList<>();
	private static ArrayList<ResourceLocation> locations = new ArrayList<>();

	private Class<? extends ICoreMod> cl;
	private ResourceLocation location;

	public CapeProvider(Class<? extends ICoreMod> cl, ResourceLocation location)
	{
		this.cl = cl;
		this.location = location;

		provider.add(cl);
		locations.add(location);
	}

	public static boolean isProvider(Class<? extends ICoreMod> cl)
	{
		return provider.contains(cl);
	}

	public boolean isLocation(ResourceLocation location)
	{
		return locations.contains(location);
	}

	public static ResourceLocation getLocationFromClass(Class<? extends ICoreMod> cl)
	{
		for (int i = 0; i < provider.size(); i++)
		{
			if (provider.get(i) == cl)
			{
				return locations.get(i);
			}
		}
		return null;
	}

}
