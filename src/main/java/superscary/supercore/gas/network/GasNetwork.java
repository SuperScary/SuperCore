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

	/**
	 * Gets all possible connections for a {@link GasTransmitter}
	 * @return
	 */
	public List<GasTransmitter> getConnections()
	{
		return connections;
	}

	/**
	 * Adds a connection (usually a pipe) to an already existing network (this instance)
	 * @param gasTransmitter
	 */
	public void addConnection(GasTransmitter gasTransmitter)
	{
		connections.add(gasTransmitter);
	}

	/**
	 * Adds a tank to an already existing network (this instance)
	 * @param tank
	 */
	public void addTankToNetwork(GasTank tank)
	{

	}

	/**
	 * Gets all registered gas networks
	 * @return
	 */
	public static Collection<GasNetwork> getGasNetworks()
	{
		return gasNetworkHashMap.values();
	}

	/**
	 * Gets a Set of network identifiers in the network registry
	 * @return
	 */
	public static Set<Identifier> getRegisteredIdentifiers()
	{
		return gasNetworkHashMap.keySet();
	}

	/**
	 * Removes a network from the registry
	 * @param identifier
	 * @return
	 */
	public static boolean removeNetwork(Identifier identifier)
	{
		gasNetworkHashMap.remove(identifier);
		return gasNetworkHashMap.containsKey(identifier);
	}

	/**
	 * Removes a network from the registry
	 * @param network
	 * @return
	 */
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
