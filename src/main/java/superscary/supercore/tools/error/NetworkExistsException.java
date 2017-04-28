package superscary.supercore.tools.error;

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
public class NetworkExistsException extends Exception
{

	public NetworkExistsException()
	{
		super();
	}

	public NetworkExistsException(String par1Str)
	{
		super(par1Str);
	}

	public NetworkExistsException(String par1Str, Throwable par2Throwable)
	{
		super(par1Str, par2Throwable);
	}

	public NetworkExistsException(Throwable par1Throwable)
	{
		super(par1Throwable);
	}

	public NetworkExistsException(String par1Str, Throwable par2Throwable, boolean par3Bool, boolean par4Bool)
	{
		super(par1Str, par2Throwable, par3Bool, par4Bool);
	}

}
