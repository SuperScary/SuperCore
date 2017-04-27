package superscary.supercore;

import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;
import superscary.supercore.client.cape.ICoreMod;

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
public class Modification
{

	private ModContainer container;

	public Modification(ModContainer container)
	{
		this.container = container;
	}

	public boolean isAcceptableVersion(ArtifactVersion version)
	{
		return container.acceptableMinecraftVersionRange().containsVersion(version);
	}

	public boolean isAcceptableVersion()
	{
		return isAcceptableVersion(new ArtifactVersion()
		{
			@Override
			public String getLabel()
			{
				return null;
			}

			@Override
			public String getVersionString()
			{
				return "1.11.2-13.20.0.2228";
			}

			@Override
			public boolean containsVersion(ArtifactVersion source)
			{
				return false;
			}

			@Override
			public String getRangeString()
			{
				return null;
			}

			@Override
			public int compareTo(ArtifactVersion o)
			{
				return 0;
			}
		});
	}

	public boolean hasCape()
	{
		for (Class cl : container.getClass().getInterfaces())
		{
			if (cl.equals(ICoreMod.class))
			{
				return true;
			}
		}
		return false;
	}

}
