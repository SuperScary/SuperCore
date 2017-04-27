package superscary.supercore.gas.network;

import superscary.supercore.gas.GasTank;
import superscary.supercore.gas.GasTransmitter;
import superscary.supercore.tools.Identifier;

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
public class GasNetwork
{

	private static HashMap<Identifier, GasNetwork> gasNetworkHashMap = new HashMap<>();
	private List<GasTransmitter> connections = new ArrayList<>();

	private Identifier identifier;

	public GasNetwork(Identifier identifier)
	{
		this.identifier = identifier;
		gasNetworkHashMap.put(identifier, this);
	}

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

}
