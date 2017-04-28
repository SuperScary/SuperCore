package superscary.supercore.gas.network;

import superscary.supercore.gas.GasTank;
import superscary.supercore.gas.GasTransmitter;
import superscary.supercore.tools.Identifier;
import superscary.supercore.tools.error.NetworkExistsException;

import java.util.*;

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
public class GasNetwork
{

	private static HashMap<Identifier, GasNetwork> gasNetworkHashMap = new HashMap<>();
	private List<GasTransmitter> connections = new ArrayList<>();

	private Identifier identifier;

	public GasNetwork(Identifier identifier)
	{
		this.identifier = identifier;

		try
		{
			if (!gasNetworkHashMap.containsKey(identifier))
			{
				gasNetworkHashMap.put(identifier, this);
			}
			else
			{
				throwException();
			}
		} catch (NetworkExistsException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * TODO: Make a method that'll update the network upon placement of a new network item or removal of a network item
	 * @return
	 */
	public boolean update()
	{

		return false;
	}

	public List<GasTransmitter> getConnections()
	{
		return connections;
	}

	public void addConnection(GasTransmitter gasTransmitter)
	{
		connections.add(gasTransmitter);
	}

	public void addTankToNetwork(GasTank tank)
	{

	}

	public static Collection<GasNetwork> getGasNetworks()
	{
		return gasNetworkHashMap.values();
	}

	public static Set<Identifier> getRegisteredIdentifiers()
	{
		return gasNetworkHashMap.keySet();
	}

	public static boolean removeNetwork(Identifier identifier)
	{
		gasNetworkHashMap.remove(identifier);
		return gasNetworkHashMap.containsKey(identifier);
	}

	public static boolean removeNetwork(HashMap<Identifier, GasNetwork> network)
	{
		gasNetworkHashMap.remove(network.keySet());
		return gasNetworkHashMap.containsKey(network.keySet());
	}

	private static final void throwException() throws NetworkExistsException
	{
		return;
	}

}
