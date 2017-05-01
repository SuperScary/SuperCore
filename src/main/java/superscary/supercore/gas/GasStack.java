package superscary.supercore.gas;

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
@SuppressWarnings("unused")
public class GasStack
{

	public static final int DEFAULT_SIZE = 1;
	public static final int DEFAULT_META = 0;

	private Gas gas;
	private int size;
	private int meta;

	public GasStack(Gas gas, int size, int meta)
	{
		this.gas = gas;
		this.size = size;
		this.meta = meta;
	}

	public GasStack(Gas gas, int size)
	{
		this(gas, size, DEFAULT_META);
	}

	public GasStack(Gas gas)
	{
		this(gas, DEFAULT_SIZE);
	}

	public GasStack getStack()
	{
		return this;
	}

	public Gas getGas()
	{
		return gas;
	}

	public int getSize()
	{
		return size;
	}

	public boolean hasMetadata()
	{
		return meta != 0;
	}

	public int getMetaData()
	{
		return meta;
	}

}
