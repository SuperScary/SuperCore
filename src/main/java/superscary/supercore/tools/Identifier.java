package superscary.supercore.tools;

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
@SuppressWarnings("unused")
public class Identifier
{

	private static HashMap<Object, String> index = new HashMap<>();

	private Object obj;
	private String id;

	public Identifier(Object par1Obj, String par2Str)
	{
		this.obj = par1Obj;
		this.id = par2Str;
		index.put(par1Obj, par2Str);
	}

	public Identifier(Object par1Obj, int par2Int)
	{
		this(par1Obj, "" + par2Int);
	}

	public String getId()
	{
		return id;
	}

	public Object getObj()
	{
		return obj;
	}

	public static boolean hasMapping(Object obj)
	{
		if (index.containsKey(obj)) return true;
		return false;
	}

}
